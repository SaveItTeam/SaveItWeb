package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.dao.Api;
import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import br.com.example.saveit.saveitweb.model.imagem.ImagemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@WebServlet("/adicionarFuncionarioServlet")
@MultipartConfig
public class AdicionarFuncionarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        // Verificar se está logado
        if (sessao.getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // Obter dados do formulário
            String nome = request.getParameter("inputNome");
            String cargo = request.getParameter("inputCargo");
            String genero = request.getParameter("inputSelect");
            String email = request.getParameter("inputEmail");
            String telefone_pessoal = request.getParameter("inputTel");
            String dataContratacaoStr = request.getParameter("inputStatus");
            String cpf = request.getParameter("inputCpf");
            String rg = request.getParameter("inputRg");
            String dt_nascimentoStr = request.getParameter("inputDtNascimento");

            // Obter ID da indústria do admin logado
            int idIndustria = (int) sessao.getAttribute("id_estabelecimento");

            // Validar campos obrigatórios
            if (nome == null || nome.trim().isEmpty() ||
                    cargo == null || cargo.trim().isEmpty() ||
                    email == null || email.trim().isEmpty()) {
                request.setAttribute("error", "Nome, cargo e email são obrigatórios!");
                request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
                return;
            }

            // Converter data de contratação
            Date dataContratacao = null;
            if (dataContratacaoStr != null && !dataContratacaoStr.trim().isEmpty()) {
                dataContratacao = Date.valueOf(dataContratacaoStr);
            }

            Date dataNascimeto = null;
            if (dt_nascimentoStr != null && !dt_nascimentoStr.trim().isEmpty()) {
                dataNascimeto = Date.valueOf(dt_nascimentoStr);
            }

            // Gerar senha padrão (CPF ou data de nascimento)
            String senhaPadrao = cpf;
            Hash hash = new Hash();
            String senhaHash = hash.hashar(senhaPadrao);

            // Criar e salvar funcionário
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario funcionario = new Funcionario();

            funcionario.setNome(nome.trim());
            funcionario.setCpf(cpf != null ? cpf.trim() : null);
            funcionario.setRg(rg != null ? rg.trim() : null);
            funcionario.setCargo(cargo.trim());
            funcionario.setGenero(genero != null ? genero.charAt(0) : 'O');
            funcionario.setEmail(email.trim());
            funcionario.setTelefone_pessoal(telefone_pessoal != null ? telefone_pessoal.trim() : null);
            funcionario.setTelefone_trabalho((String) sessao.getAttribute("telefone_trabalho"));
            funcionario.setDt_contratacao(dataContratacao);
            funcionario.setDt_nascimento(dataNascimeto);
            funcionario.setId_industria(idIndustria);
            funcionario.setSenha(senhaHash);
            funcionario.setIs_admin(false); // Novo funcionário não é admin

            // Inserir no banco
            boolean funcionarioSalvo = funcionarioDAO.inserirFuncionarioIndustria(funcionario);

            if (funcionarioSalvo) {
                // Buscar ID do funcionário recém-criado
                List<Funcionario> funcionarios = funcionarioDAO.buscarPorEmail(email);
                if (!funcionarios.isEmpty()) {
                    Funcionario funcionarioCriado = funcionarios.get(0);
                    int idNovoFuncionario = funcionarioCriado.getId();

                    // Processar imagem se foi enviada
                    Part filePart = request.getPart("inputFile");
                    if (filePart != null && filePart.getSize() > 0) {
                        InputStream fileContent = filePart.getInputStream();
                        byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                        ImagemDAO imagemDAO = new ImagemDAO();
                        imagemDAO.salvarImagemFuncionario(imagemBytes, idNovoFuncionario);
                    }

                    // Enviar dados para API
                    Api api = new Api();
                    api.enviarDados("funcionario", funcionarioCriado.toString());

                    // Atualizar lista de funcionários na sessão
                    List<Funcionario> listaFuncionarios = funcionarioDAO.buscarTodosPorIndustria(idIndustria);
                    sessao.setAttribute("funcionarios", listaFuncionarios);

                    request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Erro ao adicionar funcionário!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao adicionar funcionário: " + e.getMessage());
        }
    }
}
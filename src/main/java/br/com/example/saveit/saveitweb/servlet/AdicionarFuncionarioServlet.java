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
import java.util.regex.Pattern;

@WebServlet("/adicionarFuncionarioServlet")
@MultipartConfig
public class AdicionarFuncionarioServlet extends HttpServlet {

    // Regex para validação de CPF e Telefone
    private static final Pattern cpfPattern = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$");
    private static final Pattern telefonePattern = Pattern.compile("^(\\(?\\d{2}\\)?\\s?)?\\d{4,5}-?\\d{4}$");

    private boolean validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return true; // CPF é opcional
        }
        return cpfPattern.matcher(cpf.trim()).matches();
    }

    private boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return true; // Telefone é opcional
        }
        return telefonePattern.matcher(telefone.trim()).matches();
    }

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
            if (nome == null || nome.trim().isEmpty()) {
                throw new Exception("Nome é obrigatório!");
            }
            if (cargo == null || cargo.trim().isEmpty()) {
                throw new Exception("Cargo é obrigatório!");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Email é obrigatório!");
            }

            // Validar CPF
            if (cpf != null && !cpf.trim().isEmpty() && !validarCpf(cpf)) {
                throw new Exception("CPF inválido! (formato esperado: xxx.xxx.xxx-xx)");
            }

            // Validar telefone
            if (telefone_pessoal != null && !telefone_pessoal.trim().isEmpty() && !validarTelefone(telefone_pessoal)) {
                throw new Exception("Telefone inválido! (formato esperado: (xx) xxxxx-xxxx)");
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
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
        }
    }
}
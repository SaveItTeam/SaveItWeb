package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.cliente.Cliente;
import br.com.example.saveit.saveitweb.model.cliente.ClienteDAO;
import br.com.example.saveit.saveitweb.model.endereco.EnderecoDAO;
import br.com.example.saveit.saveitweb.model.imagem.ImagemDAO;
import br.com.example.saveit.saveitweb.model.industria.IndustriaDAO;
import br.com.example.saveit.saveitweb.model.telefone.TelefoneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@WebServlet("/EditarIndustria")
@MultipartConfig
public class EditarIndustriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        IndustriaDAO industriaDAO = new IndustriaDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        ImagemDAO imagemDAO = new ImagemDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        if (admin != null) {
            try {
                // Converter String para Integer
                String endereco_id_string = (String) sessao.getAttribute("endereco_id");
                int endereco_id = Integer.parseInt(endereco_id_string);

                // Converter id_estabelecimento
                int id_estabelecimento_str = (int) sessao.getAttribute("id_estabelecimento");
                int id_industria = Integer.parseInt(String.valueOf(id_estabelecimento_str));

                // Atributos novos
                String nomeNovo = request.getParameter("inputNome");
                String estadoNovo = request.getParameter("inputEstado");
                String cidadeNova = request.getParameter("inputCidade");
                String cepNovo = request.getParameter("inputCep");
                String bairroNovo = request.getParameter("inputBairro");
                String contatoNovo = request.getParameter("inputContato");
                String operacaoNova = request.getParameter("inputOperacao");
                String ruaNova = request.getParameter("inputRua");
                String complementoNovo = request.getParameter("inputComplemento");
                String categoriaNova = request.getParameter("categoria-radio");

                // Atributos antigos
                String nome = (String) sessao.getAttribute("nome");
                String estado = (String) sessao.getAttribute("estado");
                String cidade = (String) sessao.getAttribute("cidade");
                String cep = (String) sessao.getAttribute("cep");
                String bairro = (String) sessao.getAttribute("bairro");
                String contato = (String) sessao.getAttribute("contato");
                String operacao = (String) sessao.getAttribute("tipo_venda");
                String rua = (String) sessao.getAttribute("rua");
                String complemento = (String) sessao.getAttribute("complemento");
                String categoria = (String) sessao.getAttribute("categoria");

                // Mudando a foto
                Part filePart = request.getPart("arquivo");
                if (filePart != null && filePart.getSize() > 0) {
                    InputStream fileContent = filePart.getInputStream();
                    byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                    // Se for uma indústria, use salvarImagemEmpresa com o id do cliente
                    String cnpj = (String) sessao.getAttribute("cnpj");
                    Cliente clientes = clienteDAO.buscarPorCNPJ(cnpj);
                    int idCliente = clientes.getId();
                    imagemDAO.salvarImagemEmpresa(imagemBytes, idCliente);

                    // Atualizar imagem na sessão
                    String imagemBytesString = Base64.getEncoder().encodeToString(imagemBytes);
                    sessao.setAttribute("img", "data:image/jpeg;base64," + imagemBytesString);
                    sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBytesString);
                    sessao.setAttribute("img_empresa", "data:image/jpeg;base64," + imagemBytesString);
                }

                // Telefone
                if (contatoNovo != null && !contatoNovo.trim().isEmpty() && !contatoNovo.equals(contato)) {
                    // CORREÇÃO: Converter id da sessão corretamente
                    String id_str = (String) sessao.getAttribute("id");
                    int id = Integer.parseInt(id_str);
                    telefoneDAO.alterarTelefone(contatoNovo, id);
                    sessao.setAttribute("contato", contatoNovo);
                }

                // Industria
                if (categoriaNova != null && !categoriaNova.trim().isEmpty() && !categoriaNova.equals(categoria)) {
                    industriaDAO.alterarVenda(categoriaNova, id_industria);
                    sessao.setAttribute("categoria", categoriaNova);
                }

                // Endereco
                if (estadoNovo != null && !estadoNovo.trim().isEmpty() && !estado.equals(estado)) {
                    enderecoDAO.alterarEstado(estadoNovo, endereco_id);
                    sessao.setAttribute("estado", estadoNovo);
                }
                if (cidadeNova != null && !cidadeNova.trim().isEmpty() && !cidadeNova.equals(cidade)) {
                    enderecoDAO.alterarCidade(cidadeNova, endereco_id);
                    sessao.setAttribute("cidade", cidadeNova);
                }
                if (cepNovo != null && !cepNovo.trim().isEmpty() && !cepNovo.equals(cep)) {
                    enderecoDAO.alterarCep(cepNovo, endereco_id);
                    sessao.setAttribute("cep", cepNovo);
                }
                if (bairroNovo != null && !bairroNovo.trim().isEmpty() && !bairro.equals(bairro)) {
                    enderecoDAO.alterarBairro(bairroNovo, endereco_id);
                    sessao.setAttribute("bairro", bairroNovo);
                }
                if (ruaNova != null && !ruaNova.trim().isEmpty() && !ruaNova.equals(rua)) {
                    enderecoDAO.alterarRua(ruaNova, endereco_id);
                    sessao.setAttribute("rua", ruaNova);
                }
                if (complementoNovo != null && !complementoNovo.trim().isEmpty() && !complementoNovo.equals(complemento)) {
                    enderecoDAO.alterarComplemento(complementoNovo, endereco_id);
                    sessao.setAttribute("complemento", complementoNovo);
                }

                // Cliente
                Cliente clientes = clienteDAO.buscarPorID(id_industria);
                if (nomeNovo != null && !nomeNovo.trim().isEmpty() && !nomeNovo.equals(nome)) {
                    clienteDAO.alterarNome(nomeNovo, clientes.getId());
                    sessao.setAttribute("nome", nomeNovo);
                    sessao.setAttribute("nome_industria", nomeNovo);
                }
                if (operacaoNova != null && !operacaoNova.trim().isEmpty() && !operacaoNova.equals(operacao)) {
                    clienteDAO.alterarTipoVenda(operacaoNova, clientes.getId());
                    sessao.setAttribute("tipo_venda", operacaoNova);
                }
            } finally {

            }

                request.getRequestDispatcher("/WEB-INF/view/admin/industria.jsp").forward(request, response);


        }
    }
}
package br.com.example.saveit.saveitweb.servlet;

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
//                    Atributos novos
                    int id = Integer.parseInt(request.getParameter("id"));
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



//                    Atributos antigos
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

//                    Mudando a foto
                    Part filePart = request.getPart("arquivo");
                    if (filePart != null && filePart.getSize() > 0) {
                        InputStream fileContent = filePart.getInputStream();
                        byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                        // Atualizar imagem no banco de dados
                        imagemDAO.salvarImagemFuncionario(imagemBytes, id);

                        // Atualizar imagem na sessão (convertendo para Base64 para exibição)
                        String imagemBytesString = Base64.getEncoder().encodeToString(imagemBytes);
                        // Atualizar ambas as chaves na sessão
                        sessao.setAttribute("img", "data:image/jpeg;base64," + imagemBytesString);
                        sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBytesString);
                    }

    //            Telefone
                    if (contatoNovo != null && !contatoNovo.trim().isEmpty() && !contatoNovo.equals(contato)){
                        telefoneDAO.alterarTelefone(contatoNovo, (int) sessao.getAttribute("id"));
                        sessao.setAttribute("contato", contatoNovo);
                    }

//                    Industria
                    if (nomeNovo != null && !nomeNovo.trim().isEmpty() && !nomeNovo.equals(nome)){
                        industriaDAO.alterarNome(nomeNovo, (int) sessao.getAttribute("id_estabelecimento"));
                        sessao.setAttribute("nome", nomeNovo);
                    }
                    if (categoriaNova != null && !categoriaNova.trim().isEmpty() && !categoriaNova.equals(categoria)){
                        industriaDAO.alterarVenda(categoriaNova, (int) sessao.getAttribute("id_estabelecimento"));
                        sessao.setAttribute("categoria", categoriaNova);
                    }

//                    Endereco
                    if (estadoNovo != null && !estadoNovo.trim().isEmpty() && !estado.equals(estado)) {
                        enderecoDAO.alterar("cep_estado", request.getParameter("selectEstado"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("estado", estadoNovo);
                    }
                    if (cidadeNova != null && !cidadeNova.trim().isEmpty() && !cidadeNova.equals(cidade)){
                        enderecoDAO.alterar("cep_cidade", request.getParameter("inputCidade"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("cidade", cidadeNova);
                    }
                    if (cepNovo != null && !cepNovo.trim().isEmpty() && !cepNovo.equals(cep)){
                        enderecoDAO.alterar("cep", request.getParameter("inputCep"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("cep", cepNovo);
                    }
                    if (bairroNovo != null && !bairroNovo.trim().isEmpty() && !bairro.equals(bairro)){
                        enderecoDAO.alterar("cep_bairro", request.getParameter("inputBairro"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("bairro", bairroNovo);
                    }
                    if (ruaNova != null && !ruaNova.trim().isEmpty() && !ruaNova.equals(rua)) {
                        enderecoDAO.alterar("cep_rua", request.getParameter("inputRua"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("rua", ruaNova);
                    }
                    if (complementoNovo != null && !complementoNovo.trim().isEmpty() && !complementoNovo.equals(complemento)) {
                        enderecoDAO.alterar("cep_complemento", request.getParameter("inputComplemento"), "id", (int) sessao.getAttribute("endereco_id"));
                        sessao.setAttribute("complemento", complementoNovo);
                    }


//                    Cliente
                    if (operacaoNova != null && !operacaoNova.trim().isEmpty() && !operacaoNova.equals(operacao)) {
                        clienteDAO.alterarTipoVenda(operacaoNova, id);
                        sessao.setAttribute("tipo_venda", operacaoNova);
                    }
                    request.getRequestDispatcher("/WEB-INF/view/admin/industria.jsp").forward(request, response);
                } catch (NumberFormatException  nfe) {
                    nfe.printStackTrace();
            }
        }
    }
}

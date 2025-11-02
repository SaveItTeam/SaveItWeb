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


        if (admin != null) {
                try {

                    int id = Integer.parseInt(request.getParameter("id"));

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
                    telefoneDAO.alterarTelefone(request.getParameter("inputContato"), Integer.parseInt(request.getParameter("id")));

//                    Industria
                    industriaDAO.alterar("nome", request.getParameter("inputNome"), "id", Integer.parseInt(request.getParameter("id")));
                    industriaDAO.alterar("vende", request.getParameter("categoria-radio"), "id", Integer.parseInt(request.getParameter("id")));

//                    Endereco
                    enderecoDAO.alterar("cep_estado", request.getParameter("selectEstado"), "id", Integer.parseInt(request.getParameter("id")));
                    enderecoDAO.alterar("cep_cidade", request.getParameter("inputCidade"), "id", Integer.parseInt(request.getParameter("id")));
                    enderecoDAO.alterar("cep", request.getParameter("inputCep"), "id", Integer.parseInt(request.getParameter("id")));
                    enderecoDAO.alterar("cep_bairro", request.getParameter("inputBairro"), "id", Integer.parseInt(request.getParameter("id")));
                    enderecoDAO.alterar("cep_rua", request.getParameter("inputRua"), "id", Integer.parseInt(request.getParameter("id")));
                    enderecoDAO.alterar("cep_complemento", request.getParameter("inputComplemento"), "id", Integer.parseInt(request.getParameter("id")));
                } catch (NumberFormatException  nfe) {
                    nfe.printStackTrace();
            }
        }
    }
}

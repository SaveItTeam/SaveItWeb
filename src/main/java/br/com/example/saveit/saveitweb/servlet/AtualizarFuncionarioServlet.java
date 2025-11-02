package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import br.com.example.saveit.saveitweb.model.imagem_funcionario.ImagemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/atualizarFuncionarioServlet")
public class AtualizarFuncionarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ImagemDAO imagemDAO = new ImagemDAO();

        if (admin != null){
            try {
                int id = Integer.parseInt(request.getParameter("inputId2"));

                Part filePart = request.getPart("arquivo");
                if (filePart != null && filePart.getSize() > 0) {
                    InputStream fileContent = filePart.getInputStream();
                    byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                    // Atualizar imagem no banco de dados
                    imagemDAO.salvarImagemFuncionario(imagemBytes, id);

                    // Atualizar imagem na sessão (convertendo para Base64 para exibição)
                    String imagemBytesString = java.util.Base64.getEncoder().encodeToString(imagemBytes);
                    // Atualizar ambas as chaves na sessão
                    sessao.setAttribute("img", "data:image/jpeg;base64," + imagemBytesString);
                    sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBytesString);
                }

                String novoNome = request.getParameter("inputNome2");
                funcionarioDAO.alterarNome(novoNome, id);

                String novoCargo = request.getParameter("inputCargo2");
                funcionarioDAO.alterarCargo(novoCargo, id);

                String novoEmail = request.getParameter("inputEmail2");
                funcionarioDAO.alterarEmail(novoEmail, id);

                String novoTelefone = request.getParameter("inputTel2");
                funcionarioDAO.alterarTelefone(novoTelefone, id);

                request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import br.com.example.saveit.saveitweb.model.imagem_funcionario.ImagemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/atualizarFuncionarioServlet")
@MultipartConfig
public class AtualizarFuncionarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        // Verificar se está logado
        if (sessao.getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // Pegar ID do funcionário
            int id = Integer.parseInt(request.getParameter("inputId2"));

            // Atualizar dados do funcionário
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.alterarNome(request.getParameter("inputNome2"), id);
            funcionarioDAO.alterarCargo(request.getParameter("inputCargo2"), id);
            funcionarioDAO.alterarEmail(request.getParameter("inputEmail2"), id);
            funcionarioDAO.alterarTelefone(request.getParameter("inputTel2"), id);

            // Processar imagem se foi enviada
            Part filePart = request.getPart("inputFile2");
            if (filePart != null && filePart.getSize() > 0) {
                InputStream fileContent = filePart.getInputStream();
                byte[] imagemBytes = IOUtils.toByteArray(fileContent);

                ImagemDAO imagemDAO = new ImagemDAO();
                imagemDAO.salvarImagemFuncionario(imagemBytes, id);

                // Atualizar na sessão
                String imagemBase64 = java.util.Base64.getEncoder().encodeToString(imagemBytes);
                sessao.setAttribute("img_funcionario", "data:image/jpeg;base64," + imagemBase64);
            }

            // Redirecionar
            request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao atualizar funcionário");
            request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
        }
    }
}
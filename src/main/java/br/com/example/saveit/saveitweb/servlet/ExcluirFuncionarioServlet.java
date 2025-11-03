package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import br.com.example.saveit.saveitweb.model.imagem.ImagemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/excluirFuncionarioServlet")
public class ExcluirFuncionarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ImagemDAO imagemDAO = new ImagemDAO();

        if (admin != null) {
            try {

                int id = Integer.parseInt(request.getParameter("idFuncionario"));

                imagemDAO.excluirPorId(id);
                funcionarioDAO.excluiPorId(id);

                int count = (int) sessao.getAttribute("count");
                count = count - 1;
                sessao.setAttribute("count", count);

                request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
            } catch (ServletException | IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
}

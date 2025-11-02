package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/exluirFuncionarioServlet")
public class ExcluirFuncionarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (admin == null) {
            try {
                int id = Integer.parseInt(request.getParameter("inputId2"));
                funcionarioDAO.excluiPorId(id);

                request.getRequestDispatcher("/WEB-INF/jsp/editarFuncionario.jsp").forward(request, response);
            } catch (ServletException | IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
}

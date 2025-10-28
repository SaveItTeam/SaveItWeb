package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logarFuncionarioAdmin")
public class LogarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        String emailOUcpf = request.getParameter("email");
        String senha = request.getParameter("senha");

        Object admin = funcionarioDAO.logarFuncionarioAdmin(emailOUcpf, senha);

        if (admin != null) {
            try {
                request.getSession().setAttribute("admin", admin);
//                response.sendRedirect("/WEB-INF/view/admin/inicio.jsp");
                request.getRequestDispatcher("/WEB-INF/view/admin/inicio.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("error", "Credenciais inválidas");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

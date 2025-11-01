package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");

        if (admin != null) {
            try {

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

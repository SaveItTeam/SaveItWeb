package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LogarFuncionario")
public class LogarFuncionario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (funcionarioDAO.logarFuncionario(email, senha) != null) {
            response.getWriter().println("Login bem-sucedido!");
        } else {
            response.getWriter().println("Falha no login. Verifique suas credenciais.");
        }

    }
}

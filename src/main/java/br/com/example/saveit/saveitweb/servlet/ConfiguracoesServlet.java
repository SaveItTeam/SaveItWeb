package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/configuracoesServlet")
public class ConfiguracoesServlet extends HttpServlet {
    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");

        if (admin != null) {
        try {
            request.getRequestDispatcher("/WEB-INF/view/admin/configuracoes.jsp").forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();}
        }

    }
}

package br.com.example.saveit.saveitweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/industriaServlet")
public class IndustriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");

        if (admin != null) {
            try {

                request.getRequestDispatcher("/WEB-INF/view/admin/industria.jsp").forward(request, response);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

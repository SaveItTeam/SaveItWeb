package br.com.example.saveit.saveitweb.servlet;
import java.time.LocalDate;

import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebServlet("/funcionarioServlet")
public class FuncionarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");

        if (admin != null) {
            try {

                request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp");

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
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

        if (admin != null){
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                String novoNome = request.getParameter("inputNome2");
                funcionarioDAO.alterarNome(novoNome, id);

                String novoCargo = request.getParameter("inputCargo2");
                String novoEmail = request.getParameter("inputEmail2");
                String novoTelefone = request.getParameter("inputTel2");


            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

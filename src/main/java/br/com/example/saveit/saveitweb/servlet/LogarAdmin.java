package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logarAdmin")
public class LogarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Hash hash = new Hash();

        String emailOUcpf = request.getParameter("email");
        String senha = request.getParameter("senha");

        String senhaHash = hash.hashar(senha);

        java.util.List<String> a = funcionarioDAO.logarAdmin(emailOUcpf, senhaHash);
        int id = Integer.parseInt(a.get(2));

        Funcionario funcionario = funcionarioDAO.buscar("id", id).get(0);
        String nome = funcionario.getNome();

        Object admin = funcionarioDAO.buscar(emailOUcpf, senha);

        if (admin != null) {

            try {
                request.getSession().setAttribute("admin", admin);
                request.setAttribute("nome", nome);
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

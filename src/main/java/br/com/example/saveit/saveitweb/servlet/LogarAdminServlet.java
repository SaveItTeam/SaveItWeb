package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logarAdminServlet")
public class LogarAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Hash hash = new Hash();

        String emailOUcpf = request.getParameter("email");
        String senha = request.getParameter("senha");

        String senhaHash = hash.hashar(senha);

        java.util.List<String> a = funcionarioDAO.logarAdmin(emailOUcpf, senhaHash);
        int id = Integer.parseInt(a.get(0));

        Funcionario funcionario = funcionarioDAO.buscar("id", id).get(0);


        String nome = funcionario.getNome();
        String telefone_trabalho = funcionario.getTelefone_trabalho();
        int id_industria = funcionario.getId_industria();
        String plano = a.get(4);
        String tipo_industria = a.get(5);
        String img = a.get(6);
        char genero = funcionario.getGenero();
        String nome_empresa = a.get(8);
        String cnpj = a.get(9);
        String tipo_servico = a.get(10);
        String endereco = a.get(12);
        String count = a.get(13);
        String atividade_comercial = a.get(14);


        Object admin = funcionarioDAO.buscar(emailOUcpf, senha);

        if (admin != null) {

            try {
                request.getSession().setAttribute("admin", admin);
                request.setAttribute("nome", nome);
                request.setAttribute("telefone_trabalho", telefone_trabalho);
                request.setAttribute("id_industria", id_industria);
                request.setAttribute("plano", plano);
                request.setAttribute("tipo_industria", tipo_industria);
                request.setAttribute("img", img);
                request.setAttribute("genero", genero);
                request.setAttribute("nome_empresa", nome_empresa);
                request.setAttribute("cnpj", cnpj);
                request.setAttribute("tipo_servico", tipo_servico);
                request.setAttribute("endereco", endereco);
                request.setAttribute("count", count);
                request.setAttribute("atividade_comercial", atividade_comercial);

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

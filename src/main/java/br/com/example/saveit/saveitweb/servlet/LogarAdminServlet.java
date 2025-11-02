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
import java.util.List;

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

        int c = senha.length();
        String senhaAnonimizada = "*".repeat(c);

        int id = Integer.parseInt(a.get(0));

        Funcionario funcionario = funcionarioDAO.buscarId(id).get(0);

        String nome = funcionario.getNome();
        String telefone_trabalho = funcionario.getTelefone_trabalho();
        int id_estabelecimento = funcionario.getId_industria();
        String plano = a.get(4);
        String tipo_estabelecimento = a.get(5);
        String img_funcionario = a.get(6);
        String img_empresa = a.get(7);
        char genero = funcionario.getGenero();
        String nome_empresa = a.get(9);
        String cnpj = a.get(10);
        String tipo_servico = a.get(11);
        String endereco = a.get(13);
        String count = a.get(14);
        String atividade_comercial = a.get(15);
        String email = funcionario.getEmail();

        Object admin = funcionarioDAO.logarAdmin(emailOUcpf, senhaHash);
        HttpSession sessao = request.getSession();
        request.getSession().setAttribute("admin", admin);


        if (admin != null) {

            try {
                sessao.setAttribute("id_funcionario", id);
                sessao.setAttribute("nome", nome);
                sessao.setAttribute("telefone_trabalho", telefone_trabalho);
                sessao.setAttribute("id_estabelecimento", id_estabelecimento);
                sessao.setAttribute("plano", plano);
                sessao.setAttribute("tipo_estabelecimento", tipo_estabelecimento);
                sessao.setAttribute("img_funcionario", img_funcionario);
                sessao.setAttribute("img_empresa", img_empresa);
                sessao.setAttribute("genero", genero);
                sessao.setAttribute("nome_empresa", nome_empresa);
                sessao.setAttribute("cnpj", cnpj);
                sessao.setAttribute("tipo_servico", tipo_servico);
                sessao.setAttribute("endereco", endereco);
                sessao.setAttribute("count", count);
                sessao.setAttribute("atividade_comercial", atividade_comercial);
                sessao.setAttribute("senha_anonimzada", senhaAnonimizada);
                sessao.setAttribute("senha", senha);
                sessao.setAttribute("email", email);

                request.getRequestDispatcher("/WEB-INF/view/admin/inicio.jsp").forward(request, response);
            } catch (Exception e) {
                try {
                    request.setAttribute("error", "Credenciais inválidas");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } catch (Exception ed) {
                    ed.printStackTrace();
                }
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

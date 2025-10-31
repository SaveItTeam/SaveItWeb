package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.hash.Hash;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/alterarConfiguracoesServlet")
public class AlterarConfiguracoesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (admin != null) {
            try {
                String nomeAntigo = (String) sessao.getAttribute("nome");
                String emailAntigo = (String) sessao.getAttribute("email");
                String senhaAntiga = (String) sessao.getAttribute("senha");

                String nomeNovo = request.getParameter("inputNome");
                String emailNovo = request.getParameter("inputEmail");
                String senhaNova = request.getParameter("inputSenha");

                int id = (int) sessao.getAttribute("id_funcionario");

                if (nomeNovo != nomeAntigo) {
                    funcionarioDAO.alterarNome(nomeNovo, id);
                    sessao.removeAttribute("nome");
                    sessao.setAttribute("nome", nomeNovo);
                }

                if (emailNovo != emailAntigo) {
                    funcionarioDAO.alterarEmail(emailNovo, id);
                    sessao.removeAttribute("email");
                    sessao.setAttribute("email", emailNovo);

                }

                if (senhaNova != senhaAntiga) {
                    Hash hash = new  Hash();
                    senhaNova = hash.hashar(senhaNova);
                    funcionarioDAO.alterarSenha(senhaNova, id);
                    sessao.removeAttribute("senha");
                    sessao.setAttribute("senha", senhaNova);

                }

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

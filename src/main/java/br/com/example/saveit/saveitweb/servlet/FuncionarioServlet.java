// java
package br.com.example.saveit.saveitweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/funcionarioServlet")
public class FuncionarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = sessao.getAttribute("admin");
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (admin != null) {
            // Buscar e setar atributo antes do forward
            String tipo_estabelecimento = (String) sessao.getAttribute("tipo_estabelecimento");
            List<Funcionario> listaFuncionarios = new ArrayList<>();

            if ("Industria".equals(tipo_estabelecimento)) {
                Integer id_industria = (Integer) sessao.getAttribute("id_estabelecimento");
                if (id_industria != null) {
                    listaFuncionarios = funcionarioDAO.buscarFuncionarioPorAdminINDUSTRIA(id_industria);
                }
            } else if ("Empresa".equals(tipo_estabelecimento)) {
                Integer id_empresa = (Integer) sessao.getAttribute("id_estabelecimento");
                if (id_empresa != null) {
                    listaFuncionarios = funcionarioDAO.buscarFuncionarioPorAdminEMPRESA(id_empresa);
                }
            }

            request.setAttribute("funcionarios", listaFuncionarios);
            request.getRequestDispatcher("/WEB-INF/view/admin/funcionario.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}

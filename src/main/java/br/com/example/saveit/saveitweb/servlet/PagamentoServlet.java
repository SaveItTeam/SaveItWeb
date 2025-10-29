package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.pagamento.Pagamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/pagamentoServlet")
public class PagamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pagamento pagamento = new Pagamento();

        HttpSession sessao = request.getSession();
        Object admin = request.getAttribute("admin");

        if (admin == null) {
            String nome = (String) sessao.getAttribute("nome");
        }


        request.getRequestDispatcher("/WEB-INF/view/admin/pagamentos.jsp").forward(request, response);
    }

}

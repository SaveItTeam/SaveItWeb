package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.industria.IndustriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@WebServlet("/industriaServlet")
public class IndustriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Object admin = request.getSession().getAttribute("admin");
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (admin != null) {
            String  id = (String) sessao.getAttribute("id_estabelecimento");

            List<String> dadosIndustria = industriaDAO.buscarDados(12);
            String nome_industria = dadosIndustria.get(0);
            String estado = dadosIndustria.get(1);
            String cidade = dadosIndustria.get(2);
            String cep = dadosIndustria.get(3);
            String bairro = dadosIndustria.get(4);
            String contato = dadosIndustria.get(5);
            String tipo_venda = dadosIndustria.get(6);
            String rua = dadosIndustria.get(7);
            String complemento = dadosIndustria.get(8);

            try {
                sessao.setAttribute("nome_industria", nome_industria);
                sessao.setAttribute("estado", estado);
                sessao.setAttribute("cidade", cidade);
                sessao.setAttribute("cep", cep);
                sessao.setAttribute("bairro", bairro);
                sessao.setAttribute("contato", contato);
                sessao.setAttribute("tipo_venda", tipo_venda);
                sessao.setAttribute("rua", rua);
                sessao.setAttribute("complemento", complemento);
                request.getRequestDispatcher("/WEB-INF/view/admin/industria.jsp").forward(request, response);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

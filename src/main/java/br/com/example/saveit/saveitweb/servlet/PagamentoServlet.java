package br.com.example.saveit.saveitweb.servlet;

import br.com.example.saveit.saveitweb.model.pagamento.Pagamento;
import br.com.example.saveit.saveitweb.model.pagamento.PagamentoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/pagamentoServlet")
public class PagamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pagamento pagamento = new Pagamento(1, "ativo", "2025-01-10", "2026-01-10");
        PagamentoDAO pagamentoDAO = new PagamentoDAO();//Iniciando o objeto PagamentoDAO
        List<String> dadosPlano;

        HttpSession sessao = request.getSession();//Criando a Sessão
        Object admin = request.getAttribute("admin");

        if (admin == null) {
//            Pegando os atributos e colocando-os em variaveis
            String nome = (String) sessao.getAttribute("nome");
            int id = (int) sessao.getAttribute("id_estabelecimento");
            String url = (String) sessao.getAttribute("img");
            String plano = (String) sessao.getAttribute("plano");
            dadosPlano = pagamentoDAO.buscarDadosPlano(id);
            String descricao = dadosPlano.get(0);
            String preco =  dadosPlano.get(1);
            String status = dadosPlano.get(2);
            String idPlano = dadosPlano.get(3);
            String forma_pagamento = dadosPlano.get(6);

            String dt_criacao = dadosPlano.get(4);

            String anoC = dt_criacao.split("-")[0];
            String mesC = dt_criacao.split("-")[1];
            String diaC = dt_criacao.split("-")[2];
            dt_criacao = diaC + "/" + mesC + "/" + anoC;


            String dt_validade = dadosPlano.get(5);

            String anoV = dt_validade.split("-")[0];
            String mesV = dt_validade.split("-")[1];
            String diaV = dt_validade.split("-")[2];
            dt_validade = diaV + "/" + mesV + "/" + anoV;

            try{
//                Definindo valores que serão mandados para a página JSP
                sessao.setAttribute("descricao", descricao);
                sessao.setAttribute("preco", preco);
                sessao.setAttribute("status", status);
                sessao.setAttribute("idPlano", idPlano);
                sessao.setAttribute("dt_pagamento", dt_criacao);
                sessao.setAttribute("dt_validade", dt_validade);
                sessao.setAttribute("forma_pagamento", forma_pagamento);
                sessao.setAttribute("dadosPlano", dadosPlano);

                request.getRequestDispatcher("/WEB-INF/view/admin/pagamentos.jsp").forward(request, response);//Enviando para o JSP
            }catch(Exception e){
                e.printStackTrace();
            }
        }





    }

}

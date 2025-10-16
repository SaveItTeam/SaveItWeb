package br.com.example.saveit.saveitweb.dao;

import br.com.example.saveit.saveitweb.model.admin.*;
import br.com.example.saveit.saveitweb.model.empresa.*;
import br.com.example.saveit.saveitweb.model.endereco.EnderecoDAO;
import br.com.example.saveit.saveitweb.model.funcionario.*;
import br.com.example.saveit.saveitweb.model.industria.*;
import br.com.example.saveit.saveitweb.model.pagamento.*;
import br.com.example.saveit.saveitweb.model.plano.*;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        if (conexao.conectar() == null) {
            System.out.println("Falha ao conectar ao banco de dados.");
        } else {
            System.out.println("Conexão bem-sucedida ao banco de dados.");

            AdminDAO adminDAO = new AdminDAO();
            EmpresaDAO empresaDAO = new EmpresaDAO();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            IndustriaDAO industriaDAO = new IndustriaDAO();
            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            PlanoDAO planoDAO = new PlanoDAO();
            EnderecoDAO enderecoDAO = new EnderecoDAO();

//            adminDAO.listarAdmin();
//            System.out.println("\n\n");
//
//            empresaDAO.buscar();
//            System.out.println("\n\n");
//
//
//            industriaDAO.buscar();
//            System.out.println("\n\n");
//
//            pagamentoDAO.buscar();
//            System.out.println("\n\n");
//
//            planoDAO.buscar();
//            System.out.println("\n\n");

            System.out.println(funcionarioDAO.buscar());
            System.out.println("\n\n");




            System.out.println();
            System.out.println("----------------------------------------------------------------");
        }
    }
}

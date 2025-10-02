package br.com.example.saveit.saveitweb.dao;

import br.com.example.saveit.saveitweb.model.admin.*;
import br.com.example.saveit.saveitweb.model.empresa.*;
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
            EmpresaDAO daoEmpresa = new EmpresaDAO();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            IndustriaDAO daoIndustria = new IndustriaDAO();
            PagamentoDAO daoPagamento = new PagamentoDAO();
            PlanoDAO daoPlano = new PlanoDAO();

            Admin admin = new Admin(15, "asdas", "aaa", "seara");
            Empresa empresa = new Empresa(10, "seara", 2);
            Funcionario funcionario = new Funcionario("Davi", 1234567, 1234567, 'M', )


            System.out.println();
            System.out.println("----------------------------------------------------------------");
        }
    }
}

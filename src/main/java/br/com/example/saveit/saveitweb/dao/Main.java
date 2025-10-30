package br.com.example.saveit.saveitweb.dao;

import br.com.example.saveit.saveitweb.model.admin.*;
import br.com.example.saveit.saveitweb.model.empresa.*;
import br.com.example.saveit.saveitweb.model.endereco.EnderecoDAO;
import br.com.example.saveit.saveitweb.model.funcionario.*;
import br.com.example.saveit.saveitweb.model.industria.*;
import br.com.example.saveit.saveitweb.model.pagamento.*;
import br.com.example.saveit.saveitweb.model.plano.*;

import java.util.List;

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

//            System.out.println(funcionarioDAO.buscar("email", "mariana@empresa1.com"));
//            java.util.List<String> a = funcionarioDAO.logarAdmin("flavia.ribeiros@gmail.com", "39f3dbe6f821b61f4a2fcdf089c482dcfdb05f0cca82a091d19b4cbe2b2c9369");

//            int c = 0;
//            for (String a1 : a) {
//                System.out.println(c + " " + a1);
//                c++;
//            }
//            System.out.println(a.get(2));
//            int id = Integer.parseInt(a.get(0));
//            System.out.println(funcionarioDAO.logarAdmin("carlos@empresa1.com", "55a5e9e78207b4df8699d60886fa070079463547b095d1a05bc719bb4e6cd251").get(0));

//            Empresa empresa = new Empresa();
//            empresa = empresaDAO.buscar("id", id).get(0);
//            System.out.println(empresa.getCod_empresa());

//            Funcionario funcionario = funcionarioDAO.buscar("id", id).get(0);

            List<String> b = pagamentoDAO.buscarDadosPlano(1);

            int co = 0;
            for (String a1 : b) {
                System.out.println(co + " " + a1);
                co++;
            }

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

//            System.out.println(funcionarioDAO.buscar());ja
//            System.out.println("\n\n");

            System.out.println();
            System.out.println("----------------------------------------------------------------");
        }


//        Api api = new Api();
//        try {
////            System.out.println(api.enviarDados("admin", """
////                    {
////                    "id": 1,
////                    "cargo":"Administrador Geral",
////                    "nome_empresa":"picpay",
////                    "nome_admin":"marii",
////                    "senha":"senha123"
////                    }"""));
////            System.out.println(api.enviarDados("endereco", """
////                    {
////                    "id": 1,
////                    "cep":"01001-000",
////                    "rua":"Av. Paulista",
////                    "bairro":"Bela Vista",
////                    "cidade":"Sao Paulo",
////                    "estado":"SP",
////                    "pais":"Brasil",
////                    "complemento":"Edificio Central"
////                    }"""));
//
//
//
//
////                System.out.println(api.enviarDados("funcionario", """
////                    {
////                    "id": 1,
////                    "nome": "Mari",
////                    "cpf": "123.456.789-00",
////                    "rg": "12.345.678-9",
////                    "genero": "F",
////                    "dt_nascimento": "2009-07-18",
////                    "email": "mariana.boba@example.com",
////                    "senha": "senha456",
////                    "cargo": "Figma girl",
////                    "dt_contratacao": "2025-10-08",
////                    "telefone_pessoal": "(11) 98765-4321",
////                    "telefone_trabalho":"(11) 4002-8922",
////                    "experiencia": "Pagina Essentia da landing page.",
////                    "id_empresa": 2,
////                    "id_industria": 4,
////                    "id_admin": 1
////                    }"""));
//
//
//
//
////            System.out.println(api.enviarDados("cliente", """
////                    {
////                    "id": 1,
////                    "cnpj": "12.345.678/0001-99",
////                    "nome": "marii SA",
////                    "email": "mariisa@empresa.com",
////                    "senha": "senha789",
////                    "telefone": "(11) 99977-5544",
////                    "tipo": 1,
////                    "tipo_venda": "varejo",
////                    "id_empresa": 2,
////                    "id_endereco": 1,
////                    "id_industria": null
////                    }"""));
////            System.out.println(api.enviarDados("industria", """
////                    {
////                    "id": 1,
////                    "vende": "grãos",
////                    "id_plano": 2,
////                    "id_pagamento": 3
////                    }"""));
////            System.out.println(api.enviarDados("pagamento", """
////                    {
////                    "id": 1,
////                    "status": "atrasado",
////                    "dt_criacao": "2025-09-27",
////                    "dt_validade": "2025-10-14"
////                    }"""));
////            System.out.println(api.enviarDados("plano", """
////                    {
////                    "id": 2,
////                    "preco": 1000.00,
////                    "descricao": "acesso a vitrine virtual, gerenciador de estoque e relatórios semanais",
////                    "id_pagamento": 1
////                    }"""));
//            } catch (InterruptedException | IOException e) {
//                throw new RuntimeException(e);
    }
//
}
//}

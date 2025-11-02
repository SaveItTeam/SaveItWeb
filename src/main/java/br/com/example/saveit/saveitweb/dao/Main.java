package br.com.example.saveit.saveitweb.dao;

import br.com.example.saveit.saveitweb.model.admin.*;
import br.com.example.saveit.saveitweb.model.cliente.Cliente;
import br.com.example.saveit.saveitweb.model.empresa.*;
import br.com.example.saveit.saveitweb.model.endereco.Endereco;
import br.com.example.saveit.saveitweb.model.endereco.EnderecoDAO;
import br.com.example.saveit.saveitweb.model.funcionario.*;
import br.com.example.saveit.saveitweb.model.industria.*;
import br.com.example.saveit.saveitweb.model.pagamento.*;
import br.com.example.saveit.saveitweb.model.plano.*;
import br.com.example.saveit.saveitweb.model.telefone.Telefone;

import java.io.IOException;
import java.sql.Date;
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
            java.util.List<String> a = funcionarioDAO.logarAdmin("flavia.ribeiros@gmail.com", "39f3dbe6f821b61f4a2fcdf089c482dcfdb05f0cca82a091d19b4cbe2b2c9369");
            int c = 0;
            for (String a1 : a) {
                System.out.println(c + " " + a1);
                c++;
            }

            List<Funcionario> da = funcionarioDAO.buscarFuncionarioPorAdminINDUSTRIA(Integer.parseInt(a.get(3)));
            int d = 0;
            for (Funcionario da1 : da) {
                System.out.println(da1.getNome());
                d++;
            }

//            System.out.println(a.get(2));
            int id = Integer.parseInt(a.get(0));
//            System.out.println(funcionarioDAO.logarAdmin("carlos@empresa1.com", "55a5e9e78207b4df8699d60886fa070079463547b095d1a05bc719bb4e6cd251").get(0));

//            Empresa empresa = new Empresa();
//            empresa = empresaDAO.buscar("id", id).get(0);
//            System.out.println(empresa.getCod_empresa());

            Funcionario funcionario = funcionarioDAO.buscar("id", id).get(0);

            System.out.println("\n");

            int co = 0;
           java.util.List<String> b = pagamentoDAO.buscarDadosPlano(Integer.parseInt(a.get(3)));

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
//
//        // Admin
//        Admin admin1 = new Admin(1, "Lucas Andrade", "lucas.andrade@saveit.com", "admin123");
//        Admin admin2 = new Admin(2, "Mariana Costa", "mariana.costa@saveit.com", "adm456");
//
//// Endereco
//        Endereco endereco1 = new Endereco(1, "01001-000", "Rua das Flores", "Centro", "São Paulo", "SP", "Brasil", "Apto 12", 100);
//        Endereco endereco2 = new Endereco(2, "20040-010", "Avenida Atlântica", "Copacabana", "Rio de Janeiro", "RJ", "Brasil", "Cobertura", 1500);
//
//// Cliente
//        Cliente cliente1 = new Cliente(1, "Empresa Verde Ltda", "contato@empresaverde.com", "verde123", 1, "B2B", 1, "12.345.678/0001-90", null);
//        Cliente cliente2 = new Cliente(2, "Indústria Solar S.A.", "vendas@solar.com", "solar456", 2, "B2C", 2, "98.765.432/0001-12", null);
//
//// Empresa
//        Empresa empresa1 = new Empresa(1, "Fornecedores de materiais recicláveis", "EMP001", 1);
//
//// Plano
//        Plano plano1 = new Plano(1, 99.90, "SaveIt Basico");
//        Plano plano2 = new Plano(2, 249.90, "SaveIt Pro");
//
//// Pagamento
//        Pagamento pagamento1 = new Pagamento(1, "ativo", "2025-01-10", "2026-01-10", "cartão de crédito");
//        Pagamento pagamento2 = new Pagamento(2, "pendente", "2025-03-22", "2026-03-22", "cartão de crédito");
//
//// Indústria
//        Industria industria1 = new Industria(1, "Componentes eletrônicos e sobras de produção", 2, "IND001", 1, 2);
//
//// Funcionário
//        Funcionario funcionario1 = new Funcionario(
//                1, "Carlos Oliveira", "123.456.789-00", "45.678.123-4", 'M',
//                Date.valueOf("1990-05-20"), "carlos@empresaverde.com", "func123", "Analista de Logística",
//                Date.valueOf("2023-07-15"), "(11) 91234-5678", "(11) 4002-8922",
//                "5 anos em controle de estoque", 1, null, false
//        );
//
//        Funcionario funcionario2 = new Funcionario(
//                2, "Fernanda Lima", "987.654.321-00", "12.345.678-9", 'F',
//                Date.valueOf("1988-09-14"), "fernanda@solar.com", "func456", "Gerente de Produção",
//                Date.valueOf("2022-02-01"), "(21) 99876-5432", "(21) 3030-4040",
//                "10 anos em gestão industrial", null, 1, true
//        );
//
//// Telefone
//        Telefone telefone1 = new Telefone(1, "(11) 4002-8922", 1);
//        Telefone telefone2 = new Telefone(2, "(21) 3030-4040", 2);
//
//        try {
//            System.out.println(api.enviarDados("admin", admin1.toString()));
//            System.out.println(api.enviarDados("admin", admin2.toString()));
//            System.out.println(api.enviarDados("endereco", endereco1.toString()));
//            System.out.println(api.enviarDados("endereco", endereco2.toString()));
//            System.out.println(api.enviarDados("pagamento", pagamento1.toString()));
//            System.out.println(api.enviarDados("pagamento", pagamento2.toString()));
//            System.out.println(api.enviarDados("plano", plano1.toString()));
//            System.out.println(api.enviarDados("plano", plano2.toString()));
//            System.out.println(api.enviarDados("cliente", cliente1.toString()));
//            System.out.println(api.enviarDados("cliente", cliente2.toString()));
//            System.out.println(api.enviarDados("industria", industria1.toString()));
//            System.out.println(api.enviarDados("empresa", empresa1.toString()));
//            System.out.println(api.enviarDados("funcionario", funcionario1.toString()));
//            System.out.println(api.enviarDados("funcionario", funcionario2.toString()));
//            System.out.println(api.enviarDados("telefone", telefone1.toString()));
//            System.out.println(api.enviarDados("telefone", telefone2.toString()));
//
//            } catch (InterruptedException | IOException e) {
//                throw new RuntimeException(e);
    }
//
}
//}

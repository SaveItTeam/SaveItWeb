package br.com.example.saveit.saveitweb.servlet;
import java.time.LocalDate;
import java.util.Random;

import br.com.example.saveit.saveitweb.model.Funcionario;
import br.com.example.saveit.saveitweb.model.FuncionarioDAO;
import jakarta.servlet.http.HttpServlet;

public class RegistrarFuncionario extends HttpServlet {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        Random rd = new Random();
        funcionario.nome = "Davi";
        funcionario.cpf = "12345678910";
        funcionario.rg = "12345678-9";
        funcionario.sexo = 'M';
        funcionario.dt_nascimento = java.sql.Date.valueOf(LocalDate.of(1990, 1, 1));
        funcionario.email = "davi" + rd.nextInt(1000) + "@example.com";
        funcionario.senha = "password123";
        funcionario.cargo = "Desenvolvedor";
        funcionario.dt_contratacao = java.sql.Date.valueOf(LocalDate.now());
        funcionario.telefone = "(11) 91234-5678";
        funcionario.experiencia = rd.nextInt(1,99) + " anos";
        funcionario.id_empresa = rd.nextInt(1,2);
        funcionario.id_industria = rd.nextInt(1,2);
        funcionario.id_admin = rd.nextInt(1,2);

        if (funcionarioDAO.inserirFuncionario(funcionario)){
            System.out.println("Funcionário registrado com sucesso!");
        } else {
            System.out.println("Falha ao registrar funcionário.");
        }
    }
}

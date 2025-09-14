package br.com.example.saveit.saveitweb.servlet;
import java.time.LocalDate;

import br.com.example.saveit.saveitweb.model.Funcionario;
import br.com.example.saveit.saveitweb.model.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RegistrarFuncionario")
public class RegistrarFuncionario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        funcionario.nome = request.getParameter("nome");
        funcionario.cpf = request.getParameter("cpf");
        funcionario.rg = request.getParameter("rg");
        funcionario.sexo = request.getParameter("sexo").charAt(0);
        funcionario.dt_nascimento = java.sql.Date.valueOf(request.getParameter("dt_nascimento"));
        funcionario.email = request.getParameter("email");
        funcionario.senha = request.getParameter("senha");
        funcionario.cargo = request.getParameter("cargo");
        funcionario.dt_contratacao = java.sql.Date.valueOf(LocalDate.now());
        funcionario.telefone = request.getParameter("telefone");
        funcionario.experiencia = request.getParameter("experiencia");
        funcionario.id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        funcionario.id_industria = Integer.parseInt(request.getParameter("id_industria"));
        funcionario.id_admin = Integer.parseInt(request.getParameter("id_admin"));

        if (funcionarioDAO.inserirFuncionario(funcionario)){
            System.out.println("Funcionário registrado com sucesso!");
        } else {
            System.out.println("Falha ao registrar funcionário.");
        }
    }
}
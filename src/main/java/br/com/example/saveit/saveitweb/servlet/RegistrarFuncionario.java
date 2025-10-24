package br.com.example.saveit.saveitweb.servlet;
import java.time.LocalDate;

import br.com.example.saveit.saveitweb.model.funcionario.Funcionario;
import br.com.example.saveit.saveitweb.model.funcionario.FuncionarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RegistrarFuncionario")
public class RegistrarFuncionario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(request.getParameter("nome"));
        funcionario.setCpf(request.getParameter("cpf"));
        funcionario.setRg(request.getParameter("rg"));
        funcionario.setGenero(request.getParameter("genero").charAt(0));
        funcionario.setDt_nascimento(java.sql.Date.valueOf(request.getParameter("dt_nascimento")));
        funcionario.setEmail(request.getParameter("email"));
        funcionario.setSenha(request.getParameter("senha"));
        funcionario.setCargo(request.getParameter("cargo"));
        funcionario.setDt_contratacao(java.sql.Date.valueOf(LocalDate.now()));
        funcionario.setTelefone_pessoal(request.getParameter("telefone_pessoal"));
        funcionario.setExperiencia(request.getParameter("experiencia"));
        funcionario.setId_empresa(Integer.parseInt(request.getParameter("id_empresa")));
        funcionario.setId_industria(Integer.parseInt(request.getParameter("id_industria")));
        funcionario.setIs_admin(Boolean.parseBoolean(request.getParameter("is_admin")));

        if (funcionarioDAO.inserirFuncionario(funcionario)){
            System.out.println("Funcionário registrado com sucesso!");
        } else {
            System.out.println("Falha ao registrar funcionário.");
        }
    }
}
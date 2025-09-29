package br.com.example.saveit.saveitweb.dao;

import br.com.example.saveit.saveitweb.model.admin.Admin;
import br.com.example.saveit.saveitweb.model.admin.AdminDAO;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        if (conexao.conectar() == null) {
            System.out.println("Falha ao conectar ao banco de dados.");
        } else {
            System.out.println("Conexão bem-sucedida ao banco de dados.");
            AdminDAO adminDAO = new AdminDAO();
            Admin admin = new Admin(15, "asdas", "aaa", "seara");
            System.out.println(adminDAO.inserirAdmin(admin));
            System.out.println(adminDAO.alterarAdminPorId(admin));
            System.out.println(adminDAO.listarAdmin());
            System.out.println(adminDAO.excluirAdminPorId(admin));
        }
    }
}

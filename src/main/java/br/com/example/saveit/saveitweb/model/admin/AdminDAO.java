package br.com.example.saveit.saveitweb.model.admin;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDAO {
//    Inseir
    public boolean inserirAdmin(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();//Abrindo conexão com o banco de dados

        String sql = "insert into Admin(nome_admin, email, senha) values(?, ?, ?)";//Comando SQL

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
//            Inserção de dados
            stmt.setString(1, admin.getNome_admin());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getSenha());

            boolean validar = stmt.executeUpdate() > 0;//Executando comando SQL

            stmt.close();

            return validar;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
    }

//    Alterar
    public boolean alterarAdminPorId(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();//Abrindo conexão com o banco

        String sql = "update Admin set nome_cliente = ? where id = ?";//Comando SQL

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
//            Inserção de dados
            stmt.setString(1, admin.getNome_admin());
            stmt.setInt(2, admin.getId());

            boolean validar = stmt.executeUpdate() > 0;//Excutando comando SQL
            stmt.close();

            return validar;

        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);//Desconectndo do banco de dados
        }
    }

//    Excluir
    public boolean excluirAdminPorId(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();//Abrindo conexão com o banco de dados

        String sql = "delete from Admin where id=?";//Comando SQL

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
//            Inserção de dados
            stmt.setInt(1, admin.getId());

            boolean validar = stmt.executeUpdate() > 0;//Executando comando SQL
            stmt.close();

            return validar;

        } catch (SQLException e){
            e.printStackTrace();
            return false;

        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
    }

//    Listar
    public List<Admin> listarAdmin() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados

        String sql = "select * from Admin";//Comando SQL

        List<Admin> admins = new ArrayList<>();

        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            ResultSet rset = pmst.executeQuery();//Executando comando SQL
            while (rset.next()) {
                Admin admin = new Admin(rset.getInt("id"), rset.getString("nome_admin"), rset.getString("email"),  rset.getString("senha"));
                admins.add(admin);
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return admins;//Retornando a lista de Admins
        }
    }

    public List<Admin> listarAdminA() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "select * from Admin";

        List<Admin> admins = new ArrayList<>();
        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            ResultSet rset = pmst.executeQuery();//Executando comando SQL

            while (rset.next()) {
                Admin admin = new Admin(rset.getInt("id"), rset.getString("nome_admin"), rset.getString("email"),  rset.getString("senha"));
                admins.add(admin);
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return admins;//Retornando a lista de Admins
        }
    }

}

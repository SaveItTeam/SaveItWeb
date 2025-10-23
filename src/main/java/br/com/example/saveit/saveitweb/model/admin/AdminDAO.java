package br.com.example.saveit.saveitweb.model.admin;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDAO {

    public boolean inserirAdmin(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();

        String sql = "insert into Admin(nome_admin, email, senha) values(?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, admin.getNome_admin());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getSenha());

            int validar = stmt.executeUpdate();

            stmt.close();

            return validar > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            conexao.desconectar(conn);
        }
    }

    public boolean alterarAdminPorId(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();

        String sql = "update Admin set nome_cliente = ? where id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, admin.getNome_admin());
            stmt.setInt(2, admin.getId());

            int validar = stmt.executeUpdate();
            stmt.close();

            return validar > 0;

        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);
        }
    }

    public boolean excluirAdminPorId(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();

        String sql = "delete from Admin where id=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, admin.getId());

            int validar = stmt.executeUpdate();
            stmt.close();

            return validar > 0;

        } catch (SQLException e){
            e.printStackTrace();
            return false;

        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<Admin> listarAdmin() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        ResultSet rset;

        String sql = "select * from Admin";

        List<Admin> admins = new ArrayList<>();

        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            rset = pmst.executeQuery();
            while (rset.next()) {
                Admin admin = new Admin(rset.getInt("id"), rset.getString("nome_admin"), rset.getString("email"),  rset.getString("senha"));
                admins.add(admin);
            }

            return admins;

        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(conn);
            return admins;
        }
    }

    public List<Admin> listarAdminA() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        ResultSet rset;

        String sql = "select * from Admin";

        List<Admin> admins = new ArrayList<>();
        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            rset = pmst.executeQuery();

            while (rset.next()) {
                Admin admin = new Admin(rset.getInt("id"), rset.getString("nome_admin"), rset.getString("email"),  rset.getString("senha"));
                admins.add(admin);
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return admins;
        }
    }

}

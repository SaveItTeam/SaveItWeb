package br.com.example.saveit.saveitweb.model.admin;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public boolean inserirAdmin(Admin admin) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();

        String sql = "insert into Admin(senha, nome_cliente, qual_empresa) values(?, ?, ? )";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, admin.getSenha());
            stmt.setString(2, admin.getNome_cliente());
            stmt.setString(3, admin.getQual_empresa());

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

            stmt.setString(1, admin.getNome_cliente());
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
        Connection conn = conexao.conectar();

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
        List<Admin> listaAdmins = new ArrayList<>();

        ResultSet rset = null;

        String sql = "select * from Admin";

        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            rset = pmst.executeQuery();
            while (rset.next()) {
                Admin admin = new Admin(rset.getInt("id"), rset.getString("senha"), rset.getString("nome_cliente"), rset.getString("qual_empresa"));
                listaAdmins.add(admin);
            }
            for (int c = 0; listaAdmins.size() > c; c++) {
                System.out.println(listaAdmins.get(c));
            }
            return listaAdmins;

        } catch (SQLException e){
            e.printStackTrace();
            return null;

        } finally {
            conexao.desconectar(conn);
        }
    }

}

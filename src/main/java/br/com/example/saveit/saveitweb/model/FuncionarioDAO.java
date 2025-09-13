package br.com.example.saveit.saveitweb.model;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    public boolean inserirFuncionario(Funcionario funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "Insert into funcionario (nome, cpf, rg, sexo, dt_nascimento, email, senha, cargo, dt_contratacao, telefone, experiencia, id_empresa, id_industria, id_admin) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, String.valueOf(funcionario.getSexo()));
            stmt.setObject(5, funcionario.getDt_nascimento());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getSenha());
            stmt.setString(8, funcionario.getCargo());
            stmt.setObject(9, funcionario.getDt_contratacao());
            stmt.setString(10, funcionario.getTelefone());
            stmt.setString(11, funcionario.getExperiencia());
            stmt.setString(12, funcionario.getId_empresa());
            stmt.setString(13, funcionario.getId_industria());
            stmt.setString(14, funcionario.getId_admin());

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
}

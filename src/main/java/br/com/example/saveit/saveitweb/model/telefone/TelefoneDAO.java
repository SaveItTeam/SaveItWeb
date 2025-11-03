package br.com.example.saveit.saveitweb.model.telefone;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {
    //    Insert
    public boolean inserir(Telefone telefone) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente(num_telefone, id_cliente) Values(?,?)");//Comando SQL
//        Setando o valor dos parâmetros
            pstmt.setString(1, telefone.getNum_telefone());
            pstmt.setInt(2, telefone.getId_cliente());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Fechando a conexão com o banco de dados
        }
        return false;
    }


//    Update
    public boolean alterarTelefone(String valorAlterar, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Telefone set num_telefone = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorAlterar);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


//    Delete

    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Telefone where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Telefone where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    //    Select
    public List<Telefone> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
//        Iniciando a lista de objetos Telefone
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Telefone telefone = new Telefone(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    telefones.add(telefone);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return telefones;//Retornando a lista de telefones
        }
    }


    public List<Telefone> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
//        Iniciando a lista de objetos Telefone
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Telefone telefone = new Telefone(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    telefones.add(telefone);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return telefones;//Retornando a lista de telefones
        }
    }


    public List<Telefone> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
//        Iniciando a lista de objetos Telefone
        List<Telefone> telefones = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Endereco WHERE %s = '%s'", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);//Setando valor
            ResultSet rset = pstmt.executeQuery();
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Telefone telefone = new Telefone(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    telefones.add(telefone);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return telefones;//Retornando a lista de telefones
        }
    }


    public List<Telefone> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
//        Iniciando a lista de objetos Telefone
        List<Telefone> telefones = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM telefone WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);//Setando valor
            ResultSet rset = pstmt.executeQuery();
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Telefone telefone = new Telefone(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    telefones.add(telefone);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return telefones;//Retornando a lista de telefones
        }
    }
}

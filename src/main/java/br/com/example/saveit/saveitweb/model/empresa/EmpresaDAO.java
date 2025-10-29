package br.com.example.saveit.saveitweb.model.empresa;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.getInt;

public class EmpresaDAO {
    //    Insert
    public boolean inserir(Empresa empresa) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Insert into Empresa (procura, cod_empresa, id_cliente) Values(?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
//          Setando o valor dos parâmetros
            pstmt.setString(1, empresa.getProcura());
            pstmt.setString(2, empresa.getCod_empresa());
            pstmt.setInt(3, empresa.getId_cliente());
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
    public boolean alterar(String valorAlterar, String campoAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
//            Setando valores
            pstmt.setString(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
//            Setando valores
            pstmt.setInt(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
//            Setando valores
            pstmt.setString(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
//            Setando valores
            pstmt.setInt(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
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
            String query = String.format("delete from Empresa where %s = ?", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setString(1, campoOndeExcluir);//Setando valor
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando
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
            String query = String.format("delete from Empresa where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);//Setando valor
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
                pstmt.close();
                return validar;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }



    //    Select
    public List<Empresa> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Empresa";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Eecutando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Empresa empresa = new Empresa(rset.getInt("id"), rset.getString("procura"), rset.getString("cod_empresa"), rset.getInt("id_cliente"));
                    empresas.add(empresa);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return empresas;//Retornando a lista de empresas
        }
    }


    public List<Empresa> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from plano order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    Empresa empresa = new Empresa(
                            rset.getInt("id"),
                            rset.getString("procura"),
                            rset.getString("cod_empresa"),
                            rset.getInt("id_cliente")
                    );
                    empresas.add(empresa);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return empresas;//Retornando a lista de empresas
        }
    }

    public List<Empresa> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Empresa WHERE " + campoOndePesquisar + " = ?";//Comando SQL
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);//Iniciando PreparedStatement
                pstmt.setInt(1, valorPesquisar);//Setando valor
                ResultSet rset = pstmt.executeQuery();//Executando comando SQL

                if (rset != null) {
//                    Inserção de dados
                    while (rset.next()) {
                        Empresa empresa = new Empresa(
                                rset.getInt("id"),
                                rset.getString("procura"),
                                rset.getString("cod_empresa"),
                                rset.getInt("id_cliente")
                        );
                        empresas.add(empresa);
                    }
                }
                pstmt.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                return null;
            }

        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return empresas;
        }
    }


    public List<Empresa> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        String query = "SELECT * FROM empresa WHERE " + campoOndePesquisar + " = ?";//Comando SQL

        try {
//            Iniciando objeto Statment
            PreparedStatement stmt = conn.prepareStatement(query);
            try {
                int intVal = Integer.parseInt(valorPesquisar);
                stmt.setInt(1, intVal);
            } catch (NumberFormatException e) {
                stmt.setString(1, valorPesquisar);
            }

            ResultSet rset = stmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Empresa empresa = new Empresa(
                            rset.getInt("id"),
                            rset.getString("procura"),
                            rset.getString("cod_empresa"),
                            rset.getInt("id_cliente")
                    );
                    empresas.add(empresa);
                }
            }
            stmt.close();

        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return empresas;//Retornando a lista de empresas
        }
    }
}

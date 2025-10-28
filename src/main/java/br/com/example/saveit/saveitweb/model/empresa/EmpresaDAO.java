package br.com.example.saveit.saveitweb.model.empresa;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    //    Insert
    public boolean inserir(Empresa empresa) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = "Insert into Empresa (procura, cod_empresa, id_cliente) Values(?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//          Setando o valor dos parâmetros
            pstmt.setString(1, empresa.getProcura());
            pstmt.setString(2, empresa.getCod_empresa());
            pstmt.setInt(3, empresa.getId_cliente());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql do preparedStament
//              Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Fechando a conexão com o banco
        }
        return false;
    }


    //    Update
    public boolean alterar(String valorAlterar, String campoAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setInt(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Empresa set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setInt(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }




    //    Delete
    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Empresa where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco
        }
        return false;
    }


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
        try {
            String query = String.format("delete from Empresa where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco
        }
        return false;
    }



    //    Select
    public List<Empresa> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando a ista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Empresa";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Empresa empresa = new Empresa(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
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
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from plano order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Empresa empresa = new Empresa(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
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
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Empresa WHERE " + campoOndePesquisar + " = ?";//Comando SQL
            PreparedStatement stmt = conn.prepareStatement(sql);//Criando Statement
            stmt.setInt(1, valorPesquisar);
            ResultSet rset = stmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Empresa empresa = new Empresa(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
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


    public List<Empresa> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Industrias
        List<Empresa> empresas = new ArrayList<>();
        String query = "SELECT * FROM empresa WHERE " + campoOndePesquisar + " = ?";//Comando SQL

        try {
//                Iniciando PreparedStatment
            PreparedStatement stmt = conn.prepareStatement(query);
//            Setando valores
            stmt.setString(1, String.valueOf(valorPesquisar));
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
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return empresas;//Retornando a lista de empresas
        }
    }
}

package br.com.example.saveit.saveitweb.model.endereco;


import br.com.example.saveit.saveitweb.dao.Conexao;

import javax.xml.validation.Validator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
//    Insert
    public boolean inserir(Endereco endereco) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Endereco (cep, rua, bairro, cidade, estado, pais, complemento) Values(?,?,?,?,?,?,?)");//Comando SQL
//        Setando valores
            pstmt.setString(1, endereco.getCep());
            pstmt.setString(2, endereco.getCep_rua());
            pstmt.setString(3, endereco.getCep_bairro());
            pstmt.setString(4, endereco.getCep_cidade());
            pstmt.setString(5, endereco.getCep_estado());
            pstmt.setString(6, endereco.getCep_pais());
            pstmt.setString(7, endereco.getCep_complemento());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando SQL
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


//    Update

    public boolean alterar(String valorAlterar, String campoAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//true
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
            String query = String.format("Update Endereco set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//true
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
            String query = String.format("Update Endereco set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//true
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
            String query = String.format("Update Endereco set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//true
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Endereco where %s = ?", campoOndeExcluir);
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando
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


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Endereco where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando
//            Validação
            if (validar) {
                pstmt.close();
                return validar;//True
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


//    Select
    public List<Endereco> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Endereco> enderecos = new ArrayList<>();
        try {
            String query = "select * from Endereco";//Comando SQL
            Statement stmt = conn.createStatement();//Criando statement
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Endereco endereco = new Endereco(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                    enderecos.add(endereco);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return enderecos;//Retornando a lista de Endereços
        }
    }


    public List<Endereco> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();//Criando statement
            String query = "select * from Endereco order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
                while (rset.next()) {
                    Endereco endereco = new Endereco(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                    enderecos.add(endereco);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco de dados
            return enderecos;//Retornando a lista de Endereços
        }
    }


    public List<Endereco> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Endereco> enderecos = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Endereco WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PrepareStatement
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
                    Endereco endereco = new Endereco(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                    enderecos.add(endereco);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco de dados
            return enderecos;//Retornando a lista de Endereços
        }
    }


    public List<Endereco> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Endereco> enderecos = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Endereco WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PrepareStatement
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
                    Endereco endereco = new Endereco(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                    enderecos.add(endereco);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco de dados
            return enderecos;//Retornando a lista de Endereços
        }
    }
}
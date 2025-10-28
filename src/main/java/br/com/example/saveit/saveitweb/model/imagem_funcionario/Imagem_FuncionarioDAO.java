package br.com.example.saveit.saveitweb.model.imagem_funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Imagem_FuncionarioDAO {
    //    Insert
    public boolean inserir(Imagem_Funcionario imagem_Funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente(url, id_funcionario) Values(?,?)");//Comando SQL
//        Setando o valor dos parâmetros
            pstmt.setString(1, imagem_Funcionario.getUrl());
            pstmt.setInt(2, imagem_Funcionario.getId_funcionario());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql
//            Validação
            if (validar) {
                return validar;//True
            }
            pstmt.close();
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
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
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
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
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    //    Select
    public List<Imagem_Funcionario> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Imagem_Funcionario";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem_Funcionario imagem_funcionario = new Imagem_Funcionario(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_funcionario);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem_Funcionario> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Imagem_Funcionario order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem_Funcionario imagem_funcionario = new Imagem_Funcionario(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_funcionario);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem_Funcionario> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem_Funcionario imagem_funcionario = new Imagem_Funcionario(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_funcionario);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem_Funcionario> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem_Funcionario imagem_funcionario = new Imagem_Funcionario(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_funcionario);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }
}

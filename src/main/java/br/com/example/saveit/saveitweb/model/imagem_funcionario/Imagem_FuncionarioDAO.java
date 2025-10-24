package br.com.example.saveit.saveitweb.model.imagem_funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Imagem_FuncionarioDAO {
    //    Insert
    public boolean inserir(Imagem_Funcionario imagem_Funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente(url, id_funcionario) Values(?,?)");//Comando SQL
//        Setando o valor dos parâmetros
            pstmt.setString(1, imagem_Funcionario.getUrl());
            pstmt.setInt(2, imagem_Funcionario.getId_funcionario());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql
//            Validação
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Imagem_Funcionario set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Imagem_Funcionario set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Imagem_Funcionario set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Imagem_Funcionario set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = '%s'", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = %d", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                statement.close();
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
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
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
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
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
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = '%s'", campoOndePesquisar, valorPesquisar);//Comando SQL
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


    public List<Imagem_Funcionario> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem_Funcionario> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = %d", campoOndePesquisar, valorPesquisar);//Comando SQL
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
}

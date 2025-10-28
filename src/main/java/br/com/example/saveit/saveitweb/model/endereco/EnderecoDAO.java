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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Endereco (cep, rua, bairro, cidade, estado, pais, complemento) Values(?,?,?,?,?,?,?)");
//        Setando o valor dos parâmetros
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
            String query = String.format("Update Endereco set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
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
            String query = String.format("Update Endereco set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Endereco where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
//            Validação
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Endereco where %s = %d", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
//            Validação
            if (validar) {
                statement.close();
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
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();//Criando statement
            String query = "select * from Endereco";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setCep_rua(rset.getString(3));
                    endereco.setCep_bairro(rset.getString(4));
                    endereco.setCep_cidade(rset.getString(5));
                    endereco.setCep_estado(rset.getString(6));
                    endereco.setCep_pais(rset.getString(7));
                    endereco.setCep_complemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
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
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();//Criando statement
            String query = "select * from Endereco order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
                while (rset.next()) {
//                    Inserção de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setCep_rua(rset.getString(3));
                    endereco.setCep_bairro(rset.getString(4));
                    endereco.setCep_cidade(rset.getString(5));
                    endereco.setCep_estado(rset.getString(6));
                    endereco.setCep_pais(rset.getString(7));
                    endereco.setCep_complemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
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
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();//Criando statement
            String query = String.format("SELECT * FROM Endereco WHERE %s = '%s'", campoOndePesquisar, valorPesquisar);//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
//                    Inserção de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setCep_rua(rset.getString(3));
                    endereco.setCep_bairro(rset.getString(4));
                    endereco.setCep_cidade(rset.getString(5));
                    endereco.setCep_estado(rset.getString(6));
                    endereco.setCep_pais(rset.getString(7));
                    endereco.setCep_complemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
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


    public List<Endereco> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();//Criando statement
            String query = String.format("SELECT * FROM Endereco WHERE %s = %d", campoOndePesquisar, valorPesquisar);//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
//                    Inserção de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setCep_rua(rset.getString(3));
                    endereco.setCep_bairro(rset.getString(4));
                    endereco.setCep_cidade(rset.getString(5));
                    endereco.setCep_estado(rset.getString(6));
                    endereco.setCep_pais(rset.getString(7));
                    endereco.setCep_complemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
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
}
package br.com.example.saveit.saveitweb.model.endereco;


import br.com.example.saveit.saveitweb.dao.Conexao;

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
            pstmt.setString(2, endereco.getRua());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getCidade());
            pstmt.setString(5, endereco.getEstado());
            pstmt.setString(6, endereco.getPais());
            pstmt.setString(7, endereco.getComplemento());
            int validar = pstmt.executeUpdate();//Executando o comando sql do preparedStament
//            Validação
            if (validar > 0) {
                System.out.println("Inserido com sucesso!");
                return true;
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
            String query = String.format("Update Endereco set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Endereco set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


//    Delete

    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Endereco where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco
        }
        return false;
    }


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Statement statement;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Endereco where %s = %d", campoOndeExcluir, valorOndeExcluir);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return false;
    }


//    Select
    public List<Endereco> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco";
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setRua(rset.getString(3));
                    endereco.setBairro(rset.getString(4));
                    endereco.setCidade(rset.getString(5));
                    endereco.setEstado(rset.getString(6));
                    endereco.setPais(rset.getString(7));
                    endereco.setComplemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return enderecos;
        }
    }


    public List<Endereco> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setRua(rset.getString(3));
                    endereco.setBairro(rset.getString(4));
                    endereco.setCidade(rset.getString(5));
                    endereco.setEstado(rset.getString(6));
                    endereco.setPais(rset.getString(7));
                    endereco.setComplemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return enderecos;
        }
    }


    public List<Endereco> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Endereco WHERE %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setRua(rset.getString(3));
                    endereco.setBairro(rset.getString(4));
                    endereco.setCidade(rset.getString(5));
                    endereco.setEstado(rset.getString(6));
                    endereco.setPais(rset.getString(7));
                    endereco.setComplemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return enderecos;
        }
    }


    public List<Endereco> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Endereco WHERE %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    endereco.setId(rset.getInt(1));
                    endereco.setCep(rset.getString(2));
                    endereco.setRua(rset.getString(3));
                    endereco.setBairro(rset.getString(4));
                    endereco.setCidade(rset.getString(5));
                    endereco.setEstado(rset.getString(6));
                    endereco.setPais(rset.getString(7));
                    endereco.setComplemento(rset.getString(8));
                    enderecos.add(endereco);
                    endereco = new Endereco();
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return enderecos;
        }
    }
}
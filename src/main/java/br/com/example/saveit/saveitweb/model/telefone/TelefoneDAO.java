package br.com.example.saveit.saveitweb.model.telefone;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {
    //    Insert
    public boolean inserir(Telefone telefone) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente(num_telefone, id_cliente) Values(?,?)");
//        Setando o valor dos parâmetros
            pstmt.setString(1, telefone.getNum_telefone());
            pstmt.setInt(2, telefone.getId_cliente());
            int validar = pstmt.executeUpdate();//Executando o comando sql do preparedStament
//            Validação
            if (validar > 0) {
                System.out.println("Inserido com sucesso!");
                pstmt.close();
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
            String query = String.format("Update Telefone set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
            String query = String.format("Update Telefone set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
            String query = String.format("Update Telefone set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
            String query = String.format("Update Telefone set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
            String excluir = String.format("delete from Telefone where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
            String excluir = String.format("delete from Telefone where %s = %d", campoOndeExcluir, valorOndeExcluir);
            statement = conn.createStatement();
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
    public List<Telefone> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Telefone telefone = new Telefone();
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco";
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    telefone.setId(rset.getInt(1));
                    telefone.setNum_telefone(rset.getString(2));
                    telefone.setId_cliente(rset.getInt(3));
                    telefones.add(telefone);
                    telefone = new Telefone();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return telefones;
        }
    }


    public List<Telefone> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Telefone telefone = new Telefone();
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Endereco order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    telefone.setId(rset.getInt(1));
                    telefone.setNum_telefone(rset.getString(2));
                    telefone.setId_cliente(rset.getInt(3));
                    telefones.add(telefone);
                    telefone = new Telefone();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return telefones;
        }
    }


    public List<Telefone> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Telefone telefone = new Telefone();
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Endereco WHERE %s = '%s'", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
                    telefone.setId(rset.getInt(1));
                    telefone.setNum_telefone(rset.getString(2));
                    telefone.setId_cliente(rset.getInt(3));
                    telefones.add(telefone);
                    telefone = new Telefone();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return telefones;
        }
    }


    public List<Telefone> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        Telefone telefone = new Telefone();
        List<Telefone> telefones = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Endereco WHERE %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
                    telefone.setId(rset.getInt(1));
                    telefone.setNum_telefone(rset.getString(2));
                    telefone.setId_cliente(rset.getInt(3));
                    telefones.add(telefone);
                    telefone = new Telefone();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return telefones;
        }
    }
}

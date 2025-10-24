package br.com.example.saveit.saveitweb.model.cliente;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    //    Insert
    public boolean inserir(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente (nome, email, senha, tipo, tipo_venda, id_endereco, cnpj) Values(?,?,?,?,?,?,?)");//Comando SQL
//        Setando o valor dos parâmetros
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getSenha());
            pstmt.setString(4, cliente.getTipo());
            pstmt.setString(5, cliente.getTipo_venda());
            pstmt.setInt(6, cliente.getId_endereco());
            pstmt.setString(7, cliente.getCnpj());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql do preparedStament
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Cliente set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Cliente set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Cliente set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Cliente set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
                return validar;//True
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Cliente where %s = '%s'", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String excluir = String.format("delete from Cliente where %s = %d", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            Statement statement = conn.createStatement();//Criando objeto Statement
            boolean validar = statement.executeUpdate(excluir) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                statement.close();
                return validar;//True
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return false;
    }


    //    Select
    public List<Cliente> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();//Criando objeto Statement
            String query = "select * from Endereco";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
                while (rset.next()) {
                    cliente.setId(rset.getInt(1));
                    cliente.setNome(rset.getString(2));
                    cliente.setEmail(rset.getString(3));
                    cliente.setSenha(rset.getString(4));
                    cliente.setTipo(rset.getString(5));
                    cliente.setTipo_venda(rset.getString(6));
                    cliente.setId_endereco(rset.getInt(7));
                    cliente.setCnpj(rset.getString(8));
                    clientes.add(cliente);
                    cliente = new Cliente();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();//Criando objeto Statement
            String query = "select * from Endereco order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    cliente.setId(rset.getInt(1));
                    cliente.setNome(rset.getString(2));
                    cliente.setEmail(rset.getString(3));
                    cliente.setSenha(rset.getString(4));
                    cliente.setTipo(rset.getString(5));
                    cliente.setTipo_venda(rset.getString(6));
                    cliente.setId_endereco(rset.getInt(7));
                    cliente.setCnpj(rset.getString(8));
                    clientes.add(cliente);
                    cliente = new Cliente();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();//Criando objeto Statement
            String query = String.format("SELECT * FROM Endereco WHERE %s = '%s'", campoOndePesquisar, valorPesquisar);//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    cliente.setId(rset.getInt(1));
                    cliente.setNome(rset.getString(2));
                    cliente.setEmail(rset.getString(3));
                    cliente.setSenha(rset.getString(4));
                    cliente.setTipo(rset.getString(5));
                    cliente.setTipo_venda(rset.getString(6));
                    cliente.setId_endereco(rset.getInt(7));
                    cliente.setCnpj(rset.getString(8));
                    clientes.add(cliente);
                    cliente = new Cliente();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();//Criando objeto Statement
            String query = String.format("SELECT * FROM Endereco WHERE %s = %d", campoOndePesquisar, valorPesquisar);//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    cliente.setId(rset.getInt(1));
                    cliente.setNome(rset.getString(2));
                    cliente.setEmail(rset.getString(3));
                    cliente.setSenha(rset.getString(4));
                    cliente.setTipo(rset.getString(5));
                    cliente.setTipo_venda(rset.getString(6));
                    cliente.setId_endereco(rset.getInt(7));
                    cliente.setCnpj(rset.getString(8));
                    clientes.add(cliente);
                    cliente = new Cliente();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return clientes;//Retornando a lista de clientes
        }
    }
}

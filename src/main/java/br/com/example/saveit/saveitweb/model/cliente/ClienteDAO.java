package br.com.example.saveit.saveitweb.model.cliente;

import br.com.example.saveit.saveitweb.dao.Conexao;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    //    Insert
    public boolean inserir(Cliente cliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into Cliente (nome, email, senha, tipo, tipo_venda, id_endereco, cnpj, imagem) Values(?,?,?,?,?,?,?,?)");//Comando SQL
//        Setando valores
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getSenha());
            pstmt.setString(4, cliente.getTipo());
            pstmt.setString(5, cliente.getTipo_venda());
            pstmt.setInt(6, cliente.getId_endereco());
            pstmt.setString(7, cliente.getCnpj());
            pstmt.setString(8, cliente.getImagem());
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
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Cliente set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Cliente set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto PreparedStatement
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
            String query = String.format("Update Cliente set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto PreparedStatement
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
            conexao.desconectar(conn); // Desconectando do banco
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Cliente set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto PreparedStatement
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


    public boolean alterarImagem(File imagem, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        byte [] imagemBytes;//Iniciando variavel do tipo ByteArray

        try {
            Part partesAruivo = (Part) imagem;
            if (partesAruivo != null) {
                InputStream conteudoAruivo = partesAruivo.getInputStream();
                imagemBytes = IOUtils.toByteArray(conteudoAruivo);
                String query = "Update Cliente set imagem = ? where id = ?";//Comando SQL
                PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto PreparedStatement
                pstmt.setBytes(1, imagemBytes);
                pstmt.setInt(2, id);
                boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
//            Validação
                if (validar) {
                    pstmt.close();
                    return validar;//True
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


//    Delete

    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("delete from Cliente where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando objeto Statement
//            Setando valores
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
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String excluir = String.format("delete from Cliente where %s = ?", campoOndeExcluir);//Comando SQL
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
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    //    Select
    public List<Cliente> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//        Iniciando a lista de objetos Cliente
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Cliente";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Cliente cliente = new Cliente(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getString(9));
                    clientes.add(cliente);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//        Iniciando a lista de objetos Cliente
        List<Cliente> clientes = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Cliente order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Cliente cliente = new Cliente(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getString(9));
                    clientes.add(cliente);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM cliente WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Cliente cliente = new Cliente(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getString(9));
                    clientes.add(cliente);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco de dados
            return clientes;//Retornando a lista de clientes
        }
    }


    public List<Cliente> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//        Iniciando objeto Endereço e lista de objetos Cliente
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM cliente WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Cliente cliente = new Cliente(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getString(9));
                    clientes.add(cliente);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco de dados
            return clientes;//Retornando a lista de clientes
        }
    }
}

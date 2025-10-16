package br.com.example.saveit.saveitweb.model.pagamento;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagamentoDAO {
//    Insert
    public boolean inserir(Pagamento pagamento) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = "Insert into Pagamento (status, dt_criacao, dt_validade) Values(?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);
//          Setando o valor dos parâmetros
            pstmt.setString(1, pagamento.getStatus());
            pstmt.setString(2, pagamento.getDt_criacao());
            pstmt.setString(3, pagamento.getDt_validade());
            int validar = pstmt.executeUpdate();//Executando o comando sql do preparedStament
//              Validação
            if (validar > 0) {
                System.out.println("Inserido com sucesso!");
                return true;
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Pagamento set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
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
            String query = String.format("Update Pagamento set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
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
            String query = String.format("Update Pagamento set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
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
            String query = String.format("Update Pagamento set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
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
            String query = String.format("delete from Pagamento where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
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
            String query = String.format("delete from Pagamento where %s = %d", campoOndeExcluir, valorOndeExcluir);
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando
            if (validar) {
                System.out.println("Atualizado com sucesso!");
                return validar;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }
        return false;
    }



    //    Select
    public Map<Integer, Pagamento> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Pagamento pagamento = new Pagamento();
        Map<Integer, Pagamento> pagamentos = new HashMap<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from pagamento";
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    pagamento.setId(rset.getInt(1));
                    pagamento.setStatus(rset.getString(2));
                    pagamento.setDt_criacao(rset.getString(3));
                    pagamento.setDt_validade(rset.getString(4));
                    pagamentos.put(pagamento.getId(), pagamento);
                    pagamento = new Pagamento();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return pagamentos;
        }
    }


    public Map<Integer, Pagamento> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Pagamento pagamento = new Pagamento();
        Map<Integer, Pagamento> pagamentos = new HashMap<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from pagamento order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    pagamento.setId(rset.getInt(1));
                    pagamento.setStatus(rset.getString(2));
                    pagamento.setDt_criacao(rset.getString(3));
                    pagamento.setDt_validade(rset.getString(4));
                    pagamentos.put(pagamento.getId(), pagamento);
                    pagamento = new Pagamento();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return pagamentos;
        }
    }

    public Map<Integer, Pagamento> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Pagamento pagamento = new Pagamento();
        Map<Integer, Pagamento> pagamentos = new HashMap<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from industria where %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    pagamento.setId(rset.getInt(1));
                    pagamento.setStatus(rset.getString(2));
                    pagamento.setDt_criacao(rset.getString(3));
                    pagamento.setDt_validade(rset.getString(4));
                    pagamentos.put(pagamento.getId(), pagamento);
                    pagamento = new Pagamento();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return pagamentos;
        }
    }


    public Map<Integer, Pagamento> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Pagamento pagamento = new Pagamento();
        Map<Integer, Pagamento> pagamentos = new HashMap<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from industria where %s = %s", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    pagamento.setId(rset.getInt(1));
                    pagamento.setStatus(rset.getString(2));
                    pagamento.setDt_criacao(rset.getString(3));
                    pagamento.setDt_validade(rset.getString(4));
                    pagamentos.put(pagamento.getId(), pagamento);
                    pagamento = new Pagamento();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return pagamentos;
        }
    }
}

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
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando SQL
            pstmt.close();
            return validar;
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
            String query = String.format("Update Pagamento set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Pagamento set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Pagamento set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorAlterar);
            pstmt.setInt(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Pagamento set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorAlterar);
            pstmt.setString(2, valorOndeAlterar);
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }




    //    Delete
    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Pagamento where %s = ?", campoOndeExcluir);
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorOndeExcluir);//Setando valor
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando
            pstmt.close();
            return validar;
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
            String query = String.format("delete from Pagamento where %s = ?", campoOndeExcluir);
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);//Setando valor
            boolean validar = pstmt.executeUpdate(query) > 0;//Executando comando
            pstmt.close();
            return validar;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }



    //    Select
    public List<Pagamento> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from pagamento";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Pagamento pagamento = new Pagamento(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                    pagamentos.add(pagamento);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando comando SQL
            return pagamentos;//Retornando lista de pagamentos
        }
    }


    public List<Pagamento> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from pagamento order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Pagamento pagamento = new Pagamento(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                    pagamentos.add(pagamento);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando comando SQL
            return pagamentos;//Retornando lista de pagamentos
        }
    }

    public List<Pagamento> buscar(int campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from pagamento order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Pagamento pagamento = new Pagamento(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                    pagamentos.add(pagamento);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando comando SQL
            return pagamentos;//Retornando lista de pagamentos
        }
    }

    public List<Pagamento> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando a lista de objetos Industrias
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            String query = String.format("select * from industria where %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);//Setando valor
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Pagamento pagamento = new Pagamento(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                    pagamentos.add(pagamento);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando comando SQL
            return pagamentos;//Retornando lista de pagamentos
        }
    }


    public List<Pagamento> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            String query = String.format("select * from industria where %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);//Setando valor
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Pagamento pagamento = new Pagamento(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
                    pagamentos.add(pagamento);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando comando SQL
            return pagamentos;//Retornando lista de pagamentos
        }
    }


    public List<String> buscarDadosPlano(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de dados
        List<String> dadosPlano = new ArrayList<>();
        String query = "select pl.descricao as servico, pl.preco, pg.status, pg.id as id_pagamento, pg.dt_criacao as dt_pagamento, pg.dt_validade, pg.forma_pagamento from industria i left join plano pl on i.id_plano = pl.id left join pagamento pg on i.id_pagamento = pg.id where i.id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, id);//Setando valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    dadosPlano.add(rset.getString("servico"));
                    dadosPlano.add(rset.getString("preco"));
                    dadosPlano.add(rset.getString("status"));
                    dadosPlano.add(rset.getString("id_pagamento"));
                    dadosPlano.add(rset.getString("dt_pagamento"));
                    dadosPlano.add(rset.getString("dt_validade"));
                    dadosPlano.add(rset.getString("forma_pagamento"));
                }

                return dadosPlano;
            }else {
                return null;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
    }


}

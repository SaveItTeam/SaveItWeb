package br.com.example.saveit.saveitweb.model.plano;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanoDAO {
    //    Insert
    public boolean inserir(Plano plano) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = "Insert into Plano (preco, descricao, id_pagamento) Values(?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);
//          Setando o valor dos parâmetros
            pstmt.setDouble(1, plano.getPreco());
            pstmt.setString(2, plano.getDescricao());
            pstmt.setInt(3, plano.getId_pagamento());
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
            String query = String.format("Update Plano set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("Update Plano set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("Update Plano set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("delete from Plano where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
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
            String query = String.format("delete from Plano where %s = %d", campoOndeExcluir, valorOndeExcluir);
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
    public List<Plano> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Plano plano = new Plano();
        List<Plano> planos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Plano";
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    plano.setId(rset.getInt(1));
                    plano.setPreco(rset.getDouble(2));
                    plano.setDescricao(rset.getString(3));
                    plano.setId_pagamento(rset.getInt(4));
                    planos.add(plano);
                    plano = new Plano();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return planos;
        }
    }


    public List<Plano> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Plano plano = new Plano();
        List<Plano> planos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from plano order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    plano.setId(rset.getInt(1));
                    plano.setPreco(rset.getDouble(2));
                    plano.setDescricao(rset.getString(3));
                    plano.setId_pagamento(rset.getInt(4));
                    planos.add(plano);
                    plano = new Plano();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return planos;
        }
    }

    public List<Plano> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Plano plano = new Plano();
        List<Plano> planos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from plano where %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    plano.setId(rset.getInt(1));
                    plano.setPreco(rset.getDouble(2));
                    plano.setDescricao(rset.getString(3));
                    plano.setId_pagamento(rset.getInt(4));
                    planos.add(plano);
                    plano = new Plano();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return planos;
        }
    }


    public List<Plano> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
        Plano plano = new Plano();
        List<Plano> planos = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from plano where %s = %s", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
                    plano.setId(rset.getInt(1));
                    plano.setPreco(rset.getDouble(2));
                    plano.setDescricao(rset.getString(3));
                    plano.setId_pagamento(rset.getInt(4));
                    planos.add(plano);
                    plano = new Plano();
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
            return planos;
        }
    }
}

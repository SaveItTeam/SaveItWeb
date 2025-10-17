package br.com.example.saveit.saveitweb.model.industria;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustriaDAO {
//    Insert
    public boolean inserir(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = "Insert into Industria (id_plano, vende, id_pagamento) Values(?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);
//          Setando o valor dos parâmetros
            pstmt.setInt(1, industria.getId_plano());
            pstmt.setString(2, industria.getVende());
            pstmt.setInt(3, industria.getId_pagamento());
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
            String query = String.format("Update Industria set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("Update Industria set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("Update Industria set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
            String query = String.format("Update Industria set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
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
        String query = String.format("delete from Industria where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
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
            String query = String.format("delete from Industria where %s = %d", campoOndeExcluir, valorOndeExcluir);
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
public List<Industria> buscar() {
    Conexao conexao = new Conexao();
    Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//    Iniciando objeto Industria e lista de objetos Industrias
    Industria industria = new Industria();
    List<Industria> industrias = new ArrayList<>();
    try {
//            Iniciando objeto Statment
        Statement stmt = conn.createStatement();
        String query = "select * from industria";
        ResultSet rset = stmt.executeQuery(query);

        if (rset != null) {
            while (rset.next()) {
                industria.setId(rset.getInt(1));
                industria.setId_plano(rset.getInt(2));
                industria.setVende(rset.getString(3));
                industria.setId_pagamento(rset.getInt(4));
                industrias.add(industria);
                industria = new Industria();
            }
        }
        stmt.close();
    } catch (SQLException sqle) {
        sqle.printStackTrace();
        return null;
    } finally {
        conexao.desconectar(conn);
        return industrias;
    }
}


    public List<Industria> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Industria e lista de objetos Industrias
        Industria industria = new Industria();
        List<Industria> industrias = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from industria order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    industria.setId(rset.getInt(1));
                    industria.setId_plano(rset.getInt(2));
                    industria.setVende(rset.getString(3));
                    industria.setId_pagamento(rset.getInt(4));
                    industrias.add(industria);
                    industria = new Industria();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return industrias;
        }
    }


    public List<Industria> buscar(String campoOndePesquisar, String valorPesquisar) {
        ResultSet rset;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Industria e lista de objetos Industrias
        Industria industria = new Industria();
        List<Industria> industrias = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from industria where %s = %d", campoOndePesquisar, valorPesquisar);
            rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    industria.setId(rset.getInt(1));
                    industria.setId_plano(rset.getInt(2));
                    industria.setVende(rset.getString(3));
                    industria.setId_pagamento(rset.getInt(4));
                    industrias.add(industria);
                    industria = new Industria();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return industrias;
        }
    }


    public List<Industria> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Industria e lista de objetos Industrias
        Industria industria = new Industria();
        List<Industria> industrias = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM industria WHERE %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);
            if (rset != null) {
                while (rset.next()) {
//                    Inserssão de dados
                    industria.setId(rset.getInt(1));
                    industria.setId_plano(rset.getInt(2));
                    industria.setVende(rset.getString(3));
                    industria.setId_pagamento(rset.getInt(4));
                    industrias.add(industria);
                    industria = new Industria();
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Fechando conexão com o banco
            return industrias;
        }
    }
}

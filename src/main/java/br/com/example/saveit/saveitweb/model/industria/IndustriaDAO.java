package br.com.example.saveit.saveitweb.model.industria;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndustriaDAO {
//    Insert
    public boolean inserir(Industria industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = "Insert into Industria(vende, id_plano, cod_industria, id_pagamento, id_cliente) Values(?,?,?,?,?)";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Executando comando SQL
//          Setando o valor dos parâmetros
            pstmt.setString(1, industria.getVende());
            pstmt.setInt(2, industria.getId_plano());
            pstmt.setString(3, industria.getCod_industria());
            pstmt.setInt(4, industria.getId_pagamento());
            pstmt.setInt(5, industria.getId_cliente());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql do preparedStament
//              Validação
            if (validar) {
                return validar;//True
            }
            pstmt.close();
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
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Industria set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                return validar;//True
            }
            statement.close();
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
            String query = String.format("Update Industria set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                return validar;//True
            }
            statement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Industria set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                return validar;//True
            }
            statement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
        try {
            String query = String.format("Update Industria set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                return validar;//True
            }
            statement.close();
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
    Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
    try {
        String query = String.format("delete from Industria where %s = '%s'", campoOndeExcluir, valorOndeExcluir);//Comando SQL
        Statement statement = conn.createStatement();//Criando statement
        boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
        if (validar) {
            return validar;//True
        }
        statement.close();
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
            String query = String.format("delete from Industria where %s = %d", campoOndeExcluir, valorOndeExcluir);//Comando SQL
            Statement statement = conn.createStatement();//Criando statement
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                return validar;//True
            }
            statement.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }



//    Select
public List<Industria> buscar() {
    Conexao conexao = new Conexao();
    Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Industria
    List<Industria> industrias = new ArrayList<>();
    try {
//            Iniciando objeto Statment
        Statement stmt = conn.createStatement();
        String query = "select * from industria";//Comando SQL
        ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

        if (rset != null) {
//                Inserção de dados
            while (rset.next()) {
                Industria industria = new Industria(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
                industrias.add(industria);
            }
        }
        stmt.close();
    } catch (SQLException sqle) {
        sqle.printStackTrace();
        return null;
    } finally {
        conexao.desconectar(conn);//Desconectando do banco de dados
        return industrias;//Retornando a lista de industrias
    }
}


    public List<Industria> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Industria
        List<Industria> industrias = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from industria order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Industria industria = new Industria(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
                    industrias.add(industria);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return industrias;//Retornando a lista de industrias
        }
    }


    public List<Industria> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Industria
        List<Industria> industrias = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM industria WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Industria industria = new Industria(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
                    industrias.add(industria);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return industrias;//Retornando a lista de industrias
        }
    }


    public List<Industria> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Industria
        List<Industria> industrias = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM industria WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Industria industria = new Industria(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getInt(5), rset.getInt(6));
                    industrias.add(industria);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return industrias;//Retornando a lista de industrias
        }
    }


    public List<String> buscarDados(int id_industria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de dados da Industria
        List<String> dadosIndustria = new ArrayList<>();
        try {
            String query = "select\n" +
                    "    c.nome\n" +
                    "     , e.cep_estado\n" +
                    "     , e.cep_cidade\n" +
                    "     , e.cep\n" +
                    "     , e.cep_bairro\n" +
                    "     , string_agg(distinct (t.num_telefone), '; ') as contato\n" +
                    "     , c.tipo_venda\n" +
                    "     , e.cep_rua\n" +
                    "     , e.cep_complemento\n" +
                    "     , string_agg(distinct (case\n" +
                    "                                when emp.id = 12 then emp.procura\n" +
                    "                                else ind.vende\n" +
                    "    end)\n" +
                    "    , '; ') as categoria_prod\n" +
                    "\n" +
                    "from cliente c\n" +
                    "         join endereco e on e.id = c.id_endereco\n" +
                    "         join telefone t on c.id = t.id_cliente\n" +
                    "         left join empresa emp on c.id = emp.id_cliente\n" +
                    "         left join industria ind on t.id_cliente = ind.id_cliente\n" +
                    "where ind.id = 12\n" +
                    "group by 1, 2, 3,4,5,7,8,9";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, id_industria);
            pstmt.setInt(2, id_industria);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL
            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    dadosIndustria.add(rset.getString(1));
                    dadosIndustria.add(rset.getString(2));
                    dadosIndustria.add(rset.getString(3));
                    dadosIndustria.add(rset.getString(4));
                    dadosIndustria.add(rset.getString(5));
                    dadosIndustria.add(rset.getString(6));
                    dadosIndustria.add(rset.getString(7));
                    dadosIndustria.add(rset.getString(8));
                    dadosIndustria.add(rset.getString(9));
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return dadosIndustria;//Retornando a lista de industrias
        }
    }
}

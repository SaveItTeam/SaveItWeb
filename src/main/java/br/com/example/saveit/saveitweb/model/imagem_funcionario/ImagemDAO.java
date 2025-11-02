package br.com.example.saveit.saveitweb.model.imagem_funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImagemDAO {
    //    Insert
    public boolean inserir(Imagem imagem_) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            PreparedStatement pstmt = conn.prepareStatement("Insert into imagem(url, id_funcionario) Values(?,?)");//Comando SQL
//        Setando o valor dos parâmetros
            pstmt.setString(1, imagem_.getUrl());
            pstmt.setInt(2, imagem_.getId_funcionario());
            boolean validar = pstmt.executeUpdate() > 0;//Executando o comando sql
//            Validação
            if (validar) {
                return validar;//True
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Imagem_Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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


//    Delete

    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Imagem_Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);
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


    //    Select
    public List<Imagem> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Imagem_Funcionario";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem imagem_ = new Imagem(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem> imagens_funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Imagem_Funcionario order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem imagem_ = new Imagem(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem> imagens_funcionarios = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem imagem_ = new Imagem(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }


    public List<Imagem> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Imagem_Funcionario
        List<Imagem> imagens_funcionarios = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM Imagem_Funcionario WHERE %s = ?", campoOndePesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
                while (rset.next()) {
                    Imagem imagem_ = new Imagem(rset.getInt(1), rset.getString(2), rset.getInt(3));
                    imagens_funcionarios.add(imagem_);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return imagens_funcionarios;//Retornando a lista de imagem_funcionario
        }
    }

    public byte[] buscarImagemFuncionario(int idFuncionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT url FROM imagem WHERE id_funcionario = ?";

        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            pmst.setInt(1, idFuncionario);
            ResultSet rs = pmst.executeQuery();

            if (rs.next()) {
                return rs.getBytes("url");
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // MÉTODO PARA SALVAR IMAGEM DA EMPRESA (usando id_cliente)
    public boolean salvarImagemEmpresa(byte[] imagemBytes, int idCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            // Verificar se já existe imagem para este cliente/empresa
            String verificarSql = "SELECT id FROM imagem WHERE id_cliente = ?";
            PreparedStatement verificarStmt = conn.prepareStatement(verificarSql);
            verificarStmt.setInt(1, idCliente);
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next()) {
                // Já existe → UPDATE
                int idImagem = rs.getInt("id");
                String updateSql = "UPDATE imagem SET url = ?, id_funcionario = NULL WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setBytes(1, imagemBytes);
                updateStmt.setInt(2, idImagem);
                return updateStmt.executeUpdate() > 0;
            } else {
                // Não existe → INSERT
                String insertSql = "INSERT INTO imagem(url, id_cliente, id_funcionario) VALUES(?, ?, NULL)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setBytes(1, imagemBytes);
                insertStmt.setInt(2, idCliente);
                return insertStmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // MÉTODO PARA BUSCAR IMAGEM DA EMPRESA
    public byte[] buscarImagemEmpresa(int idCliente) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String sql = "SELECT url FROM imagem WHERE id_cliente = ?";

        try {
            PreparedStatement pmst = conn.prepareStatement(sql);
            pmst.setInt(1, idCliente);
            ResultSet rs = pmst.executeQuery();

            if (rs.next()) {
                return rs.getBytes("url");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ATUALIZE TAMBÉM O MÉTODO DO FUNCIONÁRIO PARA GARANTIR id_cliente = NULL
    public boolean salvarImagemFuncionario(byte[] imagemBytes, int idFuncionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            // Verificar se já existe imagem para este funcionário
            String verificarSql = "SELECT id FROM imagem WHERE id_funcionario = ?";
            PreparedStatement verificarStmt = conn.prepareStatement(verificarSql);
            verificarStmt.setInt(1, idFuncionario);
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next()) {
                // Já existe → UPDATE
                int idImagem = rs.getInt("id");
                String updateSql = "UPDATE imagem SET url = ?, id_cliente = NULL WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setBytes(1, imagemBytes);
                updateStmt.setInt(2, idImagem);
                return updateStmt.executeUpdate() > 0;
            } else {
                // Não existe → INSERT
                String insertSql = "INSERT INTO imagem(url, id_funcionario, id_cliente) VALUES(?, ?, NULL)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setBytes(1, imagemBytes);
                insertStmt.setInt(2, idFuncionario);
                return insertStmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

package br.com.example.saveit.saveitweb.model.funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
//    Insert
    public boolean inserirFuncionario(Funcionario funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();//Abrindo conexão com o banco de dados
//        Comando SQL
        String query = "Insert into funcionario (nome, cpf, rg, genero, dt_nascimento, email, senha, cargo, dt_contratacao, telefone_pessoal, telefone_trabalho, experiencia, id_empresa, id_industria, is_admin) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, String.valueOf(funcionario.getGenero()));
            stmt.setDate(5, funcionario.getDt_nascimento());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getSenha());
            stmt.setString(8, funcionario.getCargo());
            stmt.setDate(9, funcionario.getDt_contratacao());
            stmt.setString(10, funcionario.getTelefone_pessoal());
            stmt.setString(11, funcionario.getTelefone_trabalho());
            stmt.setString(12, funcionario.getExperiencia());
            stmt.setInt(13, funcionario.getId_empresa());
            stmt.setInt(14, funcionario.getId_industria());
            stmt.setBoolean(15, funcionario.getIs_admin());

            boolean validar = stmt.executeUpdate() > 0;//Executando comando SQL

            stmt.close();

            return validar;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
    }



//    Updates
    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setString(1, valorAlterar);
            statement.setString(2, valorOndeAlterar);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar,  String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setInt(1, valorAlterar);
            statement.setString(2, valorOndeAlterar);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, String valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setString(1, valorAlterar);
            statement.setInt(2, valorOndeAlterar);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }


    public boolean alterar(String campoAlterar, int valorAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("Update Funcionario set %s = ? where %s = ?", campoAlterar, ondeAlterar);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setInt(1, valorAlterar);
            statement.setInt(2, valorOndeAlterar);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }




//    Deletes
    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setString(1, valorOndeExcluir);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }


    public boolean excluir(String campoOndeExcluir, int valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement statement = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            statement.setInt(1, valorOndeExcluir);
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando SQL
//            Validação
            if (validar) {
                statement.close();
                return validar;//True
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);// Desconectando do banco de dados
        }
        return false;
    }





//    Selects
    public List<Funcionario> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo conexão com o banco de dados
//        Iniciando a lista de objetos Funcionário
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Funcionario";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Setando valores
                while (rset.next()) {
                    Funcionario funcionario = new Funcionario(rset.getInt("id"), rset.getString("nome"), rset.getString("cpf"), rset.getString("rg"), rset.getString("genero").charAt(0), rset.getDate("dt_nascimento"), rset.getString("email"), rset.getString("senha"), rset.getString("cargo"), rset.getDate("dt_contratacao"), rset.getString("telefone_pessoal"), rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"), rset.getInt("id_empresa"), rset.getInt("id_industria"), rset.getBoolean("is_admin"));
                    funcionarios.add(funcionario);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionários
        }
    }


    public List<Funcionario> buscar(String campoOrdenar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Funcionario order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Setando valores
                while (rset.next()) {
                    Funcionario funcionario = new Funcionario(rset.getInt("id"), rset.getString("nome"), rset.getString("cpf"), rset.getString("rg"), rset.getString("genero").charAt(0), rset.getDate("dt_nascimento"), rset.getString("email"), rset.getString("senha"), rset.getString("cargo"), rset.getDate("dt_contratacao"), rset.getString("telefone_pessoal"), rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"), rset.getInt("id_empresa"), rset.getInt("id_industria"), rset.getBoolean("is_admin"));
                    funcionarios.add(funcionario);
                }
            }
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionários
        }
    }


    public List<Funcionario> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando a lista de objetos Funcionario
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            String query = String.format("select * from Funcionario where %s = ?", campoOndePesquisar, valorPesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Setando valores
                while (rset.next()) {
                    Funcionario funcionario = new Funcionario(rset.getInt("id"), rset.getString("nome"), rset.getString("cpf"), rset.getString("rg"), rset.getString("genero").charAt(0), rset.getDate("dt_nascimento"), rset.getString("email"), rset.getString("senha"), rset.getString("cargo"), rset.getDate("dt_contratacao"), rset.getString("telefone_pessoal"), rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"), rset.getInt("id_empresa"), rset.getInt("id_industria"), rset.getBoolean("is_admin"));
                    funcionarios.add(funcionario);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionários
        }
    }


    public List<Funcionario> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            String query = String.format("select * from Funcionario where %s = ?", campoOndePesquisar, valorPesquisar);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, valorPesquisar);
            ResultSet rset = pstmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Setando valores
                while (rset.next()) {
                    Funcionario funcionario = new Funcionario(rset.getInt("id"), rset.getString("nome"), rset.getString("cpf"), rset.getString("rg"), rset.getString("genero").charAt(0), rset.getDate("dt_nascimento"), rset.getString("email"), rset.getString("senha"), rset.getString("cargo"), rset.getDate("dt_contratacao"), rset.getString("telefone_pessoal"), rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"), rset.getInt("id_empresa"), rset.getInt("id_industria"), rset.getBoolean("is_admin"));
                    funcionarios.add(funcionario);
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionários
        }
    }


//    Logar Funcionário
    public List<String> logarFuncionarioAdmin(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();
        ResultSet rs;
        List<String> funcionarios = new ArrayList<>();



        String sql = """
            SELECT
            CASE
            WHEN id_empresa IS NULL THEN 'industria'
            WHEN id_industria IS NULL THEN 'empresa'
            END AS tipo,
            coalesce(id_empresa, id_industria) AS id_estabelecimento
            FROM FUNCIONARIO
            WHERE (cpf = ? OR email = ?)
            AND senha = ?
            AND is_admin = TRUE;
            """;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.setString(3, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                funcionarios.add(rs.getString("tipo"));
                funcionarios.add(rs.getString("id_estabelecimento"));
                return funcionarios;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
        }
    }

}

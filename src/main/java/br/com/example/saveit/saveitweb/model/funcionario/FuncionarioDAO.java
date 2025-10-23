package br.com.example.saveit.saveitweb.model.funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
//    Insert
    public boolean inserirFuncionario(Funcionario funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();

        String sql = "Insert into funcionario (nome, cpf, rg, genero, dt_nascimento, email, senha, cargo, dt_contratacao, telefone_pessoal, telefone_trabalho, experiencia, id_empresa, id_industria, is_admin) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
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

            int validar = stmt.executeUpdate();

            stmt.close();

            return validar > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);
        }
    }



//    Updates
    public boolean alterar(String valorAlterar, String campoAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Funcionario set %s = '%s' where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
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
            return false;
        }
    }


    public boolean alterar(String valorAlterar, int campoAlterar, String ondeAlterar, String valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Funcionario set %s = %d where %s = '%s'", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
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
            return false;
        }
    }


    public boolean alterar(String valorAlterar, String campoAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Funcionario set %s = '%s' where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
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
            return false;
        }
    }


    public boolean alterar(String valorAlterar, int campoAlterar, String ondeAlterar, int valorOndeAlterar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("Update Funcionario set %s = %d where %s = %d", campoAlterar, valorAlterar, ondeAlterar, valorOndeAlterar);//Comando SQL
            Statement statement = conn.createStatement();
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
            return false;
        }
    }




//    Deletes
    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Funcionario where %s = '%s'", campoOndeExcluir, valorOndeExcluir);
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando
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
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco
        try {
            String query = String.format("delete from Funcionario where %s = %d", campoOndeExcluir, valorOndeExcluir);
            Statement statement = conn.createStatement();
            boolean validar = statement.executeUpdate(query) > 0;//Executando comando
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





//    Selects
    public List<Funcionario> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Funcionario";
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
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
            conexao.desconectar(conn);
            return funcionarios;
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
            String query = "select * from Funcionario order by " + campoOrdenar;
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
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
            conexao.desconectar(conn);
            return funcionarios;
        }
    }


    public List<Funcionario> buscar(String campoOndePesquisar, String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from Funcionario where %s = '%s'", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
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
            conexao.desconectar(conn);
            return funcionarios;
        }
    }


    public List<Funcionario> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando cnexão com o banco
//        Iniciando objeto Endereço e lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = String.format("select * from Funcionario where %s = %d", campoOndePesquisar, valorPesquisar);
            ResultSet rset = stmt.executeQuery(query);

            if (rset != null) {
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
            conexao.desconectar(conn);
            return funcionarios;
        }
    }


//    Logar Funcionário
    public ResultSet logarAdmin(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();
        ResultSet rs = null;

        String sql = "SELECT email, senha FROM funcionario WHERE email = ? AND senha = ? --AND isAdmin = true";
        String sql2 = "SELECT cpf, senha FROM funcionario WHERE cpf = ? AND senha = ? --AND isAdmin = true";
        String sql3 = "SELECT email, senha FROM admin WHERE email = ? AND senha = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs;
            } else {
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, email);
                stmt2.setString(2, senha);

                rs = stmt2.executeQuery();

                if (rs.next()) {
                    return rs;
                } else {
                    PreparedStatement stmt3 = conn.prepareStatement(sql3);
                    stmt3.setString(1, email);
                    stmt3.setString(2, senha);

                    rs = stmt3.executeQuery();

                    if (rs.next()) {
                        return rs;
                    } else {
                        return null;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);
        }
    }

}

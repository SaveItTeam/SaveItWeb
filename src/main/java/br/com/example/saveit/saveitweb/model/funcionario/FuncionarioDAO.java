package br.com.example.saveit.saveitweb.model.funcionario;

import br.com.example.saveit.saveitweb.dao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    //    Updates
    public boolean alterarNome(String novoNome, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Funcionario set nome = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, novoNome);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }

    public boolean alterarEmail(String novoEmail, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Funcionario set email = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, novoEmail);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }

    public boolean alterarSenha(String novaSenha, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Funcionario set senha = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, novaSenha);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }

    public boolean alterarCargo(String novoCargo, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Funcionario set cargo = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, novoCargo);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }

    public boolean alterarTelefone(String novoTelefone, int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "Update Funcionario set telefone_pessoal = ? where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
//            Setando valores
            pstmt.setString(1, novoTelefone);
            pstmt.setInt(2, id);
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn); // Desconectando do banco de dados
        }
        return false;
    }


    //    Deletes
    public boolean excluir(String campoOndeExcluir, String valorOndeExcluir) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setString(1, valorOndeExcluir);//Setando valor
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
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
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = String.format("delete from Funcionario where %s = ?", campoOndeExcluir);//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, valorOndeExcluir);//Setando vlaor
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }

    public boolean excluiPorId(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Abrindo a conexão com o banco de dados
        try {
            String query = "delete from Funcionario where id = ?";//Comando SQL
            PreparedStatement pstmt = conn.prepareStatement(query);//Criando PreparedStatement
            pstmt.setInt(1, id);//Setando vlaor
            boolean validar = pstmt.executeUpdate() > 0;//Executando comando SQL
            pstmt.close();
            return validar;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
        }
        return false;
    }

    // Método para inserir novo funcionário
    public boolean inserirFuncionario(Funcionario funcionario) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {
            String sql = "INSERT INTO funcionario (nome, email, senha, telefone_pessoal, telefone_trabalho, " +
                    "cargo, dt_contratacao, cpf, rg, id_industria, is_admin, genero) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getEmail());
            pstmt.setString(3, funcionario.getSenha());
            pstmt.setString(4, funcionario.getTelefone_pessoal());
            pstmt.setString(5, funcionario.getTelefone_trabalho());
            pstmt.setString(6, funcionario.getCargo());
            pstmt.setDate(7, funcionario.getDt_contratacao());
            pstmt.setString(8, funcionario.getCpf());
            pstmt.setString(9, funcionario.getRg());
            pstmt.setInt(10, funcionario.getId_industria());
            pstmt.setBoolean(11, funcionario.getIs_admin());
            pstmt.setString(12, String.valueOf(funcionario.getGenero()));

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(conn);
        }
    }

    // Método para buscar funcionário por email
    public List<Funcionario> buscarPorEmail(String email) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM funcionario WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                Funcionario funcionario = new Funcionario(
                        rset.getInt("id"),
                        rset.getString("nome"),
                        rset.getString("email"),
                        rset.getString("senha"),
                        rset.getString("telefone_pessoal"),
                        rset.getString("telefone_trabalho"),
                        rset.getString("cargo"),
                        rset.getDate("dt_contratacao"),
                        rset.getString("cpf"),
                        rset.getString("rg"),
                        rset.getInt("id_industria"),
                        rset.getBoolean("is_admin"),
                        rset.getString("genero").charAt(0)
                );
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }

        return funcionarios;
    }

    // Método para buscar todos os funcionários por indústria
    public List<Funcionario> buscarTodosPorIndustria(int idIndustria) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM funcionario WHERE id_industria = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idIndustria);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                Funcionario funcionario = new Funcionario(
                        rset.getInt("id"),
                        rset.getString("nome"),
                        rset.getString("email"),
                        rset.getString("senha"),
                        rset.getString("telefone_pessoal"),
                        rset.getString("telefone_trabalho"),
                        rset.getString("cargo"),
                        rset.getDate("dt_contratacao"),
                        rset.getString("cpf"),
                        rset.getString("rg"),
                        rset.getInt("id_industria"),
                        rset.getBoolean("is_admin"),
                        rset.getString("genero").charAt(0)
                );
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }

        return funcionarios;
    }




    //    Selects
    public List<Funcionario> buscar() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Funcionario";//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
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
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
//            Iniciando objeto Statment
            Statement stmt = conn.createStatement();
            String query = "select * from Funcionario order by " + campoOrdenar;//Comando SQL
            ResultSet rset = stmt.executeQuery(query);//Executando comando SQL

            if (rset != null) {
//                Inserção de dados
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


    public List<Funcionario> buscarId(int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario WHERE  id = ?";//Comando SQL

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setInt(1, valorPesquisar);//Setando Valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    funcionarios.add(new Funcionario(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("rg"),
                            rset.getString("genero").charAt(0),
                            rset.getDate("dt_nascimento"),
                            rset.getString("email"),
                            rset.getString("senha"),
                            rset.getString("cargo"),
                            rset.getDate("dt_contratacao"),
                            rset.getString("telefone_pessoal"),
                            rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"),
                            rset.getInt("id_empresa"),
                            rset.getInt("id_industria"),
                            rset.getBoolean("is_admin")
                    ));
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionarios
        }
    }
    public List<Funcionario> buscarFuncionarioPorAdminINDUSTRIA(int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario WHERE  id_industria = ?";//Comando SQL

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setInt(1, valorPesquisar);//Setando Valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    funcionarios.add(new Funcionario(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("rg"),
                            rset.getString("genero").charAt(0),
                            rset.getDate("dt_nascimento"),
                            rset.getString("email"),
                            rset.getString("senha"),
                            rset.getString("cargo"),
                            rset.getDate("dt_contratacao"),
                            rset.getString("telefone_pessoal"),
                            rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"),
                            rset.getInt("id_empresa"),
                            rset.getInt("id_industria"),
                            rset.getBoolean("is_admin")
                    ));
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionarios
        }
    }

    public List<Funcionario> buscarFuncionarioPorAdminEMPRESA(int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario WHERE  id_empresa = ?";//Comando SQL

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setInt(1, valorPesquisar);//Setando Valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    funcionarios.add(new Funcionario(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("rg"),
                            rset.getString("genero").charAt(0),
                            rset.getDate("dt_nascimento"),
                            rset.getString("email"),
                            rset.getString("senha"),
                            rset.getString("cargo"),
                            rset.getDate("dt_contratacao"),
                            rset.getString("telefone_pessoal"),
                            rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"),
                            rset.getInt("id_empresa"),
                            rset.getInt("id_industria"),
                            rset.getBoolean("is_admin")
                    ));
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionarios
        }
    }

    public List<Funcionario> buscarEmail(String valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario WHERE  email = ?";//Comando SQL

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setString(1, valorPesquisar);//Setando Valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    funcionarios.add(new Funcionario(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("rg"),
                            rset.getString("genero").charAt(0),
                            rset.getDate("dt_nascimento"),
                            rset.getString("email"),
                            rset.getString("senha"),
                            rset.getString("cargo"),
                            rset.getDate("dt_contratacao"),
                            rset.getString("telefone_pessoal"),
                            rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"),
                            rset.getInt("id_empresa"),
                            rset.getInt("id_industria"),
                            rset.getBoolean("is_admin")
                    ));
                }
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionarios
        }
    }


    public List<Funcionario> buscar(String campoOndePesquisar, int valorPesquisar) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();//Iniciando conexão com o banco de dados
//        Iniciando a lista de objetos Endereço
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM Funcionario WHERE " + campoOndePesquisar + " = ?";//Comando SQL

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);//Iniciando PreparedStatement
            pstmt.setInt(1, valorPesquisar );//Setando Valor

            ResultSet rset = pstmt.executeQuery();//Executando comando SQL

            if (rset != null) {
//                Inserção de valores
                while (rset.next()) {
                    funcionarios.add(new Funcionario(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("rg"),
                            rset.getString("genero").charAt(0),
                            rset.getDate("dt_nascimento"),
                            rset.getString("email"),
                            rset.getString("senha"),
                            rset.getString("cargo"),
                            rset.getDate("dt_contratacao"),
                            rset.getString("telefone_pessoal"),
                            rset.getString("telefone_trabalho"),
                            rset.getString("experiencia"),
                            rset.getInt("id_empresa"),
                            rset.getInt("id_industria"),
                            rset.getBoolean("is_admin")
                    ));
                }
            } else {
                return null;
            }
            pstmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.desconectar(conn);//Desconectando do banco de dados
            return funcionarios;//Retornando a lista de funcionarios
        }
    }


    //    Logar Funcionário
    public List<String> logarAdmin(String email, String senha) {
        Conexao conexao = new Conexao();
        Connection conn = Conexao.conectar();//Abrindo conexão com o banco de dados

        ResultSet rs;
        List<String> funcionarios = new ArrayList<>();//Instanciando a lista de objetos Funcionario

        String sql = """   
             -- ========================== resultado da minha escravidao pt.213 ==========================
        with info_func as (  -- CTE de validação de login + busca de informações associadas ao funcionário
            select
                f.id as id_func
                , f.nome as nome_func
                , f.email
                , f.telefone_trabalho
                , coalesce(id_empresa, id_industria) AS id_estabelecimento   -- campo com id do estabelecimento a depender de seu tipo (industria // empresa)
                , case
                    when id_empresa is null then 'Saveit Pro'
                    when id_industria is null then 'Saveit Basico'
            end as plano  -- campo com o plano ativo do estabelecimento do funcionário
            , case
                when id_empresa is not null then 'Empresa'
                when id_industria is not null then 'Industria'
            end as tipo
            , i.url as img_func
            , f.genero
            from funcionario f
            left join imagem i on f.id = i.id_funcionario
            where (cpf = ? or email = ?)
            and senha = ?
            and is_admin = true
        )
        , info_estab as (
            select
                c.nome as nome_empresa
                , c.cnpj
                , c.tipo_venda
                , t.num_telefone
                , concat(e.cep_rua, ', ', cep_rua_num, ' - ', e.cep_bairro, ' ', e.cep_estado) as endereco
                , i.url as img_estab
            from cliente c
                join telefone t on c.id = t.id_cliente
                join endereco e on e.id = c.id_endereco
                left join imagem i on c.id = i.id_cliente
        )
        , cont_func as (
            select
                case
                    when id_empresa is not null then 'Empresa'
                    when id_industria is not null then 'Industria'
                end as tipo
                , coalesce(id_empresa, id_industria) AS id_estabelecimento
                , case
                    when id_empresa is not null then e.procura
                    when id_industria is not null then i.vende
                end as atividade_comercial
                , count(f.id) as cont_func
            from funcionario f
            left join empresa e on f.id_empresa = e.id
            left join industria i on f.id_industria = i.id
            group by 1, 2, 3
        )
        select
            f.*
            , e.*
            , c.cont_func
            , c.atividade_comercial
        from info_func f
        left join info_estab e on f.telefone_trabalho = e.num_telefone
        left join cont_func c on c.tipo = f.tipo and c.id_estabelecimento = f.id_estabelecimento;
        """;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            Setando valores
            pstmt.setString(1, email);
            pstmt.setString(2, email);
            pstmt.setString(3, senha);

            rs = pstmt.executeQuery();//Executando comando SQL

            if (rs != null) {
                while (rs.next()) {
                    funcionarios.add(rs.getString("id_func"));
                    funcionarios.add(rs.getString("nome_func"));
                    funcionarios.add(rs.getString("telefone_trabalho"));
                    funcionarios.add(rs.getString("id_estabelecimento"));
                    funcionarios.add(rs.getString("plano"));
                    funcionarios.add(rs.getString("tipo"));
                    funcionarios.add(rs.getString("img_func"));
                    funcionarios.add(rs.getString("img_estab"));
                    funcionarios.add(rs.getString("genero"));
                    funcionarios.add(rs.getString("nome_empresa"));
                    funcionarios.add(rs.getString("cnpj"));
                    funcionarios.add(rs.getString("tipo_venda"));
                    funcionarios.add(rs.getString("num_telefone"));
                    funcionarios.add(rs.getString("endereco"));
                    funcionarios.add(rs.getString("cont_func"));
                    funcionarios.add(rs.getString("atividade_comercial"));
                    funcionarios.add(rs.getString("email"));
                    return funcionarios;
                }
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

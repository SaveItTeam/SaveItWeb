package br.com.example.saveit.saveitweb.model.cliente;

public class Cliente {
    //    Atributos
    private int id;
    private String nome;
    private String email;
    private String senha;
    private int tipo;
    private String tipo_venda;
    private int id_endereco;
    private String cnpj;


    //    Construtor
    public Cliente(int id, String nome, String email, String senha, int tipo, String tipo_venda, int id_endereco, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.tipo_venda = tipo_venda;
        this.id_endereco = id_endereco;
        this.cnpj = cnpj;
    }

    public Cliente() {}

    //    Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipo() {
        return tipo;
    }

    public String getTipo_venda() {
        return tipo_venda;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    //    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setTipo_venda(String tipo_venda) {
        this.tipo_venda = tipo_venda;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }



    //    toString

    @Override
    public String toString() {
        return String.format("""
                {
                    "id": %d,
                    "nome": "%s",
                    "email": "%s",
                    "senha": "%s",
                    "tipo": %d,
                    "tipo_venda": "%s",
                    "id_endereco": %d,
                    "cnpj": "%s",
                }"""
                , id, nome, email, senha, tipo, tipo_venda, id_endereco, cnpj);
    }
}

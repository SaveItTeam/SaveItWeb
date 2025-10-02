package br.com.example.saveit.saveitweb.model.admin;

public class Admin {
    public int id;
    public String senha;
    public String nome_cliente;
    public String qual_empresa;

    public Admin(int id, String senha, String nome_cliente, String qual_empresa) {
        this.id = id;
        this.senha = senha;
        this.nome_cliente = nome_cliente;
        this.qual_empresa = qual_empresa;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getQual_empresa() {
        return qual_empresa;
    }

    public void setQual_empresa(String qual_empresa) {
        this.qual_empresa = qual_empresa;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", senha='" + senha + '\'' +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", qual_empresa='" + qual_empresa + '\'' +
                '}';
    }
}

package br.com.example.saveit.saveitweb.model.admin;

public class Admin {
    public int id;
    public String nome_cliente;
    public String qual_empresa;
    public String senha_entrada;
    public String cargo;

    public Admin(int id,String nome_cliente, String qual_empresa, String  senha_entrada, String cargo) {
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.qual_empresa = qual_empresa;
        this.senha_entrada = senha_entrada;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getSenha_entrada() {
        return senha_entrada;
    }

    public void setSenha_entrada(String senha) {
        this.senha_entrada = senha;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return String.format("""
                \n
                id: %d
                nome cliente: %s
                qual empresa: %s
                senha entrada: %s
                cargo: %s
                \n"""
                , id, nome_cliente, qual_empresa, senha_entrada, cargo);
    }
}

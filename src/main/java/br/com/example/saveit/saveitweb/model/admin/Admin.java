package br.com.example.saveit.saveitweb.model.admin;

public class Admin {
//    Atributos
    public int id;
    public String nome_admin;
    public String email;
    public String senha;

//    Construtor
    public Admin(int id, String nome_admin, String emial, String senha) {
        this.id = id;
        this.nome_admin = nome_admin;
        this.email = emial;
        this.senha = senha;
    }

//    Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_admin() {
        return nome_admin;
    }

    public void setNome_admin(String nome_admin) {
        this.nome_admin = nome_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    toString
    public String toString() {
        return String.format("""
                \n
                id: %d
                Nome Admin: %s
                Email: %s
                Senha: %s
                \n"""
                , id, nome_admin, email, senha);
    }
}

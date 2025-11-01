package br.com.example.saveit.saveitweb.model.admin;

public class Admin {
//    Atributos
    private int id;
    private String nome_admin;
    private String email;
    private String senha;

//    Construtor
    public Admin(int id, String nome_admin, String email, String senha) {
        this.id = id;
        this.nome_admin = nome_admin;
        this.email = email;
        this.senha = senha;
    }

    public Admin() {}

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
                    {
                        "id": %d,
                        "nome_admin": "%s",
                        "email": "%s",
                        "senha": "%s"
                    }"""
                , id, nome_admin, email, senha);
    }
}

package br.com.example.saveit.saveitweb.model.funcionario;

import java.sql.Date;

public class Funcionario {
//    Atributos
    public int id;
    public String nome;
    public String cpf;
    public String rg;
    public char genero;
    public Date dt_nascimento;
    public String email;
    public String senha;
    public String cargo;
    public Date dt_contratacao;
    public String telefone_pessoal;
    public String telefone_trabalho;
    public String experiencia;
    public int id_empresa;
    public int id_industria;
    public boolean is_admin;


//    Construtor
    public Funcionario(int id, String nome, String cpf, String rg, char genero, Date dt_nascimento, String email, String senha, String cargo, Date dt_contratacao, String telefone_pessoal, String telefone_trabalho, String experiencia, int id_empresa, int id_industria, boolean is_admin) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.dt_nascimento = dt_nascimento;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.dt_contratacao = dt_contratacao;
        this.telefone_pessoal = telefone_pessoal;
        this.telefone_trabalho = telefone_trabalho;
        this.experiencia = experiencia;
        this.id_empresa = id_empresa;
        this.id_industria = id_industria;
        this.is_admin = is_admin;
    }



//    Getters e Setters
    public int getId() {return this.id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDt_contratacao() {
        return dt_contratacao;
    }

    public void setDt_contratacao(Date dt_contratacao) {
        this.dt_contratacao = dt_contratacao;
    }

    public String getTelefone_pessoal() {
        return telefone_pessoal;
    }

    public void setTelefone_pessoal(String telefone_pessoal) {
        this.telefone_pessoal = telefone_pessoal;
    }

    public String getTelefone_trabalho() {
        return telefone_trabalho;
    }

    public void setTelefone_trabalho(String telefone_trabalho) {
        this.telefone_trabalho = telefone_trabalho;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_industria() {
        return id_industria;
    }

    public void setId_industria(int id_industria) {
        this.id_industria = id_industria;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }


//    toString
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", genero=" + genero +
                ", dt_nascimento=" + dt_nascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dt_contratacao=" + dt_contratacao +
                ", telefone_pessoal='" + telefone_pessoal + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", id_empresa=" + id_empresa +
                ", id_industria=" + id_industria +
                ", id_admin=" + is_admin +
                '}';
    }
}



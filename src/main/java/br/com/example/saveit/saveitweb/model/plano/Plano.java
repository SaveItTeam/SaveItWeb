package br.com.example.saveit.saveitweb.model.plano;

import java.util.Locale;

public class Plano {
//    Atributos
    private int id;
    private double preco;
    private String descricao;

    public Plano(int id, double preco, String descricao) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Plano() {}


    //    Getters
    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


//    toString
    public String toString(){
        return String.format(Locale.US, """
                {
                    "id": %d,
                    "preco": %f,
                    "descricao": "%s"
                }"""
                , this.id, this.preco, this.descricao);
    }
}

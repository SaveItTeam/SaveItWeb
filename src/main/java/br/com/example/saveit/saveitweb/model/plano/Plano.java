package br.com.example.saveit.saveitweb.model.plano;

public class Plano {
//    Atributos
    private int id;
    private double preco;
    private String descricao;
    private int id_pagamento;

    public Plano(int id, double preco, String descricao, int id_pagamento) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.id_pagamento = id_pagamento;
    }


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

    public int getId_pagamento() {
        return id_pagamento;
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

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }


//    toString
    public String toString(){
        return String.format("|ID: %-5s  |Preço: %-5s  |Descrição: %-30s  |ID_Pagamento: %-5s", this.id, this.preco, this.descricao, this.id_pagamento);
    }
}

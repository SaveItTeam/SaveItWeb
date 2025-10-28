package br.com.example.saveit.saveitweb.model.industria;

public class Industria {

//    Atributos
    private int id;
    private String vende;
    private int id_plano;
    private String cod_industria;
    private int id_pagamento;
    private int id_cliente;

//    Construtor
    public Industria(int id, String vende, int id_plano, String cod_industria, int id_pagamento, int id_cliente) {
        this.id = id;
        this.vende = vende;
        this.id_plano = id_plano;
        this.cod_industria = cod_industria;
        this.id_pagamento = id_pagamento;
        this.id_cliente = id_cliente;
    }


    //    Getters
    public int getId() {
        return id;
    }

    public String getVende() {
        return vende;
    }

    public int getId_plano() {
        return id_plano;
    }

    public String getCod_industria() {
        return cod_industria;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    //    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setVende(String vende) {
        this.vende = vende;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public void setCod_industria(String cod_industria) {
        this.cod_industria = cod_industria;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    //    toString
    public String toString() {
        return "id=" + id +
                "\nvende='" + vende +
                "\nid_plano=" + id_plano +
                "\ncod_industria='" + cod_industria +
                "\nid_pagamento=" + id_pagamento +
                "\nid_cliente=" + id_cliente;
    }
}

package br.com.example.saveit.saveitweb.model.industria;

public class Industria {

//    Atributos
    private int id;
    private int id_plano;
    private String vende;
    private int id_pagamento;

    public Industria(int id_plano, String vende, int id_pagamento) {
        this.id_plano = id_plano;
        this.vende = vende;
        this.id_pagamento = id_pagamento;
    }

    public Industria() {

    }

    //    Getters
    public int getId() {
        return id;
    }

    public int getId_plano() {
        return id_plano;
    }

    public String getVende() {
        return vende;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public void setVende(String vende) {
        this.vende = vende;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }


//    toString
    public String toString(){
        return String.format("|ID: %-5s  |ID_Plano: %-5s  |Vende: %-15s  |ID_Pagamento: %-5s", this.id, this.id_plano, this.vende, this.id_pagamento);
    }
}

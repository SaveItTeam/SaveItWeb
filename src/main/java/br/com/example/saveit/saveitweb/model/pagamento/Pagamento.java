package br.com.example.saveit.saveitweb.model.pagamento;

public class Pagamento {
//    Atributos
    private int id;
    private String status;
    private String dt_criacao;
    private String dt_validade;
    private String forma_pagamento;

    public Pagamento(int id, String status, String dt_criacao, String dt_validade, String forma_pagamento) {
        this.id = id;
        this.status = status;
        this.dt_criacao = dt_criacao;
        this.dt_validade = dt_validade;
        this.forma_pagamento = forma_pagamento;
    }

    public Pagamento(int i, String ativo, String date, String s) {}

    //    Getters
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public String getDt_validade() {
        return dt_validade;
    }

    public String getForma_pagamento() {return forma_pagamento;}

    //    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public void setDt_validade(String dt_validade) {
        this.dt_validade = dt_validade;
    }

    public void setForma_pagamento(String forma_pagamento) {this.forma_pagamento = forma_pagamento;}

    //    toString
    public String toString(){
        return String.format("""
                {
                    "id": %d,
                    "status": "%s",
                    "dt_criacao": "%s",
                    "dt_validade": "%s",
                    "forma_pagamento": "%s"
                }"""
                , this.id, this.status, this.dt_criacao, this.dt_validade, this.forma_pagamento);
    }
}

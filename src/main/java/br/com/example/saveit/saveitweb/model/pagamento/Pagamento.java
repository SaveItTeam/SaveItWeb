package br.com.example.saveit.saveitweb.model.pagamento;

public class Pagamento {
//    Atributos
    private int id;
    private String status;
    private String dt_criacao;
    private String dt_validade;

    public Pagamento(int id, String status, String dt_criacao, String dt_validade) {
        this.id = id;
        this.status = status;
        this.dt_criacao = dt_criacao;
        this.dt_validade = dt_validade;
    }


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


    //    toString
    public String toString(){
        return String.format("|ID: %-5s  |Status: %-10s  |Data_Criação: %-15s  |Data_Validade: %-5s", this.id, this.status, this.dt_criacao, this.dt_validade);
    }
}

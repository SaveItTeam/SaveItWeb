package br.com.example.saveit.saveitweb.model.empresa;

public class Empresa {
//    Atributos
    private int id;
    private int id_cliente;
    private String procura;

    public Empresa(int id_cliente, String procura) {
        this.id_cliente = id_cliente;
        this.procura = procura;
    }

    public Empresa() {

    }

    //    Getters
    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getProcura() {
        return procura;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setProcura(String procura) {
        this.procura = procura;
    }

//    toString
    public String toString(){
        return String.format("|ID: %-5s  |ID_Funcionário: %-5s  |ID_Cliente: %-5s  |Procura: %-15s  |ID_Plano: %-5s", this.id, this.id_cliente, this.procura);
    }
}

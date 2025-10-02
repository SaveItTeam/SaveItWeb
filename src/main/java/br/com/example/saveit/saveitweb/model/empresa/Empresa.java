package br.com.example.saveit.saveitweb.model.empresa;

public class Empresa {
//    Atributos
    private int id;
    private int id_funcionario;
    private int id_cliente;
    private String procura;
    private int id_plano;

    public Empresa(int id_cliente, String procura, int id_plano) {
        this.id_cliente = id_cliente;
        this.procura = procura;
        this.id_plano = id_plano;
    }

    public Empresa() {

    }

    //    Getters
    public int getId() {
        return id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getProcura() {
        return procura;
    }

    public int getId_plano() {
        return id_plano;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setProcura(String procura) {
        this.procura = procura;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

//    toString
    public String toString(){
        return String.format("|ID: %-5s  |ID_Funcionário: %-5s  |ID_Cliente: %-5s  |Procura: %-15s  |ID_Plano: %-5s", this.id, this.id_funcionario, this.id_cliente, this.procura, this.id_plano);
    }
}

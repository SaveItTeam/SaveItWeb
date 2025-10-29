package br.com.example.saveit.saveitweb.model.telefone;

public class Telefone {
//    Atributos
    private int id;
    private String num_telefone;
    private int id_cliente;


//    Construtor
    public Telefone(int id, String num_telefone, int id_cliente) {
        this.id = id;
        this.num_telefone = num_telefone;
        this.id_cliente = id_cliente;
    }


//    Getters e Setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNum_telefone() {return num_telefone;}

    public void setNum_telefone(String num_telefone) {this.num_telefone = num_telefone;}

    public int getId_cliente() {return id_cliente;}

    public void setId_cliente(int id_cliente) {this.id_cliente = id_cliente;}


//    toString

    @Override
    public String toString() {
        return "id=" + id +
                "\nnum_telefone=" + num_telefone +
                "\nid_cliente=" + id_cliente;
    }
}

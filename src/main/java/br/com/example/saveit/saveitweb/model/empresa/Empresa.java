package br.com.example.saveit.saveitweb.model.empresa;

public class Empresa {
//    Atributos
    private int id;
    private String procura;
    private String cod_empresa;
    private int id_cliente;

    public Empresa(int id, String procura, String cod_empresa, int id_cliente) {
        this.id = id;
        this.procura = procura;
        this.cod_empresa = cod_empresa;
        this.id_cliente = id_cliente;
    }

    public Empresa() {}


    //    Getters
    public int getId() {
        return id;
    }

    public String getProcura() {
        return procura;
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    //    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProcura(String procura) {
        this.procura = procura;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


//    toString

    @Override
    public String toString() {
        return String.format("""
                {
                    "id": %d,
                    "procura": "%s",
                    "cod_empresa": "%s",
                    "id_cliente": %d
                }"""
                , id, procura, cod_empresa, id_cliente);
    }
}

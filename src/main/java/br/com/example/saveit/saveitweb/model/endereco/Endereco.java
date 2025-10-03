package br.com.example.saveit.saveitweb.model.endereco;

public class Endereco {

//    Atributos
    private int id;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;

    public Endereco(String cep, String rua, String bairro, String cidade, String estado, String pais, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
    }

    public Endereco() {

    }


    //    Getters
    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getComplemento() {
        return complemento;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String toString(){
        String retorno = String.format("|ID: %-5s  |CEP: %-8s  |Rua: %-30s  |Bairro: %-30s  |Cidade: %-30s  |Estado: %-3s  |País: %-15s  |Complemento: %-30s", this.id, this.cep, this.rua, this.bairro, this.cidade, this.estado, this.pais, this.complemento);
        return retorno;
    }
}

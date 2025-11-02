package br.com.example.saveit.saveitweb.model.endereco;

public class Endereco {

//    Atributos
    private int id;
    private String cep;
    private String cep_rua;
    private String cep_bairro;
    private String cep_cidade;
    private String cep_estado;
    private String cep_pais;
    private String cep_complemento;
    private int cep_rua_num;

    public Endereco(int id, String cep, String rua, String bairro, String cidade, String estado, String pais, String complemento, int cep_rua_num) {
        this.id =id;
        this.cep = cep;
        this.cep_rua = rua;
        this.cep_bairro = bairro;
        this.cep_cidade = cidade;
        this.cep_estado = estado;
        this.cep_pais = pais;
        this.cep_complemento = complemento;
        this.cep_rua_num = cep_rua_num;
    }

    public Endereco() {}

    //    Getters
    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getCep_rua() {
        return cep_rua;
    }

    public String getCep_bairro() {
        return cep_bairro;
    }

    public String getCep_cidade() {
        return cep_cidade;
    }

    public String getCep_estado() {
        return cep_estado;
    }

    public String getCep_pais() {
        return cep_pais;
    }

    public String getCep_complemento() {
        return cep_complemento;
    }


//    Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCep_rua(String cep_rua) {
        this.cep_rua = cep_rua;
    }

    public void setCep_bairro(String cep_bairro) {
        this.cep_bairro = cep_bairro;
    }

    public void setCep_cidade(String cep_cidade) {
        this.cep_cidade = cep_cidade;
    }

    public void setCep_estado(String estado) {
        this.cep_estado = estado;
    }

    public void setCep_pais(String cep_pais) {
        this.cep_pais = cep_pais;
    }

    public void setCep_complemento(String cep_complemento) {
        this.cep_complemento = cep_complemento;
    }

    public String toString(){
        return String.format("""
                {
                    "id": %d,
                    "cep": "%s",
                    "cep_rua": "%s",
                    "cep_bairro": "%s",
                    "cep_cidade": "%s",
                    "cep_estado": "%s",
                    "cep_pais": "%s",
                    "cep_complemento": "%s",
                    "cep_rua_numero": %d
                }"""
                , id, cep, cep_rua, cep_bairro, cep_cidade, cep_estado, cep_pais, cep_complemento, cep_rua_num);
    }
}

package br.com.example.saveit.saveitweb.model.imagem;

public class Imagem {
    //    Atributos
    private int id;
    private String url;
    private int id_funcionario;


    //    Construtor
    public Imagem(int id, String url, int id_funcionario) {
        this.id = id;
        this.url = url;
        this.id_funcionario = id_funcionario;
    }

    public Imagem() {}

    //    Getters e Setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    public int getId_funcionario() {return id_funcionario;}

    public void setId_funcionario(int id_funcionario) {this.id_funcionario = id_funcionario;}


//    toString

    @Override
    public String toString() {
        return String.format("""
                {
                    "id": %d,
                    "url": "%s",
                    "id_funcionario": %d
                }"""
                , id, url, id_funcionario);
    }
}

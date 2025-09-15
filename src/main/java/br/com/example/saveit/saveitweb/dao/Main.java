package br.com.example.saveit.saveitweb.dao;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        if (conexao.conectar() == null) {
            System.out.println("Falha ao conectar ao banco de dados.");
        } else {
            System.out.println("Conexão bem-sucedida ao banco de dados.");
        }
    }
}

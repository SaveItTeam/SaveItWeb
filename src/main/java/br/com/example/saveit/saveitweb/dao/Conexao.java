package br.com.example.saveit.saveitweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String URL = dotenv.get("DB_HOST");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    private Conexao() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados" + ex);
        }
        return null;
    }
}

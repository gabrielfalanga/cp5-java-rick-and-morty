package br.com.fiap.rickandmorty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection obterConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "rm557462", "080606");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
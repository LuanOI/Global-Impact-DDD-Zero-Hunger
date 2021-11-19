package br.com.fiap.zero_hunger.dao;

import java.sql.*;

/**
 * Fábrica de conexão com o banco de dados.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class ConnectionFactory {

    /**
     * Método que retorna uma conexão com o BD
     *
     * @return Connection - conexão com o BD
     * @throws SQLException - caso não for possível estabelecer uma conexão
     */
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "rm88110";
        String password = "120203";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}

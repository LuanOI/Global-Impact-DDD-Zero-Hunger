package br.com.fiap.zero_hunger.dao;

import java.sql.*;

/**
 * Classe LoginDAO, responsável pelo login de um Usuário na Base de Dados.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class LoginDAO {

    Connection con = ConnectionFactory.getConnection();

    public LoginDAO() throws SQLException {
    }

    /**
     * Método que realiza o login de um usuário cadastrado na app
     *
     * @param email - email inserido pelo usuário na interface gráfica
     * @param senha -  senha inserida pelo usuário na interface gráfica
     * @return - retorna o id do usuário.
     * @throws SQLException
     */
    public int login(String email, String senha) throws SQLException {
        String sql = "SELECT id FROM usuario WHERE email LIKE ? AND senha LIKE ?";
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, "%" + email + "%");
        prepareStatement.setString(2, "%" + senha + "%");
        ResultSet resultSet = prepareStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }
}

package br.com.fiap.zero_hunger.dao;

import java.sql.*;

import br.com.fiap.zero_hunger.model.Usuario;

/**
 * Classe Cadastro DAO, responsável pelo cadastro de um Usuário na Base de Dados.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class CadastroDAO {

    Connection con = ConnectionFactory.getConnection();

    public CadastroDAO() throws SQLException {
    }

    /**
     * Método que verifica se o usuário já está cadastrado na base de dados.
     *
     * @param email - email do usuário será verificado
     * @return - retorna true caso esteja cadastrado e false caso não esteja
     * @throws SQLException
     */
    public boolean isCadastrado(String email) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email LIKE ?";
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        prepareStatement.setString(1, "%" + email + "%");
        ResultSet resultSet = prepareStatement.executeQuery();
        return resultSet.next();
    }

    /**
     * Método que insere um usuário no banco de dados.
     *
     * @param usuario - objeto a ser inserido na base de dados.
     * @return - retorna um numero inteiro 0 ou 1, caso haja ou não sucesso em realizar uma inserção no bando de dados.
     * @throws SQLException
     */
    public int cadastrar(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario VALUES (sq_usuario.NEXTVAL, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getEmail());
        ps.setString(2, usuario.getSenha());

        return ps.executeUpdate();
    }
}

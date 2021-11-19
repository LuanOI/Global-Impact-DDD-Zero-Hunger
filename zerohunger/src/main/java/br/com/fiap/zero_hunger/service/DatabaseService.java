package br.com.fiap.zero_hunger.service;

import java.sql.*;

import br.com.fiap.zero_hunger.dao.CadastroDAO;
import br.com.fiap.zero_hunger.dao.LoginDAO;
import br.com.fiap.zero_hunger.model.Usuario;

public class DatabaseService {

    private CadastroDAO cadastroDAO;
    private LoginDAO loginDAO;

    /**
     *  Método responsável pelo cadastro de um usuário.
     *
     * @param usuario - objeto a ser cadastrado, um usuário da aplicação.
     * @throws SQLException
     *
     */
    public boolean cadastrar(Usuario usuario) throws SQLException {
        cadastroDAO = new CadastroDAO();
        if (!cadastroDAO.isCadastrado(usuario.getEmail())) {
            cadastroDAO.cadastrar(usuario);
            return true;
        }else return false;

    }

    /**
     * Método responsável por realizar o login do usuário - fazendo uma consulta do email e senha do usuário na base de
     * dados.
     *
     * @param usuario - objeto da classe Usuário
     * @return - retorna um int - método da classe Dao para login do usuário
     * @throws SQLException
     */
    public int login(Usuario usuario) throws SQLException {
        loginDAO = new LoginDAO();
        return loginDAO.login(usuario.getEmail(), usuario.getSenha());
    }
}

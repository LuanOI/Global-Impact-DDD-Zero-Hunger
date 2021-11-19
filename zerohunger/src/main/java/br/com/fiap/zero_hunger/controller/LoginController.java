package br.com.fiap.zero_hunger.controller;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import br.com.fiap.zero_hunger.model.Usuario;
import br.com.fiap.zero_hunger.service.DatabaseService;
import br.com.fiap.zero_hunger.view.PainelLogin;

/**
 * Classe controller da interface gráfica de Login.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class LoginController implements ActionListener {

    private DatabaseService service = new DatabaseService();
    private PainelLogin painelLogin;

    /**
     * Método construtor para acesso à classe PainelLogin.
     *
     * @param painelLoginLogin - objeto da classe PainelLogin.
     */
    public LoginController(PainelLogin painelLogin) {
        this.painelLogin = painelLogin;
    }

    /**
     * Método que implementa as acoes da interface PainelLogin.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Usuario usuario = painelLogin.getUsuario();
            int idUsuarioLogado = service.login(usuario);
            usuario.setIdUsuarioLogado(idUsuarioLogado);

            if (idUsuarioLogado != 0) {
                painelLogin.getApp().isLogado(true);
                painelLogin.getApp().mostrarMensagem("Login realizado com sucesso", "Login", JOptionPane.INFORMATION_MESSAGE);
                painelLogin.getApp().getAbas().setSelectedIndex(2);
                painelLogin.getApp().setIdUsuarioLogado(idUsuarioLogado);
            } else painelLogin.getApp().mostrarMensagem("Usuário ou senha incorretos!", "Falha Login", JOptionPane.ERROR_MESSAGE);

            painelLogin.clearCampos();


        } catch (SQLException erro) {
            painelLogin.getApp().mostrarMensagem("Usuário não cadastrado ", "Erro", JOptionPane.ERROR_MESSAGE);
            erro.printStackTrace();
            painelLogin.clearCampos();
            painelLogin.getApp().getAbas().setSelectedIndex(0);
        }
    }
}

package br.com.fiap.zero_hunger.view;

import javax.swing.*;

import br.com.fiap.zero_hunger.controller.LoginController;
import br.com.fiap.zero_hunger.model.Usuario;

/**
 * Classe responsável pela criação da Aba Login na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class PainelLogin extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel labelEmail = new JLabel("Email");
    private JTextField txtEmail = new JTextField();
    private JLabel labelSenha = new JLabel("Senha");
    private JTextField txtSenha = new JTextField();
    private Botao btnLogin = new Botao("Login", new LoginController(this));

    private App app;

    /**
     * Método que cria um painel de login na interface gráfica.
     *
     * @param app - recebe um objeto do tipo app.
     */
    public PainelLogin(App app){
        this.app = app;

        setLayout(null);

        labelEmail.setBounds(338, 107, 61, 16);
        add(labelEmail);

        txtEmail.setBounds(333, 125, 157, 26);
        add(txtEmail);
        txtEmail.setColumns(10);

        labelSenha.setBounds(333, 182, 61, 16);
        add(labelSenha);

        txtSenha.setBounds(333, 199, 157, 26);
        add(txtSenha);
        txtSenha.setColumns(10);

        btnLogin.setBounds(350, 255, 127, 29);
        add(btnLogin);
    }

    /**
     * Método que retorna um objeto usário, a partir das informaçoes inserida pelo usuário na interface gráfica.
     * @return
     */
    public Usuario getUsuario() {
        return new Usuario(
                txtEmail.getText(),
                txtSenha.getText());
    }

    /**
     * Método que apaga os campos da interface gráfica.
     */
    public void clearCampos(){
        txtEmail.setText("");
        txtSenha.setText("");
    }

    /**
     * Método que retorna um app.
     *
     * @return - app.
     */
    public App getApp(){
        return app;
    }
}

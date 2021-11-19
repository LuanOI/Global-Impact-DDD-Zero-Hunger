package br.com.fiap.zero_hunger.view;

import java.text.*;

import javax.swing.*;

import br.com.fiap.zero_hunger.controller.CadastrarController;
import br.com.fiap.zero_hunger.model.Usuario;

/**
 * Classe responsável pela criação do Painel Cadastrar na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class PainelCadastrar extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel labelEmail = new JLabel("Email");
    private JTextField txtEmail = new JTextField();
    private JLabel labelSenha = new JLabel("Senha");
    private JTextField txtSenha = new JTextField();
    private Botao btnCadastrar = new Botao("Cadastrar", new CadastrarController(this));

    private App app;

    /**
     * Método que cria uma painel de cadastro na interface gráfica.
     *
     * @param app - recebe um objeto do tipo app.
     */
    public PainelCadastrar(App app){
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

        btnCadastrar.setBounds(350, 255, 127, 29);
        add(btnCadastrar);
    }

    /**
     * Método que retorna um objeto Usuário, a partir das informaçoes inserida pelo usuário na interface gráfica.
     *
     * @return - objeto usuário.
     * @throws ParseException
     */
    public Usuario getUsuario() throws ParseException {

        return new Usuario(
                txtEmail.getText(),
                txtSenha.getText());
    }

    /**
     * Método que apaga os campos da interface gráfica.
     */
    public void clearCamposCadastrar() {
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
package br.com.fiap.zero_hunger.controller;

import java.awt.event.*;
import java.sql.*;
import java.text.*;

import javax.swing.*;

import br.com.fiap.zero_hunger.model.Usuario;
import br.com.fiap.zero_hunger.service.DatabaseService;
import br.com.fiap.zero_hunger.view.PainelCadastrar;

/**
 * Classe Controller, que transforma eventos gerados pela interface em ações de negócio, alterando o modelo.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class CadastrarController implements ActionListener {

    private DatabaseService service = new DatabaseService();
    private PainelCadastrar painelCadastrar;

    /**
     * Método construtor para acessar a classe PainelCadastrar
     *
     * @param painelCadastrar - classe interface gráfica para cadastrar um usuário
     */
    public CadastrarController(PainelCadastrar painelCadastrar) {
        this.painelCadastrar = painelCadastrar;
    }

    /**
     * Método que envia à classe DatabaseService um objeto do tipo Usuário desde a interface gráfica de cadastro
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Usuario usuario = painelCadastrar.getUsuario();
            if (service.cadastrar(usuario)){
                painelCadastrar.getApp().mostrarMensagem("Usuário cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                painelCadastrar.getApp().getAbas().setSelectedIndex(1);
            }else painelCadastrar.getApp().mostrarMensagem("Usuário já cadastrado, contatar RH", "Erro", JOptionPane.ERROR_MESSAGE);

            painelCadastrar.clearCamposCadastrar();
        } catch (SQLException | ParseException e1) {
            painelCadastrar.getApp().mostrarMensagem("Erro de SQL: " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
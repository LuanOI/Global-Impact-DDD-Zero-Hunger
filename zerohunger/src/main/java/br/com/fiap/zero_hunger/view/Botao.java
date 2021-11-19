package br.com.fiap.zero_hunger.view;

import java.awt.event.*;

import javax.swing.*;

/**
 *  Classe responsável pela criação dos botões na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class Botao extends JButton {

    private static final long serialVersionUID = 1L;

    /**
     * Método que cria um objeto botão.
     * @param text - texto do botão
     * @param listener - ação para o botão.
     */
    public Botao(String text, ActionListener listener) {
        super(text);
        addActionListener(listener);
    }
}

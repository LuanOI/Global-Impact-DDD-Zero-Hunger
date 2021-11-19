package br.com.fiap.zero_hunger.view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import br.com.fiap.zero_hunger.dao.Criterio;

/**
 * Classe responsável pela criação do menu de botoes na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class Menu extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JButton btnTodos = new JButton("Todos");
    private JButton btnPreco = new JButton("Menor Preço");
    private JButton btnDesconto = new JButton("Maior Desconto");

    private Tabela tabela;


    /**
     * Método que cria os botoes na interface gráfica.
     *
     * @param tabela - recebe um objeto do tipo tabela.
     */
    public Menu(Tabela tabela) {
        this.tabela = tabela;
        setPreferredSize(new Dimension(150, 600));

        add(btnTodos);
        add(btnPreco);
        add(btnDesconto);

        addListeners();
    }

    private void addListeners() {
        btnTodos.addActionListener(this);
        btnPreco.addActionListener(this);
        btnDesconto.addActionListener(this);
    }

    /**
     * Método que captura as acoes dos botoes
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnTodos) tabela.carregar(Criterio.TODOS);
            if (e.getSource() == btnPreco) tabela.carregar(Criterio.MENOR_PRECO);
            if (e.getSource() == btnDesconto) tabela.carregar(Criterio.MAIOR_DESCONTO);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar");
            ex.printStackTrace();
        }
    }
}

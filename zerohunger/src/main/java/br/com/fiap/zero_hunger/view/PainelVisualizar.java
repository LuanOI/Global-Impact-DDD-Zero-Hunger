package br.com.fiap.zero_hunger.view;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

/**
 * Classe responsável pela criação do painel de visualizar produto na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class PainelVisualizar extends JPanel {

    private static final long serialVersionUID = 1L;

    private Tabela tabela;
    private JPanel menu;

    /**
     * Método que cria uma painel de visualizar produtos na interface gráfica.
     */
    public PainelVisualizar() {
        try {
            tabela = new Tabela();
            menu = new Menu(tabela);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        add(menu, BorderLayout.WEST);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}

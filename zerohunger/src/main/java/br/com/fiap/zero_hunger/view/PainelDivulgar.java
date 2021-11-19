package br.com.fiap.zero_hunger.view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import br.com.fiap.zero_hunger.controller.ProdutoController;
import br.com.fiap.zero_hunger.dao.ProdutoDAO;
import br.com.fiap.zero_hunger.model.Produto;

/**
 * Classe responsável pela criação do painel de divulgar produto na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class PainelDivulgar extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtNome = new JTextField();
    private JTextField txtPreco = new JTextField();
    private JTextField txtDesconto = new JTextField();
    private JButton btnDivulgar = new JButton("Divulgar");

    /**
     * Método que cria uma painel de divulgar produtos na interface gráfica.
     */
    public PainelDivulgar() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome"));
        add(txtNome);

        add(new JLabel("Preço"));
        add(txtPreco);

        add(new JLabel("Desconto"));
        add(txtDesconto);

        add(new JLabel());
        add(btnDivulgar);

        btnDivulgar.addActionListener(this);
    }

    /**
     * Método que implementa as acoes da interface PainelDivulgar
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Produto produto = new Produto(
                txtNome.getText(),
                Double.parseDouble(txtPreco.getText()),
                Double.parseDouble(txtDesconto.getText())
            );

            ProdutoController controller = new ProdutoController(this);
            controller.inserir(produto);

        } catch (SQLException erro) {
            mostrarMensagem("Erro de SQL " + erro.getMessage());
            erro.printStackTrace();
        } catch (NumberFormatException erroDeConversao) {
            mostrarMensagem("Preço e Desconto devem ser números");
        }
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}

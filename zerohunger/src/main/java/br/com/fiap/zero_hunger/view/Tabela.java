package br.com.fiap.zero_hunger.view;

import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import br.com.fiap.zero_hunger.controller.ProdutoController;
import br.com.fiap.zero_hunger.dao.Criterio;
import br.com.fiap.zero_hunger.model.Produto;

/**
 *  Classe responsável pela criação da tabela na aba Resultado na interface grafica.
 *
 * @author Zero Hunger
 * @version 1.0
 *
 */
public class Tabela extends JTable {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel model = new DefaultTableModel();

    /**
     * Método responsável por criar a tabela.
     */
    public Tabela() throws SQLException {
        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("preco_real");
        model.addColumn("desconto_real");
        setModel(model);

        carregar(Criterio.TODOS);
    }

    /**
     * Método responsável por exibir os dados na tabela.
     * @param criterio - Define o criterio de busca
     */
    public void carregar(Criterio criterio) throws SQLException {
        model.setNumRows(0);
        ProdutoController controller = new ProdutoController();

        List<Produto> produtos = controller.buscar(criterio);

        produtos.forEach(produto -> model.addRow(produto.toArray()));
    }
}

package br.com.fiap.zero_hunger.controller;

import java.sql.*;
import java.util.*;

import br.com.fiap.zero_hunger.dao.Criterio;
import br.com.fiap.zero_hunger.dao.ProdutoDAO;
import br.com.fiap.zero_hunger.model.Produto;
import br.com.fiap.zero_hunger.view.PainelDivulgar;

/**
 * Classe controller da interface gráfica de Visualizar e Divulgar produto.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class ProdutoController {

    private PainelDivulgar view;

    public ProdutoController() {
    }

    public ProdutoController(PainelDivulgar view) {
        this.view = view;
    }

    /**
     * Método para inserir um produto na Base de Dados
     * @param produto
     * @throws SQLException
     */
    public void inserir(Produto produto) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.inserir(produto);
        view.mostrarMensagem("Produto divulgado com sucesso");
    }

    /**
     *
     * @param criterio - Define o criterio do botao escolhido
     * @return Lista de Produtos
     * @throws SQLException
     */
    public List<Produto> buscar(Criterio criterio) throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.buscar(criterio);
    }
}

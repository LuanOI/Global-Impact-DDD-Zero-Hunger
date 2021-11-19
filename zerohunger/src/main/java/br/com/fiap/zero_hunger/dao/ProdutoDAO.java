package br.com.fiap.zero_hunger.dao;

import java.sql.*;
import java.util.*;

import br.com.fiap.zero_hunger.model.Produto;

import javax.swing.*;

/**
 * Classe Produto DAO, responsável por Inserir e Buscar um produto na Base de Dados.
 *
 * @author Zero Hunger
 * @version 1.0
 */
public class ProdutoDAO {

    /**
     *
     * @param produto - produto a ser divulgado
     * @return quantidade de linhas inseridas no banco (0 ou 1)
     * @throws SQLException
     */
    public int inserir(Produto produto) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO produto VALUES (sq_produto.NEXTVAL, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, produto.getNome().toUpperCase());
        ps.setDouble(2, produto.getPreco());
        ps.setDouble(3, produto.getDesconto());

        return ps.executeUpdate();
    }

    /**
     *
     * @param criterio - Define o criterio de busca
     * @return Lista de produtos
     * @throws SQLException
     */
    public List<Produto> buscar(Criterio criterio) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement ps = con.prepareStatement(getSQL(criterio));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto(rs.getLong("id"),
                                          rs.getString("nome"),
                                          rs.getDouble("preco_real"),
                                          rs.getDouble("desconto_real"));

            produtos.add(produto);
        }

        return produtos;
    }

    /**
     *
     * @param criterio - Define o criterio do comando sql
     * @return Comando sql
     */
    private String getSQL(Criterio criterio) {
        if (criterio == Criterio.TODOS) return "SELECT * FROM produto ORDER BY id";
        if (criterio == Criterio.MENOR_PRECO) return "SELECT * FROM produto ORDER BY preco_real";
        if (criterio == Criterio.MAIOR_DESCONTO) return "SELECT * FROM produto ORDER BY desconto_real DESC";

        return null;
    }
}

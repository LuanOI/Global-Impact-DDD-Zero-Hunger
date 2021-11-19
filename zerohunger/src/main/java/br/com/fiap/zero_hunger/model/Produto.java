package br.com.fiap.zero_hunger.model;

public class Produto {

    private long id;
    private String nome;
    private double preco;
    private double desconto;

    public Produto(String nome, double preco, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public Produto(long id, String nome, double preco, double desconto) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String[] toArray() {
        String[] produto = {String.valueOf(this.id),
                            this.nome,
                            String.valueOf(this.preco),
                            String.valueOf(this.desconto)};

        return produto;
    }
}

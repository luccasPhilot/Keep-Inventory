package Model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int id;
    private int qtdProdutos;
    private List<Produto> produtos;

    // Construtor vazio
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Getter e Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para qtdProdutos
    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    // Métodos para adicionar e remover produtos
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        qtdProdutos = produtos.size();
    }

    public void excluirProduto(Produto produto) {
        produtos.remove(produto);
        qtdProdutos = produtos.size();
    }

    // Getter e Setter para lista de produtos
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        this.qtdProdutos = produtos.size();
    }
}

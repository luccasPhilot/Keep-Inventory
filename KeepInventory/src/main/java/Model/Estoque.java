/**
 *
 * @author zugaib
 */
package Model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private int qtdProdutos;
    private List<Produto> produtos;

    public void EstoqueBd() {
        //conexao BD
    }

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Getters e Setters
    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        qtdProdutos = produtos.size();
    }

    public void excluirProduto(Produto produto) {
        produtos.remove(produto);
        qtdProdutos = produtos.size();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        this.qtdProdutos = produtos.size();
    }
}

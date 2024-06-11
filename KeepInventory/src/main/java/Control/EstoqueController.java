/**
 *
 * @author zugaib
 */

package Control;

import Model.Estoque;
import Model.Produto;
import java.util.List;

public class EstoqueController {
    private Estoque estoque;

    public EstoqueController(Estoque estoque) {
        this.estoque = estoque;
    }

    public void adicionarProduto(Produto produto) {
        estoque.adicionarProduto(produto);
    }

    public void excluirProduto(Produto produto) {
        estoque.excluirProduto(produto);
    }

    public List<Produto> visualizarProdutos() {
        return estoque.getProdutos();
    }
}

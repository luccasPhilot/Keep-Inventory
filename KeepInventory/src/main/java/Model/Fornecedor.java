/**
 *
 * @author zugaib
 */

package Model;

public class Fornecedor {
    private int id;
    private String nome;
    private int idProduto;

    public Fornecedor(int id, String nome, int idProduto) {
        this.id = id;
        this.nome = nome;
        this.idProduto = idProduto;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}


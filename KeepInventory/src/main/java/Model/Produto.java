/**
 *
 * @author zugaib
 */
package Model;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    // Construtores, getters e setters
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /*private void calcularLucro() {
        // Implementar lógica para calcular lucro
    }*/
    
}

/**
 *
 * @author zugaib
 */
package Model;

public class Funcionario extends Usuario {

    private int idFunc;

    public Funcionario(String nome, String email, String senha, String cargo, int idFunc) {
        super(nome, email, senha, cargo);
        this.idFunc = idFunc;
    }
    
    
    /*public void visualizarEstoque() {
        // Implementar lógica de visualização do estoque
    }*/

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
}

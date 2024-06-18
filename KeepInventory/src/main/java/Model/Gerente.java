/**
 *
 * @author zugaib
 */
package Model;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome, String email, String senha, String cargo, int idFunc) {
        super(id, nome, email, senha, cargo, idFunc);
    }

    public Gerente(int id, int idFunc) {
        super(id, "", "", "", "", idFunc);
    }
    
    /*private void adicionarFuncionario() {
        // Implementar lógica para adicionar funcionário
    }

    private void excluirFuncionario() {
        // Implementar lógica para excluir funcionário
    }

    private void adicionarFornecedor() {
        // Implementar lógica para adicionar fornecedor
    }

    private void excluirFornecedor() {
        // Implementar lógica para excluir fornecedor
    }

    private void visualizarFornecedores() {
        // Implementar lógica para visualizar fornecedores
    } */
    
}
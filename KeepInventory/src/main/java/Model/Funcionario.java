package Model;

public class Funcionario extends Usuario {

    private int idFunc;

    public Funcionario(int id, String nome, String email, String senha, String cargo, int idFunc) {
        super(id, nome, email, senha, cargo);
        this.idFunc = idFunc;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}

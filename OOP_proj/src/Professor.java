
public class Professor extends Utilizador {

    private final static int PROF = 2;

    private Disciplina disciplina;
    private double salario;
    private long nib;
    private int numero;

    public Professor(String nome, String email, int numero, long nib, double salario, Disciplina disciplina) {
        super(nome, email, PROF);
        this.disciplina = disciplina;
        this.salario = salario;
        this.nib = nib;
        this.numero = numero;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getNib() {
        return nib;
    }

    public void setNib(long nib) {
        this.nib = nib;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Número: " + getId() + " Nome: " + getNome() + " Email: " + getEmail() + " Salario: " + getSalario() + " Disciplina: ID:" + disciplina.toString();
    }

}


import java.util.ArrayList;                                                                                                                                                              
import java.util.List;

public class Aluno extends Utilizador{  
    
    private final static int ALUNO = 1;
    
    private Curso curso;
    private List<Nota> notas;
    private int nivel;
    private double media;

    public Aluno(String nome, String email, Curso curso) {
        super(nome, email, ALUNO);
        this.curso = curso;
        notas = new ArrayList<>();
        nivel = 1;
    }
    
    
    public void aumentarNivel() {
        nivel++;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void addNota(Nota n) {
        notas.add(n);
    }
    
    public void removeNota(Nota n) {
        notas.remove(n);
    }

            public double getMedia() {
                return media;
            }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Número: " + getId() + "  Nome: " + getNome() + "  Email: " + getEmail() + "  Curso: " + curso.getNome() + "  Nivel: " + nivel;
    }
    
    public boolean alunoTemDisciplina(Disciplina disciplina) {
        return this.nivel == disciplina.getNivel();
    }
    
    public List<Disciplina> getDisciplinas() {
        List<Disciplina> lstDisc = new ArrayList<>();
        
        for(Disciplina d : this.curso.getDisciplinas()) {
            if(d.getNivel() == this.nivel) {
                lstDisc.add(d);
            }
        }
        return lstDisc;
    }
    
}

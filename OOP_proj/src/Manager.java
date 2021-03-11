
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Manager {

    private static Manager instance = null;
    private List<Utilizador> utilizadores;
    private List<Curso> cursos;

    public static synchronized Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    private Manager() {
        utilizadores = new ArrayList<>();
        cursos = new ArrayList<>();

    }

    public void populate() {

        ArrayList<Disciplina> lstDis1 = new ArrayList<>();
        ArrayList<Disciplina> lstDis2 = new ArrayList<>();;
        ArrayList<Disciplina> lstDis3 = new ArrayList<>();;

        //Design de cena:
        lstDis1.add(new Disciplina("Desenho I", 1));
        lstDis1.add(new Disciplina("Teoria e História do Design de Cena I", 1));
        lstDis1.add(new Disciplina("Teorias da Arte Teatral I", 1));
        lstDis1.add(new Disciplina("História da Arte I", 1));
        lstDis1.add(new Disciplina("Desenho II", 2));
        lstDis1.add(new Disciplina("Design de Cena I", 2));
        lstDis1.add(new Disciplina("Teoria e História do Design de Cena II", 2));
        lstDis1.add(new Disciplina("Iniciação à Produção de Cena", 2));
        lstDis1.add(new Disciplina("Design de Cena II", 3));
        lstDis1.add(new Disciplina("Problemas da Arte Contemporânea", 3));
        lstDis1.add(new Disciplina("Escrita de Relatório", 3));
        lstDis1.add(new Disciplina("Escritas Dramáticas da Contemporaneidade", 3));

        //Artes performativas
        lstDis2.add(new Disciplina("História do Teatro I", 1));
        lstDis2.add(new Disciplina("Dramaturgia do Texto e da Cena", 1));
        lstDis2.add(new Disciplina("Corpo e Movimento Cénico I", 1));
        lstDis2.add(new Disciplina("Voz I", 1));
        lstDis2.add(new Disciplina("Expressão e Criatividade", 2));
        lstDis2.add(new Disciplina("Improvisação", 2));
        lstDis2.add(new Disciplina("Técnicas de Palco", 2));
        lstDis2.add(new Disciplina("História do Teatro Português", 2));
        lstDis2.add(new Disciplina("Cenografia", 3));
        lstDis2.add(new Disciplina("Tendências Contemporâneas do Espetáculo", 3));
        lstDis2.add(new Disciplina("Estética Teatral", 3));
        lstDis2.add(new Disciplina("Projeto Experimental de Teatro", 3));

        //Produção
        lstDis3.add(new Disciplina("História da Arte I", 1));
        lstDis3.add(new Disciplina("História do Teatro I", 1));
        lstDis3.add(new Disciplina("Técnicas Teatrais I", 1));
        lstDis3.add(new Disciplina("Literatura Dramática I", 1));
        lstDis3.add(new Disciplina("Gestão Cultural I", 2));
        lstDis3.add(new Disciplina("Comunicação e Marketing I", 2));
        lstDis3.add(new Disciplina("Prática de Produção I", 2));
        lstDis3.add(new Disciplina("História da Arte II", 2));
        lstDis3.add(new Disciplina("Prática de Produção II", 3));
        lstDis3.add(new Disciplina("Problemas da Arte Contemporânea", 3));
        lstDis3.add(new Disciplina("Escritas Dramáticas da Contemporaneidade", 3));
        lstDis3.add(new Disciplina("Seminário de produção", 3));

        addCurso(new Curso("Design de cena", lstDis1));
        addCurso(new Curso("Especialização em Artes Performativas", lstDis2));
        addCurso(new Curso("Especialização em produção", lstDis3));
    }

    public void addUtilizador(Utilizador u) {
        utilizadores.add(u);
    }

    public void removeUtilizador(Utilizador u) {
        utilizadores.remove(u);
    }

    public void addCurso(Curso c) {
        cursos.add(c);
    }

    public boolean hasCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.equals(curso)) {
                return true;
            }
        }
        return false;
    }

    public void removeCurso(Curso c) {
        cursos.remove(c);
    }

    public List<Disciplina> getDisciplinasPorCurso(int id) {
        Curso c = getCursoByID(id);
        if (c == null) {
            return null;
        }
        return c.getDisciplinas();

    }

    public List<Disciplina> getDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        for (Curso c : cursos) {
            for (Disciplina d : c.getDisciplinas()) {
                disciplinas.add(d);
            }
        }

        return disciplinas;
    }

    public Disciplina getDisciplinaPorId(int id) {
        for (Disciplina d : getDisciplinas()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;

    }

    //....
    public Utilizador getUtilizador(int id) {
        for (Utilizador u : utilizadores) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public Aluno getAluno(int id) {
        Utilizador u = getUtilizador(id);
        if (u instanceof Aluno) {
            return (Aluno) u;
        }
        return null;
    }

    public boolean editarAluno(Aluno a, int numero) {
        Aluno alunomod = getAluno(numero);
        if (alunomod == null) {
            return false;
        }
        alunomod.setNome(a.getNome());
        alunomod.setEmail(a.getEmail());
        alunomod.setCurso(a.getCurso());
        alunomod.setNivel(a.getNivel());

        return true;
    }

    public boolean editarCurso(Curso c, int numero) {
        Curso cursomod = getCursoByID(numero);
        if (cursomod == null) {
            return false;
        }
        cursomod.setNome(c.getNome());
        cursomod.setDisciplinas(c.getDisciplinas());

        return true;
    }

    public boolean apagarUtilizador(int id) {
        Utilizador u = getUtilizador(id);
        if (u == null) {
            return false;
        }
        utilizadores.remove(u);
        return true;
    }

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    //usado quando se carregar do file
    private void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    //usado quando se carregar do file
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getCursoByID(int id) {
        for (Curso c : cursos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Utilizador u : utilizadores) {
            if (u instanceof Aluno) {
                alunos.add((Aluno) u);
            }
        }
        return alunos;
    }

    public Professor getProfessor(int id) {
        Utilizador u = getUtilizador(id);
        if (u instanceof Professor) {
            return (Professor) u;
        }
        return null;
    }

    public List<Professor> getProfessor() {
        List<Professor> professores = new ArrayList<>();
        for (Utilizador u : utilizadores) {
            if (u instanceof Professor) {
                professores.add((Professor) u);
            }
        }
        return professores;
    }

    public boolean editarProfessor(Professor a, int numero) {
        Professor professormod = getProfessor(numero);
        if (professormod == null) {
            return false;
        }
        professormod.setNome(a.getNome());
        professormod.setEmail(a.getEmail());
        professormod.setNumero(a.getNumero());
        professormod.setNib(a.getNib());
        professormod.setSalario(a.getSalario());
        professormod.setDisciplina(a.getDisciplina());

        return true;
    }

    public void RegistarAlunoFile() {
        ArrayList<Aluno> alunos = new ArrayList<>();

        File f = new File("alunos.dat");
        try {
            FileOutputStream os = new FileOutputStream(f);
            ObjectOutputStream oOS = new ObjectOutputStream(os);
            oOS.writeObject(alunos);

            oOS.flush();
            oOS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na escrita do novo aluno no ficheiro .dat " + e.getMessage());
        }
    }

    public void LerAlunoFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("alunos.dat");
        try {
            FileInputStream is = new FileInputStream(f);
            ObjectInputStream oIS = new ObjectInputStream(is);

            oIS.readObject();

            oIS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na leitura do novo aluno no ficheiro .dat " + e.getMessage());
        }
    }

    public void RegistarProfFile() {
        ArrayList<Professor> prof = new ArrayList<>();

        File f = new File("prof.dat");
        try {
            FileOutputStream os = new FileOutputStream(f);
            ObjectOutputStream oOS = new ObjectOutputStream(os);
            oOS.writeObject(prof);

            oOS.flush();
            oOS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na escrita do novo professor no ficheiro .dat " + e.getMessage());
        }
    }

    public void LerProfFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("prof.dat");
        try {
            FileInputStream is = new FileInputStream(f);
            ObjectInputStream oIS = new ObjectInputStream(is);
            oIS.readObject();

            oIS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na leitura do novo professor no ficheiro .dat " + e.getMessage());
        }
    }

    public void RegistarCursoFile() {
        ArrayList<Curso> curso = new ArrayList<>();
        File f = new File("curso.dat");
        try {
            FileOutputStream os = new FileOutputStream(f);
            ObjectOutputStream oOS = new ObjectOutputStream(os);
            oOS.writeObject(curso);

            oOS.flush();
            oOS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na escrita do novo curso no ficheiro .dat " + e.getMessage());
        }
    }

    public void LerCursoFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("curso.dat");
        try {
            FileInputStream is = new FileInputStream(f);
            ObjectInputStream oIS = new ObjectInputStream(is);
            oIS.readObject();

            oIS.close();

        } catch (IOException e) {
            System.out.println("Aviso: Erro na leitura do novo aluno no ficheiro .dat " + e.getMessage());
        }
    }

}

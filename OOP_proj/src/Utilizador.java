
public abstract class Utilizador {
    

    private int id;
    private String nome;
    private String email;

    public Utilizador(String nome, String email, int tipo) {
        this.id = IDGenerator.generateId(tipo);
        this.nome = nome;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

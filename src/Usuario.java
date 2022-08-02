import java.util.UUID;

public class Usuario {

    private String id;
    private String nome;
    private String CPF;
    private String telefone;
    private String matricula;

    public Usuario () {
        this.id = UUID.randomUUID().toString();
    }

    public Usuario (String nome, String CPF, String telefone, String matricula) {
        this.id = UUID.randomUUID().toString();
        this.setNome(nome);
        this.setCPF(CPF);
        this.setTelefone(telefone);
        this.setMatricula(matricula);
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

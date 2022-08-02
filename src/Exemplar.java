import java.util.UUID;

public class Exemplar {

    private String livroId;
    private String codigo;
    private Boolean cativa;
    private Boolean emprestada;

    public Exemplar () {
    }

    public Exemplar (String codigo, Boolean cativa, Boolean emprestada) {
        this.setCodigo(codigo);
        this.setCativa(cativa);
        this.setEmprestada(emprestada);
    }


    public String getLivroId () {
        return this.livroId;
    }
    public void setLivroId (String livroId) {
        this.livroId = livroId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getCativa() {
        return cativa;
    }

    public void setCativa(Boolean cativa) {
        this.cativa = cativa;
    }

    public Boolean getEmprestada() {
        return emprestada;
    }

    public void setEmprestada(Boolean emprestada) {
        this.emprestada = emprestada;
    }

}

import java.util.UUID;

public class Livro {

    private String id;
    private String ISBN;
    private String titulo;
    private String autor;
    private String ano;
    private Integer edicao;
    private String editora;

    public Livro() {
        this.id = UUID.randomUUID().toString();
    }

    public Livro(String titulo, String autor, String ano, Integer edicao, String editora, String ISBN) {
        this.id = UUID.randomUUID().toString();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAno(ano);
        this.setEdicao(edicao);
        this.setEditora(editora);
        this.setISBN(ISBN);
    }

    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getEdicao() {
        return this.edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

import java.util.UUID;

public class Livro {


    private String id;
    private String titulo;
    private String autor;
    private String ano;
    private Integer edicao;
    private String editora;
    private String ISBN;

    public Livro (){
        this.id = UUID.randomUUID().toString();
    }

    public Livro (String titulo, String autor, String ano, Integer edicao, String editora, String ISBN){
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
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

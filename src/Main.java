public class Main {

    public static void main(String[] args) {

        Livro livro = new Livro(
                "Código Limpo",
                "Robert Cecil Martin",
                "2009",
                1,
                "Alta Books",
                "8576082675"
        );

        Exemplar exemplar = new Exemplar(
                "1",
                false,
                false
        );
        exemplar.setLivroId(livro.getId());

        Usuario usuario = new Usuario(
                "Foo",
                "12345678990",
                "11 1234-5678",
                "22021234"
        );

        Emprestimo emprestimo = emprestarExemplar(exemplar, usuario);
    }

    public static Emprestimo emprestarExemplar(Exemplar exemplar, Usuario usuario) {
        Emprestimo emprestimo = new Emprestimo(
                "01/08/2022",
                "08/08/2022",
                "",
                1
        );
        emprestimo.setUsuarioId(usuario.getId());
        emprestimo.setExemplarId(exemplar.getCodigo());
        return emprestimo;
    }

    // se entregar atrasado, retornar uma mensagem de alerta "Usuário x não devolveu o exemplar na data prevista."

}


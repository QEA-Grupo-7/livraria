import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
                true,
                false
        );
        exemplar.setLivroId(livro.getId());

        Usuario usuario = new Usuario(
                "Foo Bar",
                "12345678990",
                "11 1234-5678",
                "22021234"
        );

        Emprestimo emprestimo = emprestarExemplar(exemplar, usuario);

        Date dataEntregaFigurativa;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(emprestimo.getDataDeEmprestimo());
        calendar.add(Calendar.DATE, 9);
        dataEntregaFigurativa = calendar.getTime();

        emprestimo.setDataDeEntregaReal( dataEntregaFigurativa );

        verificarEntrega(emprestimo);
    }

    public static Emprestimo emprestarExemplar(Exemplar exemplar, Usuario usuario) {
        Date dataEmprestimo = new Date();
        Date dataPrevista;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        calendar.add(Calendar.DATE, 7);
        dataPrevista = calendar.getTime();

        Emprestimo emprestimo = new Emprestimo(
                dataEmprestimo,
                dataPrevista,
                null,
                1
        );

        emprestimo.setUsuarioId(usuario.getId());

        exemplar.setEmprestada(true);
        emprestimo.setExemplarId(exemplar.getCodigo());

        return emprestimo;
    }

    public static Boolean verificarEntrega(Emprestimo emprestimo) {
        Long diferencaEmDias = getDiferencaDeDatas(
                emprestimo.getDataPrevistaDeDevolucao(),
                emprestimo.getDataDeEntregaReal(),
                TimeUnit.DAYS
        );

        if (diferencaEmDias > 0) {
            System.out.println("Não devolveu o exemplar na data prevista!");
            System.out.println("Dias de atraso: " + diferencaEmDias + " dia" + (diferencaEmDias > 1 ? "s" : "") );
            return false;
        }

        System.out.println("Entregou no prazo!");
        return true;
    }

    private static long getDiferencaDeDatas(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}


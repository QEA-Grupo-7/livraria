import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {

    public static final String PATH = "C:\\Users\\Ricky\\IdeaProjects\\livraria\\src\\";

    public static void main(String[] args) throws IOException {

        List<Usuario> usuarios = getUsuarios();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Cadastrando usuário...");

        Usuario usuario = new Usuario(nome, cpf, telefone);

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Verificar se obra existe no acervo");
        System.out.println("0 - Sair");
        String opcao = scanner.nextLine();

        switch (opcao) {
            case "0": {
                System.out.println("Saindo...");
                break;
            }
            case "1": {
                System.out.println("Digite o nome da obra: ");
                String busca = scanner.nextLine();

                System.out.println("Buscando livro com nome '" + busca + "'...");

                List<Livro> livros = getLivros();

                Livro livroEncontrado = null;

                for (Livro livro : livros) {
                    if (livro.getTitulo().equals(busca)) {
                        livroEncontrado = livro;
                        break;
                    }
                }

                if (livroEncontrado != null) {
                    System.out.println("Livro encontrado no acervo!\n");
                    System.out.println("Título: " + livroEncontrado.getTitulo());
                    System.out.println("Autor: " + livroEncontrado.getAutor());
                    System.out.println("Editora: " + livroEncontrado.getEditora());
                    System.out.println("Ano de publicação: " + livroEncontrado.getAno());
                    System.out.println("ISBN: " + livroEncontrado.getISBN());
                    System.out.println("");
                } else {
                    System.out.println("Livro não encontrado no acervo!\n");
                }
            }
        }

        // Exemplar exemplar = new Exemplar(
        // "1",
        // true,
        // false);
        // exemplar.setLivroId(livro.getId());

        // Emprestimo emprestimo = criarEmprestimo(exemplar, usuario);

        // Date dataEntregaFigurativa;
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(emprestimo.getDataDeEmprestimo());
        // calendar.add(Calendar.DATE, 9);
        // dataEntregaFigurativa = calendar.getTime();

        // emprestimo.setDataDeEntregaReal(dataEntregaFigurativa);

        // verificarEntrega(emprestimo);
    }

    public static Emprestimo criarEmprestimo(Exemplar exemplar, Usuario usuario) {
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
                1);

        emprestimo.setUsuarioId(usuario.getId());

        exemplar.setEmprestada(true);
        emprestimo.setExemplarId(exemplar.getCodigo());

        return emprestimo;
    }

    public static Boolean verificarEntrega(Emprestimo emprestimo) {
        Long diferencaEmDias = getDiferencaDeDatas(
                emprestimo.getDataPrevistaDeDevolucao(),
                emprestimo.getDataDeEntregaReal(),
                TimeUnit.DAYS);

        if (diferencaEmDias > 0) {
            System.out.println("Não devolveu o exemplar na data prevista!");
            System.out.println("Dias de atraso: " + diferencaEmDias + " dia" + (diferencaEmDias > 1 ? "s" : ""));
            return false;
        }

        System.out.println("Entregou no prazo!");
        return true;
    }

    private static long getDiferencaDeDatas(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private static List<Usuario> getUsuarios() throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(PATH + "users.json"), StandardCharsets.UTF_8);

        Type usuariosType = new TypeToken<ArrayList<Usuario>>() {
        }.getType();

        List<Usuario> usuarios = gson.fromJson(reader, usuariosType);

        reader.close();

        return usuarios;
    }

    private static List<Livro> getLivros() throws IOException {
        Gson gson = new Gson();

        // read json in utf 8 format
        Reader reader = Files.newBufferedReader(Paths.get(PATH + "books.json"), StandardCharsets.UTF_8);

        Type livrosType = new TypeToken<ArrayList<Livro>>() {
        }.getType();

        List<Livro> livros = gson.fromJson(reader, livrosType);

        reader.close();

        return livros;
    }

    private static List<Autor> getAutores() throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(PATH + "author.json"), StandardCharsets.UTF_8);

        Type autoresType = new TypeToken<ArrayList<Autor>>() {
        }.getType();

        List<Autor> autores = gson.fromJson(reader, autoresType);

        reader.close();

        return autores;
    }
}

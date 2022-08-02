import java.util.UUID;

public class Emprestimo {

    private String id;
    private String usuarioId;
    private String exemplarId;
    private String dataDeEmprestimo;
    private String dataPrevistaDeDevolucao;
    private String dataDeEntregaReal;
    private Integer situacao;

    public Emprestimo() {
        this.id = UUID.randomUUID().toString();
    }

    public Emprestimo(String dataDeEmprestimo, String dataPrevistaDeDevolucao, String dataDeEntregaReal, Integer situacao) {
        this.id = UUID.randomUUID().toString();
        this.setDataDeEmprestimo(dataDeEmprestimo);
        this.setDataPrevistaDeDevolucao(dataPrevistaDeDevolucao);
        this.setDataDeEntregaReal(dataDeEntregaReal);
        this.setSituacao(situacao);
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(String exemplarId) {
        this.exemplarId = exemplarId;
    }

    public String getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(String dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public String getDataPrevistaDeDevolucao() {
        return dataPrevistaDeDevolucao;
    }

    public void setDataPrevistaDeDevolucao(String dataPrevistaDeDevolucao) {
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
    }

    public String getDataDeEntregaReal() {
        return dataDeEntregaReal;
    }

    public void setDataDeEntregaReal(String dataDeEntregaReal) {
        this.dataDeEntregaReal = dataDeEntregaReal;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

}

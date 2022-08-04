import java.util.Date;
import java.util.UUID;

public class Emprestimo {

    private String id;
    private String usuarioId;
    private String exemplarId;
    private Date dataDeEmprestimo;
    private Date dataPrevistaDeDevolucao;
    private Date dataDeEntregaReal;
    private Integer situacao;

    public Emprestimo() {
        this.id = UUID.randomUUID().toString();
    }

    public Emprestimo(Date dataDeEmprestimo, Date dataPrevistaDeDevolucao, Date dataDeEntregaReal, Integer situacao) {
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

    public Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(Date dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public Date getDataPrevistaDeDevolucao() {
        return dataPrevistaDeDevolucao;
    }

    public void setDataPrevistaDeDevolucao(Date dataPrevistaDeDevolucao) {
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
    }

    public Date getDataDeEntregaReal() {
        return dataDeEntregaReal;
    }

    public void setDataDeEntregaReal(Date dataDeEntregaReal) {
        this.dataDeEntregaReal = dataDeEntregaReal;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

}

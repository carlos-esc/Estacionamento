package modelo;

public class Fatura {
    private int idFatura;
    private int idContratoFK;
    private String mesReferencia;
    private String periodo;
    private String vencimento;
    private float valor;
    private String dataPagamento;
    private String status;

    /**
     * @return the idFatura
     */
    public int getIdFatura() {
        return idFatura;
    }

    /**
     * @param idFatura the idFatura to set
     */
    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    /**
     * @return the idContratoFK
     */
    public int getIdContratoFK() {
        return idContratoFK;
    }

    /**
     * @param idContratoFK the idContratoFK to set
     */
    public void setIdContratoFK(int idContratoFK) {
        this.idContratoFK = idContratoFK;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the mesReferencia
     */
    public String getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @param mesReferencia the mesReferencia to set
     */
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the dataPagamento
     */
    public String getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

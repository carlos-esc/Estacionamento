package modelo;

public class Pacote {
    
    private int idPacote;
    private String tipoPacote;
    private String utilizacoesOuDias;
    private int quantidade;
    private String dataInicio;
    private String dateTermino;
    private float preco;

    /**
     * @return the idPacote
     */
    public int getIdPacote() {
        return idPacote;
    }

    /**
     * @param idPacote the idPacote to set
     */
    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    /**
     * @return the tipoPacote
     */
    public String getTipoPacote() {
        return tipoPacote;
    }

    /**
     * @param tipoPacote the tipoPacote to set
     */
    public void setTipoPacote(String tipoPacote) {
        this.tipoPacote = tipoPacote;
    }

    /**
     * @return the utilizacoesOuDias
     */
    public String getUtilizacoesOuDias() {
        return utilizacoesOuDias;
    }

    /**
     * @param utilizacoesOuDias the utilizacoesOuDias to set
     */
    public void setUtilizacoesOuDias(String utilizacoesOuDias) {
        this.utilizacoesOuDias = utilizacoesOuDias;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dataInicio
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dateTermino
     */
    public String getDateTermino() {
        return dateTermino;
    }

    /**
     * @param dateTermino the dateTermino to set
     */
    public void setDateTermino(String dateTermino) {
        this.dateTermino = dateTermino;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}

package modelo;

public class Pacote {
    
    private int idPacote;
    private String nome;
    private String utilizacoesOuDias;
    private int quantidade;
    private String dataInicio;
    private String dataTermino;
    private float valor;

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the dataTermino
     */
    public String getDataTermino() {
        return dataTermino;
    }

    /**
     * @param dataTermino the dateTermino to set
     */
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the preco to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
}

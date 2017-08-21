package modelo;

public class Contrato {
    private int idContrato;
    private String status;
    private String tipo;
    private String medicao;
    private int quantidade;
    private String dataInicio;
    private String dataTermino;
    private String diaVencimento;
    private String ultimaAlteracao;
    private float valor;
    
    //DADOS CLIENTE
    private Cliente cliente = new Cliente();
    
    //DADOS VEÍCULOS
    private Veiculo veiculo1 = new Veiculo();
    private Veiculo veiculo2 = new Veiculo();
    private Veiculo veiculo3 = new Veiculo();
    private Veiculo veiculo4 = new Veiculo();
    
    /**
     * @return the idContrato
     */
    public int getIdContrato() {
        return idContrato;
    }

    /**
     * @param idContrato the idContrato to set
     */
    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @param dataTermino the dataTermino to set
     */
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * @return the diaVencimento
     */
    public String getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the diaVencimento to set
     */
    public void setDiaVencimento(String diaVencimento) {
        this.diaVencimento = diaVencimento;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the veiculo1
     */
    public Veiculo getVeiculo1() {
        return veiculo1;
    }

    /**
     * @param veiculo1 the veiculo1 to set
     */
    public void setVeiculo1(Veiculo veiculo1) {
        this.veiculo1 = veiculo1;
    }

    /**
     * @return the veiculo2
     */
    public Veiculo getVeiculo2() {
        return veiculo2;
    }

    /**
     * @param veiculo2 the veiculo2 to set
     */
    public void setVeiculo2(Veiculo veiculo2) {
        this.veiculo2 = veiculo2;
    }

    /**
     * @return the veiculo3
     */
    public Veiculo getVeiculo3() {
        return veiculo3;
    }

    /**
     * @param veiculo3 the veiculo3 to set
     */
    public void setVeiculo3(Veiculo veiculo3) {
        this.veiculo3 = veiculo3;
    }

    /**
     * @return the veiculo4
     */
    public Veiculo getVeiculo4() {
        return veiculo4;
    }

    /**
     * @param veiculo4 the veiculo4 to set
     */
    public void setVeiculo4(Veiculo veiculo4) {
        this.veiculo4 = veiculo4;
    }

    /**
     * @return the medicao
     */
    public String getMedicao() {
        return medicao;
    }

    /**
     * @param medicao the medicao to set
     */
    public void setMedicao(String medicao) {
        this.medicao = medicao;
    }

    /**
     * @return the ultimaAlteracao
     */
    public String getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    /**
     * @param ultimaAlteracao the ultimaAlteracao to set
     */
    public void setUltimaAlteracao(String ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }
}

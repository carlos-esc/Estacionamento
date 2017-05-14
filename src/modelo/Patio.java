package modelo;

public class Patio {    
    //bdestacionamento/patio (Preenchidos na ENTRADA do veículo)
    private int idPatio;
    private int idVeiculoFk;
    private String placaFk;
    private String rps;
    private String prisma;
    private String tipo;
    private float preco30Minutos;
    private float preco60Minutos;
    private float precoDemaisFracoes;
    private float precoDiaria;
    private float precoPernoite;
    private String estacionado;
    private String dataEntrada;
    private String horaEntrada;
    private int toleranciaDesistencia;
    private int toleranciaEntreFracoes;
    private int diariaHoras;
    private int diariaMinutos;
    private String pernoiteInicio;
    private String pernoiteTermino;
    //bdestacionamento/patio (Preenchidos na SAÍDA do veículo)
    private String dataSaida;
    private String horaSaida;
    private String permanencia;
    private float valorTotal;
    private String horaMinutoDataEntrada;
    private String horaMinutoDataSaida; 
    
    //modelo/RotativoCalculaSaida
    private int diariaQuantidade;
    private float diariasValorTotal;
    private int pernoiteQuantidade;
    private float pernoitesValorTotal;
    private float valorDataEntrada;
    private float valorDataSaida;
    
    /**
     * @return the rps
     */
    public String getRps() {
        return rps;
    }

    /**
     * @param rps the rps to set
     */
    public void setRps(String rps) {
        this.rps = rps;
    }

    /**
     * @return the prisma
     */
    public String getPrisma() {
        return prisma;
    }

    /**
     * @param prisma the prisma to set
     */
    public void setPrisma(String prisma) {
        this.prisma = prisma;
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
     * @return the estacionado
     */
    public String getEstacionado() {
        return estacionado;
    }

    /**
     * @param estacionado the estacionado to set
     */
    public void setEstacionado(String estacionado) {
        this.estacionado = estacionado;
    }

    /**
     * @return the dataEntrada
     */
    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

     /**
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the dataSaida
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the diariaQuantidade
     */
    public int getDiariaQuantidade() {
        return diariaQuantidade;
    }

    /**
     * @param diariaQuantidade the diariaQuantidade to set
     */
    public void setDiariaQuantidade(int diariaQuantidade) {
        this.diariaQuantidade = diariaQuantidade;
    }

    /**
     * @return the diariasValorTotal
     */
    public float getDiariasValorTotal() {
        return diariasValorTotal;
    }

    /**
     * @param diariasValorTotal the diariasValorTotal to set
     */
    public void setDiariasValorTotal(float diariasValorTotal) {
        this.diariasValorTotal = diariasValorTotal;
    }

    /**
     * @return the pernoiteQuantidade
     */
    public int getPernoiteQuantidade() {
        return pernoiteQuantidade;
    }

    /**
     * @param pernoiteQuantidade the pernoiteQuantidade to set
     */
    public void setPernoiteQuantidade(int pernoiteQuantidade) {
        this.pernoiteQuantidade = pernoiteQuantidade;
    }

    /**
     * @return the pernoitesValorTotal
     */
    public float getPernoitesValorTotal() {
        return pernoitesValorTotal;
    }

    /**
     * @param pernoitesValorTotal the pernoitesValorTotal to set
     */
    public void setPernoitesValorTotal(float pernoitesValorTotal) {
        this.pernoitesValorTotal = pernoitesValorTotal;
    }

    /**
     * @return the permanencia
     */
    public String getPermanencia() {
        return permanencia;
    }

    /**
     * @param permanencia the permanencia to set
     */
    public void setPermanencia(String permanencia) {
        this.permanencia = permanencia;
    }

    /**
     * @return the valorDataEntrada
     */
    public float getValorDataEntrada() {
        return valorDataEntrada;
    }

    /**
     * @param valorDataEntrada the valorDataEntrada to set
     */
    public void setValorDataEntrada(float valorDataEntrada) {
        this.valorDataEntrada = valorDataEntrada;
    }

    /**
     * @return the valorDataSaida
     */
    public float getValorDataSaida() {
        return valorDataSaida;
    }

    /**
     * @param valorDataSaida the valorDataSaida to set
     */
    public void setValorDataSaida(float valorDataSaida) {
        this.valorDataSaida = valorDataSaida;
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the idPatio
     */
    public int getIdPatio() {
        return idPatio;
    }

    /**
     * @param idPatio the idPatio to set
     */
    public void setIdPatio(int idPatio) {
        this.idPatio = idPatio;
    }

    /**
     * @return the idVeiculoFk
     */
    public int getIdVeiculoFk() {
        return idVeiculoFk;
    }

    /**
     * @param idVeiculoFk the idVeiculoFk to set
     */
    public void setIdVeiculoFk(int idVeiculoFk) {
        this.idVeiculoFk = idVeiculoFk;
    }

    /**
     * @return the preco30Minutos
     */
    public float getPreco30Minutos() {
        return preco30Minutos;
    }

    /**
     * @param preco30Minutos the preco30Minutos to set
     */
    public void setPreco30Minutos(float preco30Minutos) {
        this.preco30Minutos = preco30Minutos;
    }

    /**
     * @return the preco60Minutos
     */
    public float getPreco60Minutos() {
        return preco60Minutos;
    }

    /**
     * @param preco60Minutos the preco60Minutos to set
     */
    public void setPreco60Minutos(float preco60Minutos) {
        this.preco60Minutos = preco60Minutos;
    }

    /**
     * @return the precoDemaisFracoes
     */
    public float getPrecoDemaisFracoes() {
        return precoDemaisFracoes;
    }

    /**
     * @param precoDemaisFracoes the precoDemaisFracoes to set
     */
    public void setPrecoDemaisFracoes(float precoDemaisFracoes) {
        this.precoDemaisFracoes = precoDemaisFracoes;
    }

    /**
     * @return the precoDiaria
     */
    public float getPrecoDiaria() {
        return precoDiaria;
    }

    /**
     * @param precoDiaria the precoDiaria to set
     */
    public void setPrecoDiaria(float precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    /**
     * @return the precoPernoite
     */
    public float getPrecoPernoite() {
        return precoPernoite;
    }

    /**
     * @param precoPernoite the precoPernoite to set
     */
    public void setPrecoPernoite(float precoPernoite) {
        this.precoPernoite = precoPernoite;
    }

    /**
     * @return the horaMinutoDataEntrada
     */
    public String getHoraMinutoDataEntrada() {
        return horaMinutoDataEntrada;
    }

    /**
     * @param horaMinutoDataEntrada the horaMinutoDataEntrada to set
     */
    public void setHoraMinutoDataEntrada(String horaMinutoDataEntrada) {
        this.horaMinutoDataEntrada = horaMinutoDataEntrada;
    }

    /**
     * @return the horaMinutoDataSaida
     */
    public String getHoraMinutoDataSaida() {
        return horaMinutoDataSaida;
    }

    /**
     * @param horaMinutoDataSaida the horaMinutoDataSaida to set
     */
    public void setHoraMinutoDataSaida(String horaMinutoDataSaida) {
        this.horaMinutoDataSaida = horaMinutoDataSaida;
    }

    /**
     * @return the placaFk
     */
    public String getPlacaFk() {
        return placaFk;
    }

    /**
     * @param placaFk the placaFk to set
     */
    public void setPlacaFk(String placaFk) {
        this.placaFk = placaFk;
    }
}

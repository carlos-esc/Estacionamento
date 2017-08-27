package modelo;

public class Patio {    
    //bdestacionamento/patio (Preenchidos na ENTRADA do veículo)
    private int idPatio;
    private int idContratoFk;
    private String placa;
    private String rps;
    private String prisma;
    private String tipo;
    private String nome;
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
    private String dataEntradaHoraMinuto;
    private float dataEntradaValor;
    private String dataSaidaHoraMinuto; 
    private float dataSaidaValor;
    private int diariaQuantidade;
    private float diariaValorTotal;
    private int pernoiteQuantidade;
    private float pernoiteValorTotal;
    
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
     * @return the idContratoFk
     */
    public int getIdContratoFk() {
        return idContratoFk;
    }

    /**
     * @param idContratoFk the idContratoFk to set
     */
    public void setIdContratoFk(int idContratoFk) {
        this.idContratoFk = idContratoFk;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

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
     * @return the toleranciaDesistencia
     */
    public int getToleranciaDesistencia() {
        return toleranciaDesistencia;
    }

    /**
     * @param toleranciaDesistencia the toleranciaDesistencia to set
     */
    public void setToleranciaDesistencia(int toleranciaDesistencia) {
        this.toleranciaDesistencia = toleranciaDesistencia;
    }

    /**
     * @return the toleranciaEntreFracoes
     */
    public int getToleranciaEntreFracoes() {
        return toleranciaEntreFracoes;
    }

    /**
     * @param toleranciaEntreFracoes the toleranciaEntreFracoes to set
     */
    public void setToleranciaEntreFracoes(int toleranciaEntreFracoes) {
        this.toleranciaEntreFracoes = toleranciaEntreFracoes;
    }

    /**
     * @return the diariaHoras
     */
    public int getDiariaHoras() {
        return diariaHoras;
    }

    /**
     * @param diariaHoras the diariaHoras to set
     */
    public void setDiariaHoras(int diariaHoras) {
        this.diariaHoras = diariaHoras;
    }

    /**
     * @return the diariaMinutos
     */
    public int getDiariaMinutos() {
        return diariaMinutos;
    }

    /**
     * @param diariaMinutos the diariaMinutos to set
     */
    public void setDiariaMinutos(int diariaMinutos) {
        this.diariaMinutos = diariaMinutos;
    }

    /**
     * @return the pernoiteInicio
     */
    public String getPernoiteInicio() {
        return pernoiteInicio;
    }

    /**
     * @param pernoiteInicio the pernoiteInicio to set
     */
    public void setPernoiteInicio(String pernoiteInicio) {
        this.pernoiteInicio = pernoiteInicio;
    }

    /**
     * @return the pernoiteTermino
     */
    public String getPernoiteTermino() {
        return pernoiteTermino;
    }

    /**
     * @param pernoiteTermino the pernoiteTermino to set
     */
    public void setPernoiteTermino(String pernoiteTermino) {
        this.pernoiteTermino = pernoiteTermino;
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
     * @return the dataEntradaHoraMinuto
     */
    public String getDataEntradaHoraMinuto() {
        return dataEntradaHoraMinuto;
    }

    /**
     * @param dataEntradaHoraMinuto the dataEntradaHoraMinuto to set
     */
    public void setDataEntradaHoraMinuto(String dataEntradaHoraMinuto) {
        this.dataEntradaHoraMinuto = dataEntradaHoraMinuto;
    }

    /**
     * @return the dataEntradaValor
     */
    public float getDataEntradaValor() {
        return dataEntradaValor;
    }

    /**
     * @param dataEntradaValor the dataEntradaValor to set
     */
    public void setDataEntradaValor(float dataEntradaValor) {
        this.dataEntradaValor = dataEntradaValor;
    }

    /**
     * @return the dataSaidaHoraMinuto
     */
    public String getDataSaidaHoraMinuto() {
        return dataSaidaHoraMinuto;
    }

    /**
     * @param dataSaidaHoraMinuto the dataSaidaHoraMinuto to set
     */
    public void setDataSaidaHoraMinuto(String dataSaidaHoraMinuto) {
        this.dataSaidaHoraMinuto = dataSaidaHoraMinuto;
    }

    /**
     * @return the dataSaidaValor
     */
    public float getDataSaidaValor() {
        return dataSaidaValor;
    }

    /**
     * @param dataSaidaValor the dataSaidaValor to set
     */
    public void setDataSaidaValor(float dataSaidaValor) {
        this.dataSaidaValor = dataSaidaValor;
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
     * @return the diariaValorTotal
     */
    public float getDiariaValorTotal() {
        return diariaValorTotal;
    }

    /**
     * @param diariaValorTotal the diariaValorTotal to set
     */
    public void setDiariaValorTotal(float diariaValorTotal) {
        this.diariaValorTotal = diariaValorTotal;
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
     * @return the pernoiteValorTotal
     */
    public float getPernoiteValorTotal() {
        return pernoiteValorTotal;
    }

    /**
     * @param pernoiteValorTotal the pernoiteValorTotal to set
     */
    public void setPernoiteValorTotal(float pernoiteValorTotal) {
        this.pernoiteValorTotal = pernoiteValorTotal;
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
}

package modelo;

import java.util.Date;

public class Configuracoes {
    private int toleranciaDesistencia;
    private int toleranciaFracoes;
    private int diariaHora;
    private int diariaMinuto;
    private String pernoiteInicio;
    private String pernoiteTermino;

    /**
     * @return the toleranciaDesistencia
     */
    public int getToleranciaDesistencia() {
        return toleranciaDesistencia;
    }

    /**
     * @param toleranciaDesistencia the tolerancia to set
     */
    public void setToleranciaDesistencia(int toleranciaDesistencia) {
        this.toleranciaDesistencia = toleranciaDesistencia;
    }

    /**
     * @return the diariaHora
     */
    public int getDiariaHora() {
        return diariaHora;
    }

    /**
     * @param diariaHora the diariaHora to set
     */
    public void setDiariaHora(int diariaHora) {
        this.diariaHora = diariaHora;
    }

    /**
     * @return the diariaMinuto
     */
    public int getDiariaMinuto() {
        return diariaMinuto;
    }

    /**
     * @param diariaMinuto the diariaMinuto to set
     */
    public void setDiariaMinuto(int diariaMinuto) {
        this.diariaMinuto = diariaMinuto;
    }

    /**
     * @return the toleranciaFracoes
     */
    public int getToleranciaFracoes() {
        return toleranciaFracoes;
    }

    /**
     * @param toleranciaFracoes the toleranciaFracoes to set
     */
    public void setToleranciaFracoes(int toleranciaFracoes) {
        this.toleranciaFracoes = toleranciaFracoes;
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

}

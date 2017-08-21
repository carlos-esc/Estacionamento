package modelo;

public class Fatura {
    private int idFatura;
    private int idContratoFK;
    private String mesReferencia;
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
}

package modelo;

public class RotativoTipoPreco {
    
    private int idRotativo;
    private String tipoRotativo;
    private float preco30Minutos;
    private float preco60Minutos;
    private float precoDemaisFracoes;
    private float precoDiaria;
    private float precoPernoite;

    /**
     * @return the idRotativo
     */
    public int getIdRotativo() {
        return idRotativo;
    }

    /**
     * @param idRotativo the idRotativo to set
     */
    public void setIdRotativo(int idRotativo) {
        this.idRotativo = idRotativo;
    }

    /**
     * @return the tipoRotativo
     */
    public String getTipoRotativo() {
        return tipoRotativo;
    }

    /**
     * @param tipoRotativo the tipoRotativo to set
     */
    public void setTipoRotativo(String tipoRotativo) {
        this.tipoRotativo = tipoRotativo;
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
}

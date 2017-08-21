package modelo;
public class Cliente {
    //DADOS PESSOAIS
    private int idCliente;
    private String dataInclusao;
    private String dataUltimaAlteracao;
    private String nome;
    private String cpf;
    private String identidade;
    private String telefone;
    private String celular;
    private String email;
    private String dataNascimento;
    private String cepResidencia;
    private String ruaResidencia;
    private String numeroResidencia;
    private String complementoResidencia;
    private String bairroResidencia;
    private String cidadeResidencia;
    private String estadoResidencia;
   
    //DADOS COMERCIAS
    private String empresa;
    private String cepComercial;
    private String ruaComercial;
    private String numeroComercial;
    private String complementoComercial;
    private String bairroComercial;
    private String cidadeComercial;
    private String estadoComercial;
    private String telefoneComercial;
    
    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the dataInclusao
     */
    public String getDataInclusao() {
        return dataInclusao;
    }

    /**
     * @param dataInclusao the dataInclusao to set
     */
    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    /**
     * @return the dataUltimaAlteracao
     */
    public String getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    /**
     * @param dataUltimaAlteracao the dataUltimaAlteracao to set
     */
    public void setDataUltimaAlteracao(String dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the identidade
     */
    public String getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the cepResidencia
     */
    public String getCepResidencia() {
        return cepResidencia;
    }

    /**
     * @param cepResidencia the cepResidencia to set
     */
    public void setCepResidencia(String cepResidencia) {
        this.cepResidencia = cepResidencia;
    }

    /**
     * @return the ruaResidencia
     */
    public String getRuaResidencia() {
        return ruaResidencia;
    }

    /**
     * @param ruaResidencia the ruaResidencia to set
     */
    public void setRuaResidencia(String ruaResidencia) {
        this.ruaResidencia = ruaResidencia;
    }

    /**
     * @return the numeroResidencia
     */
    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    /**
     * @param numeroResidencia the numeroResidencia to set
     */
    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    /**
     * @return the complementoResidencia
     */
    public String getComplementoResidencia() {
        return complementoResidencia;
    }

    /**
     * @param complementoResidencia the complementoResidencia to set
     */
    public void setComplementoResidencia(String complementoResidencia) {
        this.complementoResidencia = complementoResidencia;
    }

    /**
     * @return the bairroResidencia
     */
    public String getBairroResidencia() {
        return bairroResidencia;
    }

    /**
     * @param bairroResidencia the bairroResidencia to set
     */
    public void setBairroResidencia(String bairroResidencia) {
        this.bairroResidencia = bairroResidencia;
    }

    /**
     * @return the cidadeResidencia
     */
    public String getCidadeResidencia() {
        return cidadeResidencia;
    }

    /**
     * @param cidadeResidencia the cidadeResidencia to set
     */
    public void setCidadeResidencia(String cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }

    /**
     * @return the estadoResidencia
     */
    public String getEstadoResidencia() {
        return estadoResidencia;
    }

    /**
     * @param estadoResidencia the estadoResidencia to set
     */
    public void setEstadoResidencia(String estadoResidencia) {
        this.estadoResidencia = estadoResidencia;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the cepComercial
     */
    public String getCepComercial() {
        return cepComercial;
    }

    /**
     * @param cepComercial the cepComercial to set
     */
    public void setCepComercial(String cepComercial) {
        this.cepComercial = cepComercial;
    }

    /**
     * @return the ruaComercial
     */
    public String getRuaComercial() {
        return ruaComercial;
    }

    /**
     * @param ruaComercial the ruaComercial to set
     */
    public void setRuaComercial(String ruaComercial) {
        this.ruaComercial = ruaComercial;
    }

    /**
     * @return the numeroComercial
     */
    public String getNumeroComercial() {
        return numeroComercial;
    }

    /**
     * @param numeroComercial the numeroComercial to set
     */
    public void setNumeroComercial(String numeroComercial) {
        this.numeroComercial = numeroComercial;
    }

    /**
     * @return the complementoComercial
     */
    public String getComplementoComercial() {
        return complementoComercial;
    }

    /**
     * @param complementoComercial the complementoComercial to set
     */
    public void setComplementoComercial(String complementoComercial) {
        this.complementoComercial = complementoComercial;
    }

    /**
     * @return the bairroComercial
     */
    public String getBairroComercial() {
        return bairroComercial;
    }

    /**
     * @param bairroComercial the bairroComercial to set
     */
    public void setBairroComercial(String bairroComercial) {
        this.bairroComercial = bairroComercial;
    }

    /**
     * @return the cidadeComercial
     */
    public String getCidadeComercial() {
        return cidadeComercial;
    }

    /**
     * @param cidadeComercial the cidadeComercial to set
     */
    public void setCidadeComercial(String cidadeComercial) {
        this.cidadeComercial = cidadeComercial;
    }

    /**
     * @return the estadoComercial
     */
    public String getEstadoComercial() {
        return estadoComercial;
    }

    /**
     * @param estadoComercial the estadoComercial to set
     */
    public void setEstadoComercial(String estadoComercial) {
        this.estadoComercial = estadoComercial;
    }

    /**
     * @return the telefoneComercial
     */
    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    /**
     * @param telefoneComercial the telefoneComercial to set
     */
    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }
}
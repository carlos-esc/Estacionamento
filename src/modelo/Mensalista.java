package modelo;
public class Mensalista {
    private int numeroDoContrato;
    private String dataInclusao;
    private String diaVencimentoMensalidade;
    private String dataUltimaAlteracao;
    private String status;
    private String nome;
    private String cpf;
    private String identidade;
    private String telefone;
    private String celular;
    private String email;
    private String dataNascimento;
    //ENDEREÇO RESIDENCIAL
    private String cepResi;
    private String ruaResi;
    private String numeroResi;
    private String complementoResi;
    private String bairroResi;
    private String cidadeResi;
    private String estadoResi;
   
    //ENDEREÇO COMERCIAL
    private String empresa;
    private String cepCome;
    private String ruaCome;
    private String numeroCome;
    private String complementoCome;
    private String bairroCome;
    private String cidadeCome;
    private String estadoCome;
    private String telefoneCome;
    
    //VEÍCULOS(MAX 04)
    private String placa01, placa02, placa03, placa04;
    private String montadora01, montadora02, montadora03, montadora04;
    private String modelo01, modelo02, modelo03, modelo04;
    private String cor01, cor02, cor03, cor04;
    private String ano01, ano02, ano03, ano04;

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
     * @return the cepResi
     */
    public String getCepResi() {
        return cepResi;
    }

    /**
     * @param cepResi the cepResi to set
     */
    public void setCepResi(String cepResi) {
        this.cepResi = cepResi;
    }

    /**
     * @return the ruaResi
     */
    public String getRuaResi() {
        return ruaResi;
    }

    /**
     * @param ruaResi the ruaResi to set
     */
    public void setRuaResi(String ruaResi) {
        this.ruaResi = ruaResi;
    }

    /**
     * @return the numeroResi
     */
    public String getNumeroResi() {
        return numeroResi;
    }

    /**
     * @param numeroResi the numeroResi to set
     */
    public void setNumeroResi(String numeroResi) {
        this.numeroResi = numeroResi;
    }

    /**
     * @return the bairroResi
     */
    public String getBairroResi() {
        return bairroResi;
    }

    /**
     * @param bairroResi the bairroResi to set
     */
    public void setBairroResi(String bairroResi) {
        this.bairroResi = bairroResi;
    }

    /**
     * @return the cidadeResi
     */
    public String getCidadeResi() {
        return cidadeResi;
    }

    /**
     * @param cidadeResi the cidadeResi to set
     */
    public void setCidadeResi(String cidadeResi) {
        this.cidadeResi = cidadeResi;
    }

    /**
     * @return the estadoResi
     */
    public String getEstadoResi() {
        return estadoResi;
    }

    /**
     * @param estadoResi the estadoResi to set
     */
    public void setEstadoResi(String estadoResi) {
        this.estadoResi = estadoResi;
    }

    /**
     * @return the cepCome
     */
    public String getCepCome() {
        return cepCome;
    }

    /**
     * @param cepCome the cepCome to set
     */
    public void setCepCome(String cepCome) {
        this.cepCome = cepCome;
    }

    /**
     * @return the ruaCome
     */
    public String getRuaCome() {
        return ruaCome;
    }

    /**
     * @param ruaCome the ruaCome to set
     */
    public void setRuaCome(String ruaCome) {
        this.ruaCome = ruaCome;
    }

    /**
     * @return the numeroCome
     */
    public String getNumeroCome() {
        return numeroCome;
    }

    /**
     * @param numeroCome the numeroCome to set
     */
    public void setNumeroCome(String numeroCome) {
        this.numeroCome = numeroCome;
    }

    /**
     * @return the bairroCome
     */
    public String getBairroCome() {
        return bairroCome;
    }

    /**
     * @param bairroCome the bairroCome to set
     */
    public void setBairroCome(String bairroCome) {
        this.bairroCome = bairroCome;
    }

    /**
     * @return the cidadeCome
     */
    public String getCidadeCome() {
        return cidadeCome;
    }

    /**
     * @param cidadeCome the cidadeCome to set
     */
    public void setCidadeCome(String cidadeCome) {
        this.cidadeCome = cidadeCome;
    }

    /**
     * @return the estadoCome
     */
    public String getEstadoCome() {
        return estadoCome;
    }

    /**
     * @param estadoCome the estadoCome to set
     */
    public void setEstadoCome(String estadoCome) {
        this.estadoCome = estadoCome;
    }

    /**
     * @return the placa01
     */
    public String getPlaca01() {
        return placa01;
    }

    /**
     * @param placa01 the placa01 to set
     */
    public void setPlaca01(String placa01) {
        this.placa01 = placa01;
    }

    /**
     * @return the placa02
     */
    public String getPlaca02() {
        return placa02;
    }

    /**
     * @param placa02 the placa02 to set
     */
    public void setPlaca02(String placa02) {
        this.placa02 = placa02;
    }

    /**
     * @return the placa03
     */
    public String getPlaca03() {
        return placa03;
    }

    /**
     * @param placa03 the placa03 to set
     */
    public void setPlaca03(String placa03) {
        this.placa03 = placa03;
    }

    /**
     * @return the placa04
     */
    public String getPlaca04() {
        return placa04;
    }

    /**
     * @param placa04 the placa04 to set
     */
    public void setPlaca04(String placa04) {
        this.placa04 = placa04;
    }

    /**
     * @return the montadora01
     */
    public String getMontadora01() {
        return montadora01;
    }

    /**
     * @param montadora01 the montadora01 to set
     */
    public void setMontadora01(String montadora01) {
        this.montadora01 = montadora01;
    }

    /**
     * @return the montadora02
     */
    public String getMontadora02() {
        return montadora02;
    }

    /**
     * @param montadora02 the montadora02 to set
     */
    public void setMontadora02(String montadora02) {
        this.montadora02 = montadora02;
    }

    /**
     * @return the montadora03
     */
    public String getMontadora03() {
        return montadora03;
    }

    /**
     * @param montadora03 the montadora03 to set
     */
    public void setMontadora03(String montadora03) {
        this.montadora03 = montadora03;
    }

    /**
     * @return the montadora04
     */
    public String getMontadora04() {
        return montadora04;
    }

    /**
     * @param montadora04 the montadora04 to set
     */
    public void setMontadora04(String montadora04) {
        this.montadora04 = montadora04;
    }

    /**
     * @return the modelo01
     */
    public String getModelo01() {
        return modelo01;
    }

    /**
     * @param modelo01 the modelo01 to set
     */
    public void setModelo01(String modelo01) {
        this.modelo01 = modelo01;
    }

    /**
     * @return the modelo02
     */
    public String getModelo02() {
        return modelo02;
    }

    /**
     * @param modelo02 the modelo02 to set
     */
    public void setModelo02(String modelo02) {
        this.modelo02 = modelo02;
    }

    /**
     * @return the modelo03
     */
    public String getModelo03() {
        return modelo03;
    }

    /**
     * @param modelo03 the modelo03 to set
     */
    public void setModelo03(String modelo03) {
        this.modelo03 = modelo03;
    }

    /**
     * @return the modelo04
     */
    public String getModelo04() {
        return modelo04;
    }

    /**
     * @param modelo04 the modelo04 to set
     */
    public void setModelo04(String modelo04) {
        this.modelo04 = modelo04;
    }

    /**
     * @return the cor01
     */
    public String getCor01() {
        return cor01;
    }

    /**
     * @param cor01 the cor01 to set
     */
    public void setCor01(String cor01) {
        this.cor01 = cor01;
    }

    /**
     * @return the cor02
     */
    public String getCor02() {
        return cor02;
    }

    /**
     * @param cor02 the cor02 to set
     */
    public void setCor02(String cor02) {
        this.cor02 = cor02;
    }

    /**
     * @return the cor03
     */
    public String getCor03() {
        return cor03;
    }

    /**
     * @param cor03 the cor03 to set
     */
    public void setCor03(String cor03) {
        this.cor03 = cor03;
    }

    /**
     * @return the cor04
     */
    public String getCor04() {
        return cor04;
    }

    /**
     * @param cor04 the cor04 to set
     */
    public void setCor04(String cor04) {
        this.cor04 = cor04;
    }

    /**
     * @return the ano01
     */
    public String getAno01() {
        return ano01;
    }

    /**
     * @param ano01 the ano01 to set
     */
    public void setAno01(String ano01) {
        this.ano01 = ano01;
    }

    /**
     * @return the ano02
     */
    public String getAno02() {
        return ano02;
    }

    /**
     * @param ano02 the ano02 to set
     */
    public void setAno02(String ano02) {
        this.ano02 = ano02;
    }

    /**
     * @return the ano03
     */
    public String getAno03() {
        return ano03;
    }

    /**
     * @param ano03 the ano03 to set
     */
    public void setAno03(String ano03) {
        this.ano03 = ano03;
    }

    /**
     * @return the ano04
     */
    public String getAno04() {
        return ano04;
    }

    /**
     * @param ano04 the ano04 to set
     */
    public void setAno04(String ano04) {
        this.ano04 = ano04;
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
     * @return the complementoResi
     */
    public String getComplementoResi() {
        return complementoResi;
    }

    /**
     * @param complementoResi the complementoResi to set
     */
    public void setComplementoResi(String complementoResi) {
        this.complementoResi = complementoResi;
    }

    /**
     * @return the complementoCome
     */
    public String getComplementoCome() {
        return complementoCome;
    }

    /**
     * @param complementoCome the complementoCome to set
     */
    public void setComplementoCome(String complementoCome) {
        this.complementoCome = complementoCome;
    }

    /**
     * @return the telefoneCome
     */
    public String getTelefoneCome() {
        return telefoneCome;
    }

    /**
     * @param telefoneCome the telefoneCome to set
     */
    public void setTelefoneCome(String telefoneCome) {
        this.telefoneCome = telefoneCome;
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
     * @return the diaVencimentoMensalidade
     */
    public String getDiaVencimentoMensalidade() {
        return diaVencimentoMensalidade;
    }

    /**
     * @param diaVencimentoMensalidade the diaVencimentoMensalidade to set
     */
    public void setDiaVencimentoMensalidade(String diaVencimentoMensalidade) {
        this.diaVencimentoMensalidade = diaVencimentoMensalidade;
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
     * @return the numeroDoContrato
     */
    public int getNumeroDoContrato() {
        return numeroDoContrato;
    }

    /**
     * @param numeroDoContrato the numeroDoContrato to set
     */
    public void setNumeroDoContrato(int numeroDoContrato) {
        this.numeroDoContrato = numeroDoContrato;
    }
}

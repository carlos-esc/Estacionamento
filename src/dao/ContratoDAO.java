package dao;

import factory.ConexaoFactory;
import gui.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contrato;
import modelo.Fatura;
import service.FaturaService;
import service.VeiculoService;

public class ContratoDAO {

    private Connection conexao;

    public ContratoDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List ContratoList(String clienteNome, String contratoMensalistaOuPacote, String contratoStatus, String numeroContrato) {
        try {
            List<Contrato> contratoArrayList = new ArrayList<>();
            VeiculoService veiculoService = new VeiculoService();
            String sql = "SELECT * FROM contrato INNER JOIN cliente ON contrato.id_cliente_fk = cliente.id_cliente "
                    + "WHERE cliente.nome LIKE '%" + clienteNome + "%' AND contrato.mensalista_ou_pacote LIKE '%" + contratoMensalistaOuPacote + "%' AND contrato.status LIKE '" + contratoStatus + "%' AND contrato.id_contrato LIKE '" + numeroContrato + "'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.getIdClienteFk().setIdCliente(rs.getInt("id_cliente"));
                contrato.getIdClienteFk().setDataInclusao(rs.getString("data_inclusao"));
                contrato.getIdClienteFk().setDataUltimaAlteracao(rs.getString("data_ultima_alteracao"));
                contrato.getIdClienteFk().setNome(rs.getString("nome"));
                contrato.getIdClienteFk().setCpf(rs.getString("cpf"));
                contrato.getIdClienteFk().setIdentidade(rs.getString("identidade"));
                contrato.getIdClienteFk().setTelefone(rs.getString("telefone"));
                contrato.getIdClienteFk().setCelular(rs.getString("celular"));
                contrato.getIdClienteFk().setEmail(rs.getString("email"));
                contrato.getIdClienteFk().setDataNascimento(rs.getString("data_nascimento"));
                contrato.getIdClienteFk().setCepResidencia(rs.getString("cep_residencia"));
                contrato.getIdClienteFk().setRuaResidencia(rs.getString("rua_residencia"));
                contrato.getIdClienteFk().setNumeroResidencia(rs.getString("numero_residencia"));
                contrato.getIdClienteFk().setComplementoResidencia(rs.getString("complemento_residencia"));
                contrato.getIdClienteFk().setBairroResidencia(rs.getString("bairro_residencia"));
                contrato.getIdClienteFk().setCidadeResidencia(rs.getString("cidade_residencia"));
                contrato.getIdClienteFk().setEstadoResidencia(rs.getString("estado_residencia"));
                contrato.getIdClienteFk().setEmpresa(rs.getString("empresa"));
                contrato.getIdClienteFk().setCepComercial(rs.getString("cep_comercial"));
                contrato.getIdClienteFk().setRuaComercial(rs.getString("rua_comercial"));
                contrato.getIdClienteFk().setNumeroComercial(rs.getString("numero_comercial"));
                contrato.getIdClienteFk().setComplementoComercial(rs.getString("complemento_comercial"));
                contrato.getIdClienteFk().setCidadeComercial(rs.getString("cidade_comercial"));
                contrato.getIdClienteFk().setEstadoComercial(rs.getString("estado_comercial"));
                contrato.getIdClienteFk().setTelefoneComercial(rs.getString("telefone_comercial"));
                //DADOS CONTRATO
                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setStatus(rs.getString("status"));
                contrato.setMensalistaOuPacote(rs.getString("mensalista_ou_pacote"));
                contrato.setDiasOuUtilizacoes(rs.getString("dias_ou_utilizacoes"));
                contrato.setQuantidade(rs.getInt("quantidade"));
                contrato.setDataInicio(rs.getString("data_inicio"));
                contrato.setDataTermino(rs.getString("data_termino"));
                contrato.setDiaVencimento(rs.getString("dia_vencimento"));
                contrato.setDataCancelamento(rs.getString("data_cancelamento"));
                contrato.setValor(rs.getFloat("valor"));
                if (rs.getString("placa_1") != null && !rs.getString("placa_1").equals("")) {
                    contrato.setVeiculo1(veiculoService.veiculoIsCadastrado(rs.getString("placa_1")));
                }
                if (rs.getString("placa_2") != null && !rs.getString("placa_2").equals("")) {
                    contrato.setVeiculo2(veiculoService.veiculoIsCadastrado(rs.getString("placa_2")));
                }
                if (rs.getString("placa_3") != null && !rs.getString("placa_3").equals("")) {
                    contrato.setVeiculo3(veiculoService.veiculoIsCadastrado(rs.getString("placa_3")));
                }
                if (rs.getString("placa_4") != null && !rs.getString("placa_4").equals("")) {
                    contrato.setVeiculo4(veiculoService.veiculoIsCadastrado(rs.getString("placa_4")));
                }
                contratoArrayList.add(contrato);
            }
            rs.close();
            stmt.close();
            return contratoArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Contrato placaIsContratoCliente(Contrato contrato, String placa) {
        try {
            VeiculoService veiculoService = new VeiculoService();
            String sql = "SELECT * FROM contrato INNER JOIN cliente ON contrato.id_cliente_fk = cliente.id_cliente "
                    + "WHERE (placa_1=? OR placa_2=? OR placa_3=? OR placa_4=?) AND status='Ativo'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.setString(2, placa);
            stmt.setString(3, placa);
            stmt.setString(4, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                contrato.getIdClienteFk().setIdCliente(rs.getInt("id_cliente"));
                contrato.getIdClienteFk().setDataInclusao(rs.getString("data_inclusao"));
                contrato.getIdClienteFk().setDataUltimaAlteracao(rs.getString("data_ultima_alteracao"));
                contrato.getIdClienteFk().setNome(rs.getString("nome"));
                contrato.getIdClienteFk().setCpf(rs.getString("cpf"));
                contrato.getIdClienteFk().setIdentidade(rs.getString("identidade"));
                contrato.getIdClienteFk().setTelefone(rs.getString("telefone"));
                contrato.getIdClienteFk().setCelular(rs.getString("celular"));
                contrato.getIdClienteFk().setEmail(rs.getString("email"));
                contrato.getIdClienteFk().setDataNascimento(rs.getString("data_nascimento"));
                contrato.getIdClienteFk().setCepResidencia(rs.getString("cep_residencia"));
                contrato.getIdClienteFk().setRuaResidencia(rs.getString("rua_residencia"));
                contrato.getIdClienteFk().setNumeroResidencia(rs.getString("numero_residencia"));
                contrato.getIdClienteFk().setComplementoResidencia(rs.getString("complemento_residencia"));
                contrato.getIdClienteFk().setBairroResidencia(rs.getString("bairro_residencia"));
                contrato.getIdClienteFk().setCidadeResidencia(rs.getString("cidade_residencia"));
                contrato.getIdClienteFk().setEstadoResidencia(rs.getString("estado_residencia"));
                contrato.getIdClienteFk().setEmpresa(rs.getString("empresa"));
                contrato.getIdClienteFk().setCepComercial(rs.getString("cep_comercial"));
                contrato.getIdClienteFk().setRuaComercial(rs.getString("rua_comercial"));
                contrato.getIdClienteFk().setNumeroComercial(rs.getString("numero_comercial"));
                contrato.getIdClienteFk().setComplementoComercial(rs.getString("complemento_comercial"));
                contrato.getIdClienteFk().setCidadeComercial(rs.getString("cidade_comercial"));
                contrato.getIdClienteFk().setEstadoComercial(rs.getString("estado_comercial"));
                contrato.getIdClienteFk().setTelefoneComercial(rs.getString("telefone_comercial"));
                //DADOS CONTRATO
                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setStatus(rs.getString("status"));
                contrato.setMensalistaOuPacote(rs.getString("mensalista_ou_pacote"));
                contrato.setDiasOuUtilizacoes(rs.getString("dias_ou_utilizacoes"));
                contrato.setQuantidade(rs.getInt("quantidade"));
                contrato.setDataInicio(rs.getString("data_inicio"));
                contrato.setDataTermino(rs.getString("data_termino"));
                contrato.setDiaVencimento(rs.getString("dia_vencimento"));
                contrato.setDataCancelamento(rs.getString("data_cancelamento"));
                contrato.setValor(rs.getFloat("valor"));
                if (rs.getString("placa_1") == null || rs.getString("placa_1").equalsIgnoreCase("")) {
                    contrato.getVeiculo1().setPlaca("");
                } else {
                    contrato.setVeiculo1(veiculoService.veiculoIsCadastrado(rs.getString("placa_1")));
                }
                if (rs.getString("placa_2") == null || rs.getString("placa_2").equalsIgnoreCase("")) {
                    contrato.getVeiculo2().setPlaca("");
                } else {
                    contrato.setVeiculo2(veiculoService.veiculoIsCadastrado(rs.getString("placa_2")));
                }
                if (rs.getString("placa_3") == null || rs.getString("placa_3").equalsIgnoreCase("")) {
                    contrato.getVeiculo3().setPlaca("");
                } else {
                    contrato.setVeiculo3(veiculoService.veiculoIsCadastrado(rs.getString("placa_3")));
                }
                if (rs.getString("placa_4") == null || rs.getString("placa_4").equalsIgnoreCase("")) {
                    contrato.getVeiculo4().setPlaca("");
                } else {
                    contrato.setVeiculo4(veiculoService.veiculoIsCadastrado(rs.getString("placa_4")));
                }

            } else {
                contrato.setIdContrato(0);
            }
            rs.close();
            stmt.close();
            return contrato;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Contrato contratoIncluir(Contrato contrato) {
        try {
            String sql = "INSERT INTO contrato(id_cliente_fk, placa_1, placa_2, placa_3, placa_4, status, mensalista_ou_pacote, dias_ou_utilizacoes, quantidade, data_inicio, data_termino, dia_vencimento, data_cancelamento, valor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, contrato.getIdClienteFk().getIdCliente());
            stmt.setString(2, contrato.getVeiculo1().getPlaca());
            stmt.setString(3, contrato.getVeiculo2().getPlaca());
            stmt.setString(4, contrato.getVeiculo3().getPlaca());
            stmt.setString(5, contrato.getVeiculo4().getPlaca());
            stmt.setString(6, contrato.getStatus());
            stmt.setString(7, contrato.getMensalistaOuPacote());
            stmt.setString(8, contrato.getDiasOuUtilizacoes());
            stmt.setInt(9, contrato.getQuantidade());
            stmt.setString(10, contrato.getDataInicio());
            stmt.setString(11, contrato.getDataTermino());
            stmt.setString(12, contrato.getDiaVencimento());
            stmt.setString(13, contrato.getDataCancelamento());
            stmt.setFloat(14, contrato.getValor());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                contrato.setIdContrato(resultSet.getInt("LAST_INSERT_ID()"));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }

    public Contrato contratoAlterar(Contrato contrato) {
        try {
            String sql = "UPDATE contrato SET placa_1=?, placa_2=?, placa_3=?, placa_4=?, status=?, mensalista_ou_pacote=?, dias_ou_utilizacoes=?, quantidade=?, data_inicio=?, data_termino=?, dia_vencimento=?, data_cancelamento=?, valor=? WHERE id_contrato=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, contrato.getVeiculo1().getPlaca());
            stmt.setString(2, contrato.getVeiculo2().getPlaca());
            stmt.setString(3, contrato.getVeiculo3().getPlaca());
            stmt.setString(4, contrato.getVeiculo4().getPlaca());
            stmt.setString(5, contrato.getStatus());
            stmt.setString(6, contrato.getMensalistaOuPacote());
            stmt.setString(7, contrato.getDiasOuUtilizacoes());
            stmt.setInt(8, contrato.getQuantidade());
            stmt.setString(9, contrato.getDataInicio());
            stmt.setString(10, contrato.getDataTermino());
            stmt.setString(11, contrato.getDiaVencimento());
            stmt.setString(12, contrato.getDataCancelamento());
            stmt.setFloat(13, contrato.getValor());
            stmt.setInt(14, contrato.getIdContrato());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }

    public Contrato contratoCancelar(Contrato contrato) {
        try {
            String sql = "UPDATE contrato SET status=?, data_cancelamento=? WHERE id_contrato=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, contrato.getStatus());
            stmt.setString(2, contrato.getDataCancelamento());
            stmt.setInt(3, contrato.getIdContrato());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }

    public List contratoGeraFatura() {
        try {
            String sql = "SELECT * FROM contrato WHERE status='Ativo'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Contrato> contratoArrayList = new ArrayList<>();
            Contrato contrato = new Contrato();
            while (rs.next()) {
                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setDataInicio(rs.getString("data_inicio"));
                contrato.setDiaVencimento(rs.getString("dia_vencimento"));
                contrato.setValor(rs.getFloat("valor"));

                Calendar dataInicioContrato = Calendar.getInstance();
                Calendar dataAtual = Calendar.getInstance();
                SimpleDateFormat sdfAnoMes = new SimpleDateFormat("yyyy/MM");
                SimpleDateFormat sdfMesAno = new SimpleDateFormat("MM/yyyy");
                SimpleDateFormat sdfDiaMesAno = new SimpleDateFormat("dd/MM/yyy");
                Fatura fatura = new Fatura();
                FaturaService faturaService = new FaturaService();
                try {
                    dataInicioContrato.setTime(sdfDiaMesAno.parse(contrato.getDataInicio()));
                    do {
                        if (faturaService.existeFaturaMesCorrente(contrato.getIdContrato(), sdfMesAno.format(dataInicioContrato.getTime()))) {
                            System.out.println("Já existe fatura referente à: " + sdfMesAno.format(dataInicioContrato.getTime()));
                            dataInicioContrato.add(Calendar.MONTH, 1);
                        } else {
                            fatura.setIdContratoFK(contrato.getIdContrato());
                            fatura.setMesReferencia(sdfMesAno.format(dataInicioContrato.getTime()));
                            fatura.setPeriodo(sdfDiaMesAno.format(dataInicioContrato.getTime()) + "à");
                            dataInicioContrato.add(Calendar.MONTH, 1);
                            dataInicioContrato.add(Calendar.DATE, -1);
                            fatura.setPeriodo(fatura.getPeriodo() + sdfDiaMesAno.format(dataInicioContrato.getTime()));
                            dataInicioContrato.add(Calendar.DATE, 1);
                            fatura.setVencimento(contrato.getDiaVencimento() + "/" + fatura.getMesReferencia());
                            fatura.setValor(contrato.getValor());
                            fatura.setStatus("Não Paga");
                            faturaService.faturaIncluir(fatura);
                        }
                    } while (Integer.valueOf(sdfAnoMes.format(dataInicioContrato.getTime()).replaceAll("/", "")) <= Integer.valueOf(sdfAnoMes.format(dataAtual.getTime()).replaceAll("/", "")));
                } catch (ParseException ex) {
                    Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rs.close();
            stmt.close();
            return contratoArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

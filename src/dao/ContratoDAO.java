package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contrato;
import service.VeiculoService;

public class ContratoDAO {

    private Connection conexao;

    public ContratoDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List ContratoList(String clienteNome, String contratoTipo, String contratoStatus, String numeroContrato) {
        try {
            List<Contrato> contratoArrayList = new ArrayList<>();
            VeiculoService veiculoService = new VeiculoService();
            String sql = "SELECT * FROM contrato INNER JOIN cliente ON contrato.id_cliente_fk = cliente.id_cliente "
                    + "WHERE cliente.nome LIKE '%" + clienteNome + "%' AND contrato.tipo LIKE '%" + contratoTipo + "%' AND contrato.status LIKE '" + contratoStatus + "%' AND contrato.id_contrato LIKE '" + numeroContrato +"'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.getCliente().setIdCliente(rs.getInt("id_cliente"));
                contrato.getCliente().setDataInclusao(rs.getString("data_inclusao"));
                contrato.getCliente().setDataUltimaAlteracao(rs.getString("data_ultima_alteracao"));
                contrato.getCliente().setNome(rs.getString("nome"));
                contrato.getCliente().setCpf(rs.getString("cpf"));
                contrato.getCliente().setIdentidade(rs.getString("identidade"));
                contrato.getCliente().setTelefone(rs.getString("telefone"));
                contrato.getCliente().setCelular(rs.getString("celular"));
                contrato.getCliente().setEmail(rs.getString("email"));
                contrato.getCliente().setDataNascimento(rs.getString("data_nascimento"));
                contrato.getCliente().setCepResidencia(rs.getString("cep_residencia"));
                contrato.getCliente().setRuaResidencia(rs.getString("rua_residencia"));
                contrato.getCliente().setNumeroResidencia(rs.getString("numero_residencia"));
                contrato.getCliente().setComplementoResidencia(rs.getString("complemento_residencia"));
                contrato.getCliente().setBairroResidencia(rs.getString("bairro_residencia"));
                contrato.getCliente().setCidadeResidencia(rs.getString("cidade_residencia"));
                contrato.getCliente().setEstadoResidencia(rs.getString("estado_residencia"));
                contrato.getCliente().setEmpresa(rs.getString("empresa"));
                contrato.getCliente().setCepComercial(rs.getString("cep_comercial"));
                contrato.getCliente().setRuaComercial(rs.getString("rua_comercial"));
                contrato.getCliente().setNumeroComercial(rs.getString("numero_comercial"));
                contrato.getCliente().setComplementoComercial(rs.getString("complemento_comercial"));
                contrato.getCliente().setCidadeComercial(rs.getString("cidade_comercial"));
                contrato.getCliente().setEstadoComercial(rs.getString("estado_comercial"));
                contrato.getCliente().setTelefoneComercial(rs.getString("telefone_comercial"));
                //DADOS CONTRATO
                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setStatus(rs.getString("status"));
                contrato.setTipo(rs.getString("tipo"));
                contrato.setMedicao(rs.getString("medicao"));
                contrato.setQuantidade(rs.getInt("quantidade"));
                contrato.setDataInicio(rs.getString("data_inicio"));
                contrato.setDataTermino(rs.getString("data_termino"));
                contrato.setDiaVencimento(rs.getString("dia_vencimento"));
                contrato.setUltimaAlteracao(rs.getString("ultima_alteracao"));
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
                contrato.getCliente().setIdCliente(rs.getInt("id_cliente"));
                contrato.getCliente().setDataInclusao(rs.getString("data_inclusao"));
                contrato.getCliente().setDataUltimaAlteracao(rs.getString("data_ultima_alteracao"));
                contrato.getCliente().setNome(rs.getString("nome"));
                contrato.getCliente().setCpf(rs.getString("cpf"));
                contrato.getCliente().setIdentidade(rs.getString("identidade"));
                contrato.getCliente().setTelefone(rs.getString("telefone"));
                contrato.getCliente().setCelular(rs.getString("celular"));
                contrato.getCliente().setEmail(rs.getString("email"));
                contrato.getCliente().setDataNascimento(rs.getString("data_nascimento"));
                contrato.getCliente().setCepResidencia(rs.getString("cep_residencia"));
                contrato.getCliente().setRuaResidencia(rs.getString("rua_residencia"));
                contrato.getCliente().setNumeroResidencia(rs.getString("numero_residencia"));
                contrato.getCliente().setComplementoResidencia(rs.getString("complemento_residencia"));
                contrato.getCliente().setBairroResidencia(rs.getString("bairro_residencia"));
                contrato.getCliente().setCidadeResidencia(rs.getString("cidade_residencia"));
                contrato.getCliente().setEstadoResidencia(rs.getString("estado_residencia"));
                contrato.getCliente().setEmpresa(rs.getString("empresa"));
                contrato.getCliente().setCepComercial(rs.getString("cep_comercial"));
                contrato.getCliente().setRuaComercial(rs.getString("rua_comercial"));
                contrato.getCliente().setNumeroComercial(rs.getString("numero_comercial"));
                contrato.getCliente().setComplementoComercial(rs.getString("complemento_comercial"));
                contrato.getCliente().setCidadeComercial(rs.getString("cidade_comercial"));
                contrato.getCliente().setEstadoComercial(rs.getString("estado_comercial"));
                contrato.getCliente().setTelefoneComercial(rs.getString("telefone_comercial"));
                //DADOS CONTRATO
                contrato.setIdContrato(rs.getInt("id_contrato"));
                contrato.setStatus(rs.getString("status"));
                contrato.setTipo(rs.getString("tipo"));
                contrato.setMedicao(rs.getString("medicao"));
                contrato.setQuantidade(rs.getInt("quantidade"));
                contrato.setDataInicio(rs.getString("data_inicio"));
                contrato.setDataTermino(rs.getString("data_termino"));
                contrato.setDiaVencimento(rs.getString("dia_vencimento"));
                contrato.setUltimaAlteracao(rs.getString("ultima_alteracao"));
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
            String sql = "INSERT INTO contrato(id_cliente_fk, placa_1, placa_2, placa_3, placa_4, status, tipo, medicao, quantidade, data_inicio, data_termino, dia_vencimento, ultima_alteracao, valor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, contrato.getCliente().getIdCliente());
            stmt.setString(2, contrato.getVeiculo1().getPlaca());
            stmt.setString(3, contrato.getVeiculo2().getPlaca());
            stmt.setString(4, contrato.getVeiculo3().getPlaca());
            stmt.setString(5, contrato.getVeiculo4().getPlaca());
            stmt.setString(6, contrato.getStatus());
            stmt.setString(7, contrato.getTipo());
            stmt.setString(8, contrato.getMedicao());
            stmt.setInt(9, contrato.getQuantidade());
            stmt.setString(10, contrato.getDataInicio());
            stmt.setString(11, contrato.getDataTermino());
            stmt.setString(12, contrato.getDiaVencimento());
            stmt.setString(13, contrato.getUltimaAlteracao());
            stmt.setFloat(14, contrato.getValor());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                contrato.setIdContrato(resultSet.getInt("LAST_INSERT_ID()"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }
}

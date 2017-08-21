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
import modelo.Cliente;
import modelo.Contrato;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List clienteList(String clienteNome, String clienteCPF) {
        try {
            List<Cliente> clienteArrayList = new ArrayList<>();
            String sql = "SELECT * FROM cliente WHERE nome='%" + clienteNome + "%' AND cpf='%" + clienteCPF + "%'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setDataInclusao(rs.getString("data_inclusao"));
                cliente.setDataUltimaAlteracao(rs.getString("data_ultima_alteracao"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setIdentidade(rs.getString("identidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setCepResidencia(rs.getString("cep_residencia"));
                cliente.setRuaResidencia(rs.getString("rua_residencia"));
                cliente.setNumeroResidencia(rs.getString("numero_residencia"));
                cliente.setComplementoResidencia(rs.getString("complemento_residencia"));
                cliente.setBairroResidencia(rs.getString("bairro_residencia"));
                cliente.setCidadeResidencia(rs.getString("cidade_residencia"));
                cliente.setEstadoResidencia(rs.getString("estado_residencia"));
                cliente.setEmpresa(rs.getString("empresa"));
                cliente.setCepComercial(rs.getString("cep_comercial"));
                cliente.setRuaComercial(rs.getString("rua_comercial"));
                cliente.setNumeroComercial(rs.getString("numero_comercial"));
                cliente.setComplementoComercial(rs.getString("complemento_comercial"));
                cliente.setCidadeComercial(rs.getString("cidade_comercial"));
                cliente.setEstadoComercial(rs.getString("estado_comercial"));
                cliente.setTelefoneComercial(rs.getString("telefone_comercial"));
                clienteArrayList.add(cliente);
            }
            rs.close();
            stmt.close();
            return clienteArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Contrato clienteIncluir(Contrato contrato) {
        try {
            String sql = "INSERT INTO cliente(data_inclusao, data_ultima_alteracao, nome, cpf, identidade, telefone, celular, email, data_nascimento, cep_residencia, rua_residencia, numero_residencia, complemento_residencia, bairro_residencia, cidade_residencia, estado_residencia, empresa, cep_comercial, rua_comercial, numero_comercial, complemento_comercial, bairro_comercial, cidade_comercial, estado_comercial, telefone_comercial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, contrato.getCliente().getDataInclusao());
            stmt.setString(2, contrato.getCliente().getDataUltimaAlteracao());
            stmt.setString(3, contrato.getCliente().getNome());
            stmt.setString(4, contrato.getCliente().getCpf());
            stmt.setString(5, contrato.getCliente().getIdentidade());
            stmt.setString(6, contrato.getCliente().getTelefone());
            stmt.setString(7, contrato.getCliente().getCelular());
            stmt.setString(8, contrato.getCliente().getEmail());
            stmt.setString(9, contrato.getCliente().getDataNascimento());
            stmt.setString(10, contrato.getCliente().getCepResidencia());
            stmt.setString(11, contrato.getCliente().getRuaResidencia());
            stmt.setString(12, contrato.getCliente().getNumeroResidencia());
            stmt.setString(13, contrato.getCliente().getComplementoResidencia());
            stmt.setString(14, contrato.getCliente().getBairroResidencia());
            stmt.setString(15, contrato.getCliente().getCidadeResidencia());
            stmt.setString(16, contrato.getCliente().getEstadoResidencia());

            stmt.setString(17, contrato.getCliente().getEmpresa());
            stmt.setString(18, contrato.getCliente().getCepComercial());
            stmt.setString(19, contrato.getCliente().getRuaComercial());
            stmt.setString(20, contrato.getCliente().getNumeroComercial());
            stmt.setString(21, contrato.getCliente().getComplementoComercial());
            stmt.setString(22, contrato.getCliente().getBairroComercial());
            stmt.setString(23, contrato.getCliente().getCidadeComercial());
            stmt.setString(24, contrato.getCliente().getEstadoComercial());
            stmt.setString(25, contrato.getCliente().getTelefoneComercial());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                contrato.getCliente().setIdCliente(resultSet.getInt("LAST_INSERT_ID()"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }

    public Contrato clientaAlterar(Contrato contrato) {
        try {
            String sql = "UPDATE cliente SET data_ultima_alteracao=?, nome=?, cpf=?, identidade=?, telefone=?, celular=?, email=?, data_nascimento=?, cep_residencia=?, rua_residencia=?, numero_residencia=?, complemento_residencia=?, bairro_residencia=?, cidade_residencia=?, estado_residencia=?, "
                    + "empresa=?, cep_comercial=?, rua_comercial=?, numero_comercial=?, complemento_comercial=?, bairro_comercial=?, cidade_comercial=?, estado_comercial=?, telefone_comercial=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(2, contrato.getCliente().getDataUltimaAlteracao());
            stmt.setString(3, contrato.getCliente().getNome());
            stmt.setString(4, contrato.getCliente().getCpf());
            stmt.setString(5, contrato.getCliente().getIdentidade());
            stmt.setString(6, contrato.getCliente().getTelefone());
            stmt.setString(7, contrato.getCliente().getCelular());
            stmt.setString(8, contrato.getCliente().getEmail());
            stmt.setString(9, contrato.getCliente().getDataNascimento());
            stmt.setString(10, contrato.getCliente().getCepResidencia());
            stmt.setString(11, contrato.getCliente().getRuaResidencia());
            stmt.setString(12, contrato.getCliente().getNumeroResidencia());
            stmt.setString(13, contrato.getCliente().getComplementoResidencia());
            stmt.setString(14, contrato.getCliente().getBairroResidencia());
            stmt.setString(15, contrato.getCliente().getCidadeResidencia());
            stmt.setString(16, contrato.getCliente().getEstadoResidencia());

            stmt.setString(17, contrato.getCliente().getEmpresa());
            stmt.setString(18, contrato.getCliente().getCepComercial());
            stmt.setString(19, contrato.getCliente().getRuaComercial());
            stmt.setString(20, contrato.getCliente().getNumeroComercial());
            stmt.setString(21, contrato.getCliente().getComplementoComercial());
            stmt.setString(22, contrato.getCliente().getBairroComercial());
            stmt.setString(23, contrato.getCliente().getCidadeComercial());
            stmt.setString(24, contrato.getCliente().getEstadoComercial());
            stmt.setString(25, contrato.getCliente().getTelefoneComercial());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrato;
    }
}

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

    public Cliente clienteIncluir(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente(data_inclusao, data_ultima_alteracao, nome, cpf, identidade, telefone, celular, email, data_nascimento, cep_residencia, rua_residencia, numero_residencia, complemento_residencia, bairro_residencia, cidade_residencia, estado_residencia, empresa, cep_comercial, rua_comercial, numero_comercial, complemento_comercial, bairro_comercial, cidade_comercial, estado_comercial, telefone_comercial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getDataInclusao());
            stmt.setString(2, cliente.getDataUltimaAlteracao());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getIdentidade());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getCelular());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getDataNascimento());
            stmt.setString(10, cliente.getCepResidencia());
            stmt.setString(11, cliente.getRuaResidencia());
            stmt.setString(12, cliente.getNumeroResidencia());
            stmt.setString(13, cliente.getComplementoResidencia());
            stmt.setString(14, cliente.getBairroResidencia());
            stmt.setString(15, cliente.getCidadeResidencia());
            stmt.setString(16, cliente.getEstadoResidencia());

            stmt.setString(17, cliente.getEmpresa());
            stmt.setString(18, cliente.getCepComercial());
            stmt.setString(19, cliente.getRuaComercial());
            stmt.setString(20, cliente.getNumeroComercial());
            stmt.setString(21, cliente.getComplementoComercial());
            stmt.setString(22, cliente.getBairroComercial());
            stmt.setString(23, cliente.getCidadeComercial());
            stmt.setString(24, cliente.getEstadoComercial());
            stmt.setString(25, cliente.getTelefoneComercial());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getInt("LAST_INSERT_ID()"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public Cliente clientaAlterar(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET data_ultima_alteracao=?, nome=?, identidade=?, telefone=?, celular=?, email=?, data_nascimento=?, cep_residencia=?, rua_residencia=?, numero_residencia=?, complemento_residencia=?, bairro_residencia=?, cidade_residencia=?, estado_residencia=?, "
                    + "empresa=?, cep_comercial=?, rua_comercial=?, numero_comercial=?, complemento_comercial=?, bairro_comercial=?, cidade_comercial=?, estado_comercial=?, telefone_comercial=? WHERE id_cliente=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getDataUltimaAlteracao());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getIdentidade());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getDataNascimento());
            stmt.setString(8, cliente.getCepResidencia());
            stmt.setString(9, cliente.getRuaResidencia());
            stmt.setString(10, cliente.getNumeroResidencia());
            stmt.setString(11, cliente.getComplementoResidencia());
            stmt.setString(12, cliente.getBairroResidencia());
            stmt.setString(13, cliente.getCidadeResidencia());
            stmt.setString(14, cliente.getEstadoResidencia());

            stmt.setString(15, cliente.getEmpresa());
            stmt.setString(16, cliente.getCepComercial());
            stmt.setString(17, cliente.getRuaComercial());
            stmt.setString(18, cliente.getNumeroComercial());
            stmt.setString(19, cliente.getComplementoComercial());
            stmt.setString(20, cliente.getBairroComercial());
            stmt.setString(21, cliente.getCidadeComercial());
            stmt.setString(22, cliente.getEstadoComercial());
            stmt.setString(23, cliente.getTelefoneComercial());
            stmt.setInt(24, cliente.getIdCliente());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}

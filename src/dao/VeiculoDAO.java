package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Veiculo;

public class VeiculoDAO {

    private Connection conexao;

    public VeiculoDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public Veiculo veiculoIncluir(Veiculo veiculo) {
        try  {            
            String sql = "INSERT INTO veiculo(placa, data_hora_cadastro, data_hora_primeira_utilizacao, data_hora_ultima_alteracao, marca, modelo, cor, ano_modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getDataHoraCadastro());
            stmt.setString(3, veiculo.getDataHoraPrimeiraUtilizacao());
            stmt.setString(4, veiculo.getDataHoraUltimaAlteracao());
            stmt.setString(5, veiculo.getMarca());
            stmt.setString(6, veiculo.getModelo());            
            stmt.setString(7, veiculo.getCor());
            stmt.setString(8, veiculo.getAnoModelo());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                veiculo.setIdVeiculo(resultSet.getInt("LAST_INSERT_ID()"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }
    
    public Veiculo veiculoAlterar(Veiculo veiculo) {
        try  {            
            String sql = "UPDATE veiculo SET data_hora_primeira_utilizacao=?, data_hora_ultima_alteracao=?, marca=?, modelo=?, cor=?, ano_modelo=? WHERE placa=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getDataHoraPrimeiraUtilizacao());
            stmt.setString(2, veiculo.getDataHoraUltimaAlteracao());
            stmt.setString(3, veiculo.getMarca());
            stmt.setString(4, veiculo.getModelo());            
            stmt.setString(5, veiculo.getCor());
            stmt.setString(6, veiculo.getAnoModelo());
            stmt.setString(7, veiculo.getPlaca());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }
    
    public Veiculo veiculoIsCadastrado(String placaVeiculo) {
        Veiculo veiculo = new Veiculo();
        try {
            String sql = "SELECT * FROM veiculo WHERE placa='" + placaVeiculo + "'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDataHoraCadastro(rs.getString("data_hora_cadastro"));
                veiculo.setDataHoraPrimeiraUtilizacao(rs.getString("data_hora_primeira_utilizacao"));
                veiculo.setDataHoraUltimaAlteracao(rs.getString("data_hora_ultima_alteracao"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAnoModelo(rs.getString("ano_modelo"));
            } else {
                veiculo.setPlaca("");
            }
            rs.close();
            stmt.close();
            return veiculo;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

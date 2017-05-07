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

    public Veiculo cadastraVeiculo(Veiculo veiculo) {
        try  {            
            String sql = "INSERT INTO veiculo(placa, datahoraregistro, marca, modelo, anofabricacao, anomodelo, cor) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getDataHoraRegistro());
            stmt.setString(3, veiculo.getMarca());
            stmt.setString(4, veiculo.getModelo());
            stmt.setString(5, veiculo.getAnoFabricacao());
            stmt.setString(6, veiculo.getAnoModelo());
            stmt.setString(7, veiculo.getCor());
            stmt.executeUpdate();
            veiculo = verificaCadastroVeiculo(veiculo);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }

    public Veiculo verificaCadastroVeiculo(Veiculo veiculo) {
        try {
            String sql = "SELECT * FROM veiculo WHERE placa=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("placa"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return veiculo;
    }
}

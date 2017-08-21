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
import modelo.Fatura;

public class FaturaDAO {

    private Connection conexao;

    public FaturaDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List faturasContratoCliente(int numeroContratoCliente) {
        try {
            String sql = "SELECT * FROM fatura WHERE id_contrato_fk=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numeroContratoCliente);
            ResultSet rs = stmt.executeQuery();
            List<Fatura> faturaArrayList = new ArrayList<>();
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setIdFatura(rs.getInt("id_fatura"));
                fatura.setIdContratoFK(rs.getInt("id_contrato_fk"));
                fatura.setMesReferencia(rs.getString("mes_referencia"));
                fatura.setStatus(rs.getString("status"));
                faturaArrayList.add(fatura);
            }
            rs.close();
            stmt.close();
            return faturaArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

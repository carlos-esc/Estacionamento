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
                fatura.setPeriodo(rs.getString("periodo"));
                fatura.setVencimento(rs.getString("vencimento"));
                fatura.setValor(rs.getFloat("valor"));
                fatura.setDataPagamento(rs.getString("data_pagamento"));
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

    public boolean existeFaturaMesCorrente(int numeroContratoCliente, String mesReferencia) {
        try {
            String sql = "SELECT * FROM fatura WHERE id_contrato_fk=? AND mes_referencia=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numeroContratoCliente);
            stmt.setString(2, mesReferencia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rs.close();
                stmt.close();
                return true;
            } else {
                rs.close();
                stmt.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Fatura faturaIncluir(Fatura fatura) {
        try {
            String sql = "INSERT INTO fatura(id_contrato_fk, mes_referencia, periodo, vencimento, valor, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, fatura.getIdContratoFK());
            stmt.setString(2, fatura.getMesReferencia());
            stmt.setString(3, fatura.getPeriodo());
            stmt.setString(4, fatura.getVencimento());
            stmt.setFloat(5, fatura.getValor());
            stmt.setString(6, fatura.getStatus());
            stmt.executeUpdate();
            ResultSet rS = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (rS.next()) {
                fatura.setIdFatura(rS.getInt("LAST_INSERT_ID()"));
            }
            rS.close();
            stmt.close();
            return fatura;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

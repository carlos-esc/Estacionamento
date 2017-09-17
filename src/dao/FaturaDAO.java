package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fatura;

public class FaturaDAO {

    private Connection conexao;

    public FaturaDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List faturaPesquisaList(String idContrato, String mesReferencia, String vencimento, String dataPagamento, String valor, String status) {
        try {
            String movimentoFaturaPagaSQL = dataPagamento.substring(6, 10) + dataPagamento.substring(3, 5) + dataPagamento.substring(0, 2);
            System.out.println("movimentoFaturaPagaSQL: " + movimentoFaturaPagaSQL);
            String sql = "SELECT * FROM fatura WHERE id_contrato_fk LIKE ? AND mes_referencia LIKE ? AND vencimento LIKE ? AND DATE(data_pagamento)=? AND valor LIKE ? AND status LIKE ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, idContrato);
            stmt.setString(2, mesReferencia);
            stmt.setString(3, vencimento);
            stmt.setString(4, movimentoFaturaPagaSQL);
            stmt.setString(5, valor);
            stmt.setString(6, status);

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

    public void faturaPagamento(int idFatura) {
        try {
            String sql = "UPDATE fatura SET status=?, data_pagamento=? WHERE id_fatura=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "Paga");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            stmt.setString(2, sdf.format(new Date()));
            stmt.setInt(3, idFatura);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

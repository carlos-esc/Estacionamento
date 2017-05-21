package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import modelo.RotativoTipoPreco;

public class RotativoTipoPrecoDAO {

    private Connection conexao;
    
    public RotativoTipoPrecoDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }
    
    public void rotativoIncluirTipoPrecos(RotativoTipoPreco rotativoTipoPreco) {
        try {                         
            String sql = "INSERT INTO rotativotipopreco(tipo, preco30minutos, preco60minutos, precodemaisfracoes, precodiaria, precopernoite) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativoTipoPreco.getTipoRotativo());
            stmt.setFloat(2, rotativoTipoPreco.getPreco30Minutos());
            stmt.setFloat(3, rotativoTipoPreco.getPreco60Minutos());
            stmt.setFloat(4, rotativoTipoPreco.getPrecoDemaisFracoes());
            stmt.setFloat(5, rotativoTipoPreco.getPrecoDiaria());
            stmt.setFloat(6, rotativoTipoPreco.getPrecoPernoite());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void rotativoExcluirTipoPrecos(RotativoTipoPreco rotativoTipoPreco) {
        try {                         
            String sql = "DELETE FROM rotativotipopreco WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativoTipoPreco.getTipoRotativo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RotativoTipoPreco rotativoCarregarPrecos(RotativoTipoPreco rotativoTipoPreco) {
        try {
            String sql = "SELECT * FROM rotativotipopreco WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativoTipoPreco.getTipoRotativo());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rotativoTipoPreco.setPreco30Minutos(rs.getFloat("preco30minutos"));
                rotativoTipoPreco.setPreco60Minutos(rs.getFloat("preco60minutos"));
                rotativoTipoPreco.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                rotativoTipoPreco.setPrecoDiaria(rs.getFloat("precodiaria"));
                rotativoTipoPreco.setPrecoPernoite(rs.getFloat("precopernoite"));
            } else {
                System.out.println("O tipo de rotativo não foi encontrado!!!");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativoTipoPreco;
    }

    public void rotativoAlterarPrecos(String rotativoTipoAnterior, RotativoTipoPreco rotativoTipoPreco) {
        try {
            String sql = "UPDATE rotativotipopreco SET tipo=?, preco30minutos=?, preco60minutos=?, precodemaisfracoes=?, precodiaria=?, precopernoite=? WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativoTipoPreco.getTipoRotativo());
            stmt.setFloat(2, rotativoTipoPreco.getPreco30Minutos());
            stmt.setFloat(3, rotativoTipoPreco.getPreco60Minutos());
            stmt.setFloat(4, rotativoTipoPreco.getPrecoDemaisFracoes());
            stmt.setFloat(5, rotativoTipoPreco.getPrecoDiaria());
            stmt.setFloat(6, rotativoTipoPreco.getPrecoPernoite());
            stmt.setString(7, rotativoTipoAnterior);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("As alterações do [" + rotativoTipoPreco.getTipoRotativo() + "] foram atualizados com sucesso!!!");
            } else {
                System.out.println("O [" + rotativoTipoPreco.getTipoRotativo() + "] não existe!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultListModel rotativoCarregarTipos(DefaultListModel rotativoTipoLista) {
        try {
            String sql = "SELECT tipo FROM rotativotipopreco";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                rotativoTipoLista.add(i, rs.getString("tipo"));
                i++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativoTipoLista;
    }

    public List rotativoCarregarTipoPrecoLista(List rotativoTipoPrecoLista) {
        try {
            String sql = "SELECT * FROM rotativotipopreco";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RotativoTipoPreco rotativoTipoPreco = new RotativoTipoPreco();
                rotativoTipoPreco.setIdRotativo(rs.getInt("id_rotativo"));
                rotativoTipoPreco.setTipoRotativo(rs.getString("tipo"));
                rotativoTipoPreco.setPreco30Minutos(rs.getFloat("preco30minutos"));
                rotativoTipoPreco.setPreco60Minutos(rs.getFloat("preco60minutos"));
                rotativoTipoPreco.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                rotativoTipoPreco.setPrecoDiaria(rs.getFloat("precodiaria"));
                rotativoTipoPreco.setPrecoPernoite(rs.getFloat("precopernoite"));
                rotativoTipoPrecoLista.add(rotativoTipoPreco);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativoTipoPrecoLista;
    }
}
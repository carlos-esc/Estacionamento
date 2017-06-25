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
import modelo.Rotativo;

public class RotativoDAO {

    private Connection conexao;
    
    public RotativoDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }
    
    public void rotativoIncluir(Rotativo rotativo) {
        try {                         
            String sql = "INSERT INTO rotativo(tipo, preco30minutos, preco60minutos, precodemaisfracoes, precodiaria, precopernoite) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getNome());
            stmt.setFloat(2, rotativo.getPreco30Minutos());
            stmt.setFloat(3, rotativo.getPreco60Minutos());
            stmt.setFloat(4, rotativo.getPrecoDemaisFracoes());
            stmt.setFloat(5, rotativo.getPrecoDiaria());
            stmt.setFloat(6, rotativo.getPrecoPernoite());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void rotativoExcluir(Rotativo rotativo) {
        try {                         
            String sql = "DELETE FROM rotativo WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getNome());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Rotativo rotativoCarregarAtributos(Rotativo rotativo) {
        try {
            String sql = "SELECT * FROM rotativo WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rotativo.setIdRotativo(rs.getInt("id_rotativo"));
                rotativo.setPreco30Minutos(rs.getFloat("preco30minutos"));
                rotativo.setPreco60Minutos(rs.getFloat("preco60minutos"));
                rotativo.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                rotativo.setPrecoDiaria(rs.getFloat("precodiaria"));
                rotativo.setPrecoPernoite(rs.getFloat("precopernoite"));
            } else {
                System.out.println("O tipo de rotativo não foi encontrado!!!");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativo;
    }

    public void rotativoAlterar(String rotativoTipoAnterior, Rotativo rotativo) {
        try {
            String sql = "UPDATE rotativo SET tipo=?, preco30minutos=?, preco60minutos=?, precodemaisfracoes=?, precodiaria=?, precopernoite=? WHERE tipo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getNome());
            stmt.setFloat(2, rotativo.getPreco30Minutos());
            stmt.setFloat(3, rotativo.getPreco60Minutos());
            stmt.setFloat(4, rotativo.getPrecoDemaisFracoes());
            stmt.setFloat(5, rotativo.getPrecoDiaria());
            stmt.setFloat(6, rotativo.getPrecoPernoite());
            stmt.setString(7, rotativoTipoAnterior);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("As alterações do [" + rotativo.getNome() + "] foram atualizados com sucesso!!!");
            } else {
                System.out.println("O [" + rotativo.getNome() + "] não existe!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultListModel rotativoCarregarLista(DefaultListModel rotativoDefaultListModel) {
        try {
            String sql = "SELECT tipo FROM rotativo";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                rotativoDefaultListModel.add(i, rs.getString("tipo"));
                i++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativoDefaultListModel;
    }

    public List rotativoCarregarListaTodos(List rotativoList) {
        try {
            String sql = "SELECT * FROM rotativo";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Rotativo rotativo = new Rotativo();
                rotativo.setIdRotativo(rs.getInt("id_rotativo"));
                rotativo.setNome(rs.getString("tipo"));
                rotativo.setPreco30Minutos(rs.getFloat("preco30minutos"));
                rotativo.setPreco60Minutos(rs.getFloat("preco60minutos"));
                rotativo.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                rotativo.setPrecoDiaria(rs.getFloat("precodiaria"));
                rotativo.setPrecoPernoite(rs.getFloat("precopernoite"));
                rotativoList.add(rotativo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rotativoList;
    }
}
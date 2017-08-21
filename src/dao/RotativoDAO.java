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
            String sql = "INSERT INTO rotativo(tipo, nome, preco30minutos, preco60minutos, precodemaisfracoes, precodiaria, precopernoite) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getTipo());
            stmt.setString(2, rotativo.getNome());
            stmt.setFloat(3, rotativo.getPreco30Minutos());
            stmt.setFloat(4, rotativo.getPreco60Minutos());
            stmt.setFloat(5, rotativo.getPrecoDemaisFracoes());
            stmt.setFloat(6, rotativo.getPrecoDiaria());
            stmt.setFloat(7, rotativo.getPrecoPernoite());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void rotativoExcluir(Rotativo rotativo) {
        try {                         
            String sql = "DELETE FROM rotativo WHERE nome=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, rotativo.getNome());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Rotativo rotativoCarregarAtributos(String nomeRotativo) {
        try {
            String sql = "SELECT * FROM rotativo WHERE nome=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeRotativo);
            ResultSet rs = stmt.executeQuery();
            Rotativo rotativo = new Rotativo();
            if (rs.next()) {
                rotativo.setNome(rs.getString("nome"));
                rotativo.setTipo(rs.getString("tipo"));
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
            return rotativo;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void rotativoAlterar(String rotativoTipoAnterior, Rotativo rotativo) {
        try {
            String sql = "UPDATE rotativo SET nome=?, preco30minutos=?, preco60minutos=?, precodemaisfracoes=?, precodiaria=?, precopernoite=? WHERE nome=?";
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
            String sql = "SELECT nome FROM rotativo";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                rotativoDefaultListModel.add(i, rs.getString("nome"));
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
                rotativo.setNome(rs.getString("nome"));
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
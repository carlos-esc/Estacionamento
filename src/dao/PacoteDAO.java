package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pacote;

public class PacoteDAO {

    private Connection conexao;

    public PacoteDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List pacoteCarregarLista(List pacoteArrayList) {
        try {
            String sql = "SELECT * FROM pacote";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pacote pacote = new Pacote();
                pacote.setIdPacote(rs.getInt("id_pacote"));
                pacote.setNome(rs.getString("nome"));
                pacote.setUtilizacoesOuDias(rs.getString("utilizacoesoudias"));
                pacote.setQuantidade(rs.getInt("quantidade"));
                pacote.setDataInicio(rs.getString("datainicio"));
                pacote.setDataTermino(rs.getString("datatermino"));
                pacote.setValor(rs.getFloat("valor"));
                pacoteArrayList.add(pacote);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacoteArrayList;
    }
    
    public Pacote pacoteCarregarAtributos(Pacote pacote) {
        try {
            String sql = "SELECT * FROM pacote WHERE nome=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pacote.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pacote.setIdPacote(rs.getInt("id_pacote"));
                pacote.setNome(rs.getString("nome"));
                pacote.setUtilizacoesOuDias(rs.getString("utilizacoesoudias"));
                pacote.setQuantidade(rs.getInt("quantidade"));
                pacote.setDataInicio(rs.getString("datainicio"));
                pacote.setDataTermino(rs.getString("datatermino"));
                pacote.setValor(rs.getFloat("valor"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacote;
    }
    
    public void pacoteIncluir(Pacote pacote) {
        try {                         
            String sql = "INSERT INTO pacote(nome, utilizacoesoudias, quantidade, datainicio, datatermino, valor) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pacote.getNome());
            stmt.setString(2, pacote.getUtilizacoesOuDias());
            stmt.setInt(3, pacote.getQuantidade());
            stmt.setString(4, "00/00/0000");
            stmt.setString(5, "00/00/0000");
            stmt.setFloat(6, pacote.getValor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pacoteExcluir(Pacote pacote) {
        try {                         
            String sql = "DELETE FROM pacote WHERE nome=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pacote.getNome());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pacoteAlterar(String pacoteNomeAnterior, Pacote pacote) {
        try {
            String sql = "UPDATE pacote SET nome=?, utilizacoesoudias=?, quantidade=?, valor=? WHERE nome=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pacote.getNome());
            stmt.setString(2, pacote.getUtilizacoesOuDias());
            stmt.setInt(3, pacote.getQuantidade());
            stmt.setFloat(4, pacote.getValor());
            stmt.setString(5, pacoteNomeAnterior);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("As alterações do [" + pacote.getNome() + "] foram atualizados com sucesso!!!");
            } else {
                System.out.println("O [" + pacote.getNome() + "] não existe!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
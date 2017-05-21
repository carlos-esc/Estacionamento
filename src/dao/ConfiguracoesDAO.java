package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Configuracoes;

public class ConfiguracoesDAO {

    private Connection conexao;
    private SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    public ConfiguracoesDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }
    
    public Configuracoes configuracoesCarregarTodos(Configuracoes configuracoes) {
        try {
            String sql = "SELECT * FROM configuracoes";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                configuracoes.setToleranciaDesistencia(rs.getInt("tolerancia_desistencia"));
                configuracoes.setToleranciaFracoes(rs.getInt("tolerancia_fracoes"));
                configuracoes.setDiariaHora(rs.getInt("diaria_hora"));
                configuracoes.setDiariaMinuto(rs.getInt("diaria_minuto"));
                configuracoes.setPernoiteInicio(rs.getString("pernoite_inicio"));
                configuracoes.setPernoiteTermino(rs.getString("pernoite_termino"));
            } else {
                System.out.println("Não foi encontrado nenhuma tolerância configurada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configuracoes;
    }
    
    public Configuracoes configuracoesCarregarTolerancia(Configuracoes configuracoes) {
        try {
            String sql = "SELECT tolerancia_desistencia, tolerancia_fracoes FROM configuracoes";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                configuracoes.setToleranciaDesistencia(rs.getInt("tolerancia_desistencia"));
                configuracoes.setToleranciaFracoes(rs.getInt("tolerancia_fracoes"));
            } else {
                System.out.println("Não foi encontrado nenhuma tolerância configurada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configuracoes;
    }

    public void configuracoesAlterarTolerancia(Configuracoes configuracoes) {
        try {
            String sql = "UPDATE configuracoes SET tolerancia_desistencia=?, tolerancia_fracoes=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, configuracoes.getToleranciaDesistencia());
            stmt.setInt(2, configuracoes.getToleranciaFracoes());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A tolerância para desistência foi alterada para:[" + configuracoes.getToleranciaDesistencia() + "] minutos");
                System.out.println("A tolerância entre frações foi alterada para:[" + configuracoes.getToleranciaFracoes() + "] minutos");
            } else {
                System.out.println("Não existem tolerâncias a serem modificadas!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Configuracoes configuracoesCarregarDiaria(Configuracoes configuracoes) {
        try {
            String sql = "SELECT diaria_hora, diaria_minuto FROM configuracoes";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                configuracoes.setDiariaHora(rs.getInt("diaria_hora"));
                configuracoes.setDiariaMinuto(rs.getInt("diaria_minuto"));
            } else {
                System.out.println("Não foi encontrado nenhuma diária configurada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configuracoes;
    }

    public void configuracoesAlterarDiaria(Configuracoes configuracoes) {
        try {
            String sql = "UPDATE configuracoes SET diaria_hora=?, diaria_minuto=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, configuracoes.getDiariaHora());
            stmt.setInt(2, configuracoes.getDiariaMinuto());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A diária foi alterada para:[" + configuracoes.getDiariaHora() + "] horas e [" + configuracoes.getDiariaMinuto() + "] minutos");
            } else {
                System.out.println("Não existe diária a ser modificada!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Configuracoes configuracoesCarregarPernoite(Configuracoes configuracoes) {
        try {
            String sql = "SELECT pernoite_inicio, pernoite_termino FROM configuracoes";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                configuracoes.setPernoiteInicio(rs.getString("pernoite_inicio"));
                configuracoes.setPernoiteTermino(rs.getString("pernoite_termino"));
            } else {
                System.out.println("Não foi encontrado nenhum pernoite configurada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configuracoes;
    }

    public void configuracoesAlterarPernoite(Configuracoes configuracoes) {
        try {
            String sql = "UPDATE configuracoes SET pernoite_inicio=?, pernoite_termino=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, configuracoes.getPernoiteInicio());
            stmt.setString(2, configuracoes.getPernoiteTermino());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("O pernoite foi alterado para: Inicio[" + configuracoes.getPernoiteInicio() + "] Término[" + configuracoes.getPernoiteTermino() + "]");
            } else {
                System.out.println("Não existe pernoite a ser modificada!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

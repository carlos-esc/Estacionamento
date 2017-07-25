package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Mensalista;

public class MensalistaDAO {

    private Connection conexao;

    public MensalistaDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List mensalistaCarregarPesquisa(List mensalistaList, String mensalistaNomePesquisa) {
        try {
            String sql = "SELECT * FROM mensalista WHERE nome like '%" + mensalistaNomePesquisa + "%'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mensalista mensalista = new Mensalista();
                mensalista.setNumeroDoContrato(rs.getInt("numerodocontrato"));
                mensalista.setDataInclusao(rs.getString("datainclusao"));
                mensalista.setDiaVencimentoMensalidade(rs.getString("diavencimentomensalidade"));
                mensalista.setDataUltimaAlteracao(rs.getString("dataultimaalteracao"));
                mensalista.setStatus(rs.getString("status"));
                mensalista.setNome(rs.getString("nome"));
                mensalista.setCpf(rs.getString("cpf"));
                mensalista.setIdentidade(rs.getString("identidade"));
                mensalista.setTelefone(rs.getString("telefone"));
                mensalista.setCelular(rs.getString("celular"));
                mensalista.setEmail(rs.getString("email"));
                mensalista.setDataNascimento(rs.getString("datanascimento"));
                mensalista.setCepResi(rs.getString("cepresi"));
                mensalista.setRuaResi(rs.getString("ruaresi"));
                mensalista.setNumeroResi(rs.getString("numeroresi"));
                mensalista.setBairroResi(rs.getString("bairroresi"));
                mensalista.setCidadeResi(rs.getString("cidaderesi"));
                mensalista.setEstadoResi(rs.getString("estadoresi"));
                mensalista.setComplementoResi(rs.getString("complementoresi"));
                mensalista.setEmpresa(rs.getString("empresa"));
                mensalista.setCepCome(rs.getString("cepcome"));
                mensalista.setRuaCome(rs.getString("ruacome"));
                mensalista.setNumeroCome(rs.getString("numerocome"));
                mensalista.setBairroCome(rs.getString("bairrocome"));
                mensalista.setCidadeCome(rs.getString("cidadecome"));
                mensalista.setEstadoCome(rs.getString("estadocome"));
                mensalista.setComplementoCome(rs.getString("complementocome"));
                mensalista.setTelefoneCome(rs.getString("telefonecome"));
                mensalista.setPlaca01(rs.getString("placa01"));
                mensalista.setMontadora01(rs.getString("montadora01"));
                mensalista.setModelo01(rs.getString("modelo01"));
                mensalista.setCor01(rs.getString("cor01"));
                mensalista.setAno01(rs.getString("ano01"));
                mensalista.setPlaca02(rs.getString("placa02"));
                mensalista.setMontadora02(rs.getString("montadora02"));
                mensalista.setModelo02(rs.getString("modelo02"));
                mensalista.setCor02(rs.getString("cor02"));
                mensalista.setAno02(rs.getString("ano02"));
                mensalista.setPlaca03(rs.getString("placa03"));
                mensalista.setMontadora03(rs.getString("montadora03"));
                mensalista.setModelo03(rs.getString("modelo03"));
                mensalista.setCor03(rs.getString("cor03"));
                mensalista.setAno03(rs.getString("ano03"));
                mensalista.setPlaca04(rs.getString("placa04"));
                mensalista.setMontadora04(rs.getString("montadora04"));
                mensalista.setModelo04(rs.getString("modelo04"));
                mensalista.setCor04(rs.getString("cor04"));
                mensalista.setAno04(rs.getString("ano04"));
                mensalistaList.add(mensalista);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensalistaList;
    }

    public Mensalista mensalistaCarregarAtributos(Mensalista mensalista) {
        try {
            String sql = "SELECT * FROM mensalista WHERE numerodocontrato=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, mensalista.getNumeroDoContrato());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mensalista.setNumeroDoContrato(rs.getInt("numerodocontrato"));
                mensalista.setDataInclusao(rs.getString("datainclusao"));
                mensalista.setDiaVencimentoMensalidade(rs.getString("diavencimentomensalidade"));
                mensalista.setDataUltimaAlteracao(rs.getString("dataultimaalteracao"));
                mensalista.setStatus(rs.getString("status"));
                mensalista.setNome(rs.getString("nome"));
                mensalista.setCpf(rs.getString("cpf"));
                mensalista.setIdentidade(rs.getString("identidade"));
                mensalista.setTelefone(rs.getString("telefone"));
                mensalista.setCelular(rs.getString("celular"));
                mensalista.setEmail(rs.getString("email"));
                mensalista.setDataNascimento(rs.getString("datanascimento"));
                mensalista.setCepResi(rs.getString("cepresi"));
                mensalista.setRuaResi(rs.getString("ruaresi"));
                mensalista.setNumeroResi(rs.getString("numeroresi"));
                mensalista.setBairroResi(rs.getString("bairroresi"));
                mensalista.setCidadeResi(rs.getString("cidaderesi"));
                mensalista.setEstadoResi(rs.getString("estadoresi"));
                mensalista.setComplementoResi(rs.getString("complementoresi"));
                mensalista.setEmpresa(rs.getString("empresa"));
                mensalista.setCepCome(rs.getString("cepcome"));
                mensalista.setRuaCome(rs.getString("ruacome"));
                mensalista.setNumeroCome(rs.getString("numerocome"));
                mensalista.setBairroCome(rs.getString("bairrocome"));
                mensalista.setCidadeCome(rs.getString("cidadecome"));
                mensalista.setEstadoCome(rs.getString("estadocome"));
                mensalista.setComplementoCome(rs.getString("complementocome"));
                mensalista.setTelefoneCome(rs.getString("telefonecome"));
                mensalista.setPlaca01(rs.getString("placa01"));
                mensalista.setMontadora01(rs.getString("montadora01"));
                mensalista.setModelo01(rs.getString("modelo01"));
                mensalista.setCor01(rs.getString("cor01"));
                mensalista.setAno01(rs.getString("ano01"));
                mensalista.setPlaca02(rs.getString("placa02"));
                mensalista.setMontadora02(rs.getString("montadora02"));
                mensalista.setModelo02(rs.getString("modelo02"));
                mensalista.setCor02(rs.getString("cor02"));
                mensalista.setAno02(rs.getString("ano02"));
                mensalista.setPlaca03(rs.getString("placa03"));
                mensalista.setMontadora03(rs.getString("montadora03"));
                mensalista.setModelo03(rs.getString("modelo03"));
                mensalista.setCor03(rs.getString("cor03"));
                mensalista.setAno03(rs.getString("ano03"));
                mensalista.setPlaca04(rs.getString("placa04"));
                mensalista.setMontadora04(rs.getString("montadora04"));
                mensalista.setModelo04(rs.getString("modelo04"));
                mensalista.setCor04(rs.getString("cor04"));
                mensalista.setAno04(rs.getString("ano04"));
            } else {
                mensalista.setNumeroDoContrato(0);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensalista;
    }

    public Mensalista mensalistaIncluir(Mensalista mensalista) {
        try {
            String sql = "INSERT INTO mensalista(datainclusao, diavencimentomensalidade, dataultimaalteracao, status, nome, cpf, identidade, telefone, celular, email, datanascimento, cepresi, ruaresi, numeroresi, complementoresi, bairroresi, cidaderesi, estadoresi, "
                    + "empresa, cepcome, ruacome, numerocome, complementocome, bairrocome, cidadecome, estadocome, telefonecome, "
                    + "placa01, montadora01, modelo01, cor01, ano01, placa02, montadora02, modelo02, cor02, ano02, placa03, montadora03, modelo03, cor03, ano03, placa04, montadora04, modelo04, cor04, ano04) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mensalista.getDataInclusao());
            stmt.setString(2, mensalista.getDiaVencimentoMensalidade());
            stmt.setString(3, mensalista.getDataUltimaAlteracao());
            stmt.setString(4, mensalista.getStatus());
            stmt.setString(5, mensalista.getNome());
            stmt.setString(6, mensalista.getCpf());
            stmt.setString(7, mensalista.getIdentidade());
            stmt.setString(8, mensalista.getTelefone());
            stmt.setString(9, mensalista.getCelular());
            stmt.setString(10, mensalista.getEmail());
            stmt.setString(11, mensalista.getDataNascimento());
            stmt.setString(12, mensalista.getCepResi());
            stmt.setString(13, mensalista.getRuaResi());
            stmt.setString(14, mensalista.getNumeroResi());
            stmt.setString(15, mensalista.getComplementoResi());
            stmt.setString(16, mensalista.getBairroResi());
            stmt.setString(17, mensalista.getCidadeResi());
            stmt.setString(18, mensalista.getEstadoResi());

            stmt.setString(19, mensalista.getEmpresa());
            stmt.setString(20, mensalista.getCepCome());
            stmt.setString(21, mensalista.getRuaCome());
            stmt.setString(22, mensalista.getNumeroCome());
            stmt.setString(23, mensalista.getComplementoCome());
            stmt.setString(24, mensalista.getBairroCome());
            stmt.setString(25, mensalista.getCidadeCome());
            stmt.setString(26, mensalista.getEstadoCome());
            stmt.setString(27, mensalista.getTelefoneCome());

            stmt.setString(28, mensalista.getPlaca01());
            stmt.setString(29, mensalista.getMontadora01());
            stmt.setString(30, mensalista.getModelo01());
            stmt.setString(31, mensalista.getCor01());
            stmt.setString(32, mensalista.getAno01());
            stmt.setString(33, mensalista.getPlaca02());
            stmt.setString(34, mensalista.getMontadora02());
            stmt.setString(35, mensalista.getModelo02());
            stmt.setString(36, mensalista.getCor02());
            stmt.setString(37, mensalista.getAno02());
            stmt.setString(38, mensalista.getPlaca03());
            stmt.setString(39, mensalista.getMontadora03());
            stmt.setString(40, mensalista.getModelo03());
            stmt.setString(41, mensalista.getCor03());
            stmt.setString(42, mensalista.getAno03());
            stmt.setString(43, mensalista.getPlaca04());
            stmt.setString(44, mensalista.getMontadora04());
            stmt.setString(45, mensalista.getModelo04());
            stmt.setString(46, mensalista.getCor04());
            stmt.setString(47, mensalista.getAno04());
            stmt.executeUpdate();
            
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                mensalista.setNumeroDoContrato(resultSet.getInt("LAST_INSERT_ID()"));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensalista;
    }

    public Mensalista mensalistaAlterar(Mensalista mensalista) {
        try {
            String sql = "UPDATE mensalista SET datainclusao=?, diavencimentomensalidade=?, dataultimaalteracao=?, status=?, nome=?, cpf=?, identidade=?, telefone=?, celular=?, email=?, datanascimento=?, cepresi=?, ruaresi=?, numeroresi=?, complementoresi=?, bairroresi=?, cidaderesi=?, estadoresi=?, "
                    + "empresa=?, cepcome=?, ruacome=?, numerocome=?, complementocome=?, bairrocome=?, cidadecome=?, estadocome=?, telefonecome=?, "
                    + "placa01=?, montadora01=?, modelo01=?, cor01=?, ano01=?, placa02=?, montadora02=?, modelo02=?, cor02=?, ano02=?, placa03=?, montadora03=?, modelo03=?, cor03=?, ano03=?, placa04=?, montadora04=?, modelo04=?, cor04=?, ano04=? WHERE numerodocontrato=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mensalista.getDataInclusao());
            stmt.setString(2, mensalista.getDiaVencimentoMensalidade());
            stmt.setString(3, mensalista.getDataUltimaAlteracao());
            stmt.setString(4, mensalista.getStatus());
            stmt.setString(5, mensalista.getNome());
            stmt.setString(6, mensalista.getCpf());
            stmt.setString(7, mensalista.getIdentidade());
            stmt.setString(8, mensalista.getTelefone());
            stmt.setString(9, mensalista.getCelular());
            stmt.setString(10, mensalista.getEmail());
            stmt.setString(11, mensalista.getDataNascimento());
            stmt.setString(12, mensalista.getCepResi());
            stmt.setString(13, mensalista.getRuaResi());
            stmt.setString(14, mensalista.getNumeroResi());
            stmt.setString(15, mensalista.getComplementoResi());
            stmt.setString(16, mensalista.getBairroResi());
            stmt.setString(17, mensalista.getCidadeResi());
            stmt.setString(18, mensalista.getEstadoResi());

            stmt.setString(19, mensalista.getEmpresa());
            stmt.setString(20, mensalista.getCepCome());
            stmt.setString(21, mensalista.getRuaCome());
            stmt.setString(22, mensalista.getNumeroCome());
            stmt.setString(23, mensalista.getComplementoCome());
            stmt.setString(24, mensalista.getBairroCome());
            stmt.setString(25, mensalista.getCidadeCome());
            stmt.setString(26, mensalista.getEstadoCome());
            stmt.setString(27, mensalista.getTelefoneCome());

            stmt.setString(28, mensalista.getPlaca01());
            stmt.setString(29, mensalista.getMontadora01());
            stmt.setString(30, mensalista.getModelo01());
            stmt.setString(31, mensalista.getCor01());
            stmt.setString(32, mensalista.getAno01());
            stmt.setString(33, mensalista.getPlaca02());
            stmt.setString(34, mensalista.getMontadora02());
            stmt.setString(35, mensalista.getModelo02());
            stmt.setString(36, mensalista.getCor02());
            stmt.setString(37, mensalista.getAno02());
            stmt.setString(38, mensalista.getPlaca03());
            stmt.setString(39, mensalista.getMontadora03());
            stmt.setString(40, mensalista.getModelo03());
            stmt.setString(41, mensalista.getCor03());
            stmt.setString(42, mensalista.getAno03());
            stmt.setString(43, mensalista.getPlaca04());
            stmt.setString(44, mensalista.getMontadora04());
            stmt.setString(45, mensalista.getModelo04());
            stmt.setString(46, mensalista.getCor04());
            stmt.setString(47, mensalista.getAno04());
            stmt.setInt(48, mensalista.getNumeroDoContrato());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensalista;
    }
}

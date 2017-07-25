package dao;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Patio;
import calculo.RotativoCalculoSaida;
import java.text.ParseException;

public class PatioDAO {

    private Connection conexao;
    //RotativoCalculaSaida rotativoCalculaSaida = new RotativoCalculaSaida();

    public PatioDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List movimentoLista(List movimentoLista, String movimentoData) {
        try {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            String sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            RotativoCalculoSaida rotativoCalculaSaida = new RotativoCalculoSaida();
            Date patioDataEntrada, patioDataSaida, movimentoDataPesquisa;
            movimentoDataPesquisa = sdfData.parse(movimentoData);
            while (rs.next()) {
                patioDataEntrada = sdfData.parse(rs.getString("dataentrada"));
                if (patioDataEntrada.getTime() > movimentoDataPesquisa.getTime()) {

                } else {
                    if (patioDataEntrada.getTime() <= movimentoDataPesquisa.getTime() && rs.getString("datasaida") == null) {
                        patioDataSaida = new Date();
                    } else {
                        patioDataSaida = sdfData.parse(rs.getString("datasaida"));
                    }
                    if (patioDataSaida.getTime() >= movimentoDataPesquisa.getTime()) {
                        Patio patio = new Patio();
                        patio.setDataSaida(sdfData.format(new Date()));
                        patio.setHoraSaida(sdfHora.format(new Date()));

                        patio.setPlacaFk(rs.getString("placa"));
                        patio.setPrisma(rs.getString("prisma"));
                        patio.setRps(rs.getString("rps"));
                        patio.setTipo(rs.getString("tipo"));
                        patio.setPreco30Minutos(rs.getFloat("preco30minutos"));
                        patio.setPreco60Minutos(rs.getFloat("preco60minutos"));
                        patio.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                        patio.setPrecoDiaria(rs.getFloat("precodiaria"));
                        patio.setPrecoPernoite(rs.getFloat("precopernoite"));
                        patio.setDataEntrada(rs.getString("dataentrada"));
                        patio.setHoraEntrada(rs.getString("horaentrada"));
                        patio.setToleranciaDesistencia(rs.getInt("toleranciadesistencia"));
                        patio.setToleranciaEntreFracoes(rs.getInt("toleranciaentrefracoes"));
                        patio.setDiariaHoras(rs.getInt("diariahoras"));
                        patio.setDiariaMinutos(rs.getInt("diariaminutos"));
                        patio.setPernoiteInicio(rs.getString("pernoiteinicio"));
                        patio.setPernoiteTermino(rs.getString("pernoitetermino"));

                        if (rs.getString("datasaida") != null) {
                            patio.setDataSaida(rs.getString("datasaida"));
                            patio.setHoraSaida(rs.getString("horasaida"));
                            patio.setPermanencia(rs.getString("permanencia"));
                            patio.setValorTotal(rs.getFloat("valortotal"));
                        } else {
                            patio = rotativoCalculaSaida.calcularPermanenciaValor(patio);
                            patio.setDataSaida("Veículo no");
                            patio.setHoraSaida("pátio");
                        }
                        movimentoLista.add(patio);
                    }
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movimentoLista;
    }

    public List patioLista(List patioLista, String patioOrdenarLista) {
        try {
            SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm");
            String sql = "";
            switch (patioOrdenarLista) {
                case "entrada":
                    sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo) WHERE patio.estacionado='sim'";
                    break;
                case "placa":
                    sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo) WHERE patio.estacionado='sim' ORDER BY placa ASC";
                    break;
                case "prisma":
                    sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo) WHERE patio.estacionado='sim' ORDER BY prisma * 1 ASC";
                    break;
                case "tipo":
                    sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo) WHERE patio.estacionado='sim' ORDER BY tipo ASC";
                    break;
                default:
                    sql = "SELECT * FROM patio INNER JOIN veiculo ON (patio.id_veiculo_fk = veiculo.id_veiculo) WHERE patio.estacionado='sim'";
                    break;
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            RotativoCalculoSaida rotativoCalculaSaida = new RotativoCalculoSaida();
            while (rs.next()) {
                Patio patio = new Patio();
                patio.setDataSaida(dataAtual.format(new Date()));
                patio.setHoraSaida(horaAtual.format(new Date()));

                patio.setPlacaFk(rs.getString("placa"));
                patio.setPrisma(rs.getString("prisma"));
                patio.setRps(rs.getString("rps"));
                patio.setTipo(rs.getString("tipo"));
                patio.setPreco30Minutos(rs.getFloat("preco30minutos"));
                patio.setPreco60Minutos(rs.getFloat("preco60minutos"));
                patio.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                patio.setPrecoDiaria(rs.getFloat("precodiaria"));
                patio.setPrecoPernoite(rs.getFloat("precopernoite"));
                patio.setDataEntrada(rs.getString("dataentrada"));
                patio.setHoraEntrada(rs.getString("horaentrada"));
                patio.setToleranciaDesistencia(rs.getInt("toleranciadesistencia"));
                patio.setToleranciaEntreFracoes(rs.getInt("toleranciaentrefracoes"));
                patio.setDiariaHoras(rs.getInt("diariahoras"));
                patio.setDiariaMinutos(rs.getInt("diariaminutos"));
                patio.setPernoiteInicio(rs.getString("pernoiteinicio"));
                patio.setPernoiteTermino(rs.getString("pernoitetermino"));

                if (rs.getString("datasaida") != null) {
                    patio.setDataSaida(rs.getString("datasaida"));
                    patio.setHoraSaida(rs.getString("horasaida"));
                    patio.setPermanencia(rs.getString("permanencia"));
                    patio.setValorTotal(rs.getFloat("valortotal"));
                } else {
                    patio = rotativoCalculaSaida.calcularPermanenciaValor(patio);
                    patio.setDataSaida("----------");
                    patio.setHoraSaida("----------");
                }
                patioLista.add(patio);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patioLista;
    }

    public void patioEstacionaVeiculo(Patio patio) {
        try {
            String sql = "INSERT INTO patio(id_veiculo_fk, placa_fk, rps, prisma, tipo, preco30minutos, preco60minutos, precodemaisfracoes, precodiaria, precopernoite, estacionado, dataentrada, horaentrada, toleranciadesistencia, toleranciaentrefracoes, diariahoras, diariaminutos, pernoiteinicio, pernoitetermino) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, patio.getIdVeiculoFk());
            stmt.setString(2, patio.getPlacaFk());
            stmt.setString(3, patio.getRps());
            stmt.setString(4, patio.getPrisma());
            stmt.setString(5, patio.getTipo());
            stmt.setFloat(6, patio.getPreco30Minutos());
            stmt.setFloat(7, patio.getPreco60Minutos());
            stmt.setFloat(8, patio.getPrecoDemaisFracoes());
            stmt.setFloat(9, patio.getPrecoDiaria());
            stmt.setFloat(10, patio.getPrecoPernoite());
            stmt.setString(11, patio.getEstacionado());
            stmt.setString(12, patio.getDataEntrada());
            stmt.setString(13, patio.getHoraEntrada());
            stmt.setInt(14, patio.getToleranciaDesistencia());
            stmt.setInt(15, patio.getToleranciaEntreFracoes());
            stmt.setInt(16, patio.getDiariaHoras());
            stmt.setInt(17, patio.getDiariaMinutos());
            stmt.setString(18, patio.getPernoiteInicio());
            stmt.setString(19, patio.getPernoiteTermino());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PatioRetiraVeiculo(Patio patio) {
        try {
            String sql = "UPDATE patio SET estacionado=?, datasaida=?, horasaida=?, permanencia=?, valortotal=?, dataentradahoraminuto=?, dataentradavalor=?, datasaidahoraminuto=?, datasaidavalor=?, diariaquantidade=?, diariavalortotal=?, pernoitequantidade=?, pernoitevalortotal=? WHERE prisma=? AND estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "nao");
            stmt.setString(2, patio.getDataSaida());
            stmt.setString(3, patio.getHoraSaida());
            stmt.setString(4, patio.getPermanencia());
            stmt.setFloat(5, patio.getValorTotal());
            stmt.setString(6, patio.getDataEntradaHoraMinuto());
            stmt.setFloat(7, patio.getDataEntradaValor());
            stmt.setString(8, patio.getDataSaidaHoraMinuto());
            stmt.setFloat(9, patio.getDataSaidaValor());
            stmt.setInt(10, patio.getDiariaQuantidade());
            stmt.setFloat(11, patio.getDiariaValorTotal());
            stmt.setInt(12, patio.getPernoiteQuantidade());
            stmt.setFloat(13, patio.getPernoiteValorTotal());
            stmt.setString(14, patio.getPrisma());
            System.out.println("patio.getprisma PatioDAO " + patio.getPrisma());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            } else {
                System.out.println("Deu merda!!!");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Patio patioVerificaVeiculoEstacionado(Patio patio) {
        try {
            String sql = "SELECT * FROM patio INNER JOIN veiculo ON patio.id_veiculo_fk = veiculo.id_veiculo WHERE patio.id_veiculo_fk=? AND patio.estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, patio.getIdVeiculoFk());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patio.setPlacaFk(rs.getString("placa"));
                System.out.println("Placa: " + patio.getPlacaFk());
                patio.setPrisma(rs.getString("prisma"));
                System.out.println("Prisma: " + patio.getPrisma());
                patio.setEstacionado("sim");
                System.out.println("Estacionado?: " + patio.getEstacionado());
            } else {
                patio.setEstacionado("nao");
                System.out.println("Estacionado?: " + patio.getEstacionado());
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patio;
    }

    public Patio patioVerificaPrismaUtilizado(Patio patio) {
        try {
            String sql = "SELECT * FROM patio INNER JOIN veiculo ON patio.id_veiculo_fk = veiculo.id_veiculo WHERE patio.prisma=? AND patio.estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, patio.getPrisma());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patio.setEstacionado(rs.getString("estacionado"));
                System.out.println("Estacionado?: " + patio.getEstacionado());
                patio.setRps(rs.getString("rps"));
                System.out.println("Rps: " + patio.getRps());
                patio.setPlacaFk(rs.getString("placa"));
                System.out.println("Placa: " + patio.getPlacaFk());
                patio.setPrisma(rs.getString("prisma"));
                System.out.println("Prisma: " + patio.getPrisma());
                patio.setTipo(rs.getString("tipo"));
                System.out.println("Tipo: " + patio.getTipo());
                patio.setPreco30Minutos(rs.getFloat("preco30minutos"));
                System.out.println("Preço até 30 minutos: " + new DecimalFormat("R$ #,##0.00").format(patio.getPreco30Minutos()));
                patio.setPreco60Minutos(rs.getFloat("preco60minutos"));
                System.out.println("Preço até 60 minutos: " + new DecimalFormat("R$ #,##0.00").format(patio.getPreco60Minutos()));
                patio.setPrecoDemaisFracoes(rs.getFloat("precodemaisfracoes"));
                System.out.println("Demais frações: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoDemaisFracoes()));
                patio.setPrecoDiaria(rs.getFloat("precodiaria"));
                System.out.println("Preço Diária: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoDiaria()));
                patio.setPrecoPernoite(rs.getFloat("precopernoite"));
                System.out.println("Preço Pernoite: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoPernoite()));
                patio.setDataEntrada(rs.getString("dataentrada"));
                System.out.println("Data Entrada: " + patio.getDataEntrada());
                patio.setHoraEntrada(rs.getString("horaentrada"));
                System.out.println("Hora Entrada: " + patio.getHoraEntrada());
                patio.setToleranciaDesistencia(rs.getInt("toleranciadesistencia"));
                patio.setToleranciaEntreFracoes(rs.getInt("toleranciaentrefracoes"));
                patio.setDiariaHoras(rs.getInt("diariahoras"));
                patio.setDiariaMinutos(rs.getInt("diariaminutos"));
                patio.setPernoiteInicio(rs.getString("pernoiteinicio"));
                patio.setPernoiteTermino(rs.getString("pernoitetermino"));
            } else {
                patio.setEstacionado("nao");
                System.out.println("Estacionado?: " + patio.getEstacionado());
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patio;
    }
}

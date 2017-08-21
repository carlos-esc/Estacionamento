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
import modelo.Cliente;
import modelo.Contrato;

public class PatioDAO {

    private Connection conexao;
    //RotativoCalculaSaida rotativoCalculaSaida = new RotativoCalculaSaida();

    public PatioDAO() {
        this.conexao = new ConexaoFactory().getConnection();
    }

    public List movimentoLista(List movimentoLista, String movimentoData) {
        try {
            String sql = "SELECT * FROM patio";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            RotativoCalculoSaida rotativoCalculaSaida = new RotativoCalculoSaida();
            Date patioDataEntrada = null, patioDataSaida = null, movimentoDataPesquisa = null;
            movimentoDataPesquisa = sdfData.parse(movimentoData);
            while (rs.next()) {
                patioDataEntrada = sdfData.parse(rs.getString("data_entrada"));
                if (patioDataEntrada.getTime() > movimentoDataPesquisa.getTime()) {
                    System.out.print("Patio entrada" + patioDataEntrada.getTime());
                    System.out.print("Movimento Pesquisa" + movimentoDataPesquisa.getTime());
                } else {
                    if (patioDataEntrada.getTime() <= movimentoDataPesquisa.getTime() && rs.getString("data_saida") == null) {
                        patioDataSaida = new Date();
                    } else {
                        patioDataSaida = sdfData.parse(rs.getString("data_saida"));
                    }
                    if (patioDataSaida.getTime() >= movimentoDataPesquisa.getTime()) {
                        Patio patio = new Patio();
                        patio.setDataSaida(sdfData.format(new Date()));
                        patio.setHoraSaida(sdfHora.format(new Date()));

                        patio.setPlaca(rs.getString("placa"));
                        patio.setPrisma(rs.getString("prisma"));
                        patio.setRps(rs.getString("rps"));
                        patio.setTipo(rs.getString("tipo"));
                        patio.setPreco30Minutos(rs.getFloat("preco_30_minutos"));
                        patio.setPreco60Minutos(rs.getFloat("preco_60_minutos"));
                        patio.setPrecoDemaisFracoes(rs.getFloat("preco_demais_fracoes"));
                        patio.setPrecoDiaria(rs.getFloat("preco_diaria"));
                        patio.setPrecoPernoite(rs.getFloat("preco_pernoite"));
                        patio.setDataEntrada(rs.getString("data_entrada"));
                        patio.setHoraEntrada(rs.getString("hora_entrada"));
                        patio.setToleranciaDesistencia(rs.getInt("tolerancia_desistencia"));
                        patio.setToleranciaEntreFracoes(rs.getInt("tolerancia_entre_fracoes"));
                        patio.setDiariaHoras(rs.getInt("diaria_horas"));
                        patio.setDiariaMinutos(rs.getInt("diaria_minutos"));
                        patio.setPernoiteInicio(rs.getString("pernoite_inicio"));
                        patio.setPernoiteTermino(rs.getString("pernoite_termino"));

                        if (rs.getString("data_saida") != null) {
                            patio.setDataSaida(rs.getString("data_saida"));
                            patio.setHoraSaida(rs.getString("hora_saida"));
                            patio.setPermanencia(rs.getString("permanencia"));
                            patio.setValorTotal(rs.getFloat("valor_total"));
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
                    sql = "SELECT * FROM patio WHERE estacionado='sim'";
                    break;
                case "placa":
                    sql = "SELECT * FROM patio WHERE estacionado='sim' ORDER BY placa ASC";
                    break;
                case "prisma":
                    sql = "SELECT * FROM patio WHERE estacionado='sim' ORDER BY prisma * 1 ASC";
                    break;
                case "tipo":
                    sql = "SELECT * FROM patio WHERE estacionado='sim' ORDER BY tipo ASC";
                    break;
                default:
                    sql = "SELECT * FROM patio WHERE estacionado='sim'";
                    break;
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            RotativoCalculoSaida rotativoCalculaSaida = new RotativoCalculoSaida();
            while (rs.next()) {
                Patio patio = new Patio();
                patio.setDataSaida(dataAtual.format(new Date()));
                patio.setHoraSaida(horaAtual.format(new Date()));

                patio.setPlaca(rs.getString("placa"));
                patio.setPrisma(rs.getString("prisma"));
                patio.setRps(rs.getString("rps"));
                patio.setTipo(rs.getString("tipo"));
                patio.setPreco30Minutos(rs.getFloat("preco_30_minutos"));
                patio.setPreco60Minutos(rs.getFloat("preco_60_minutos"));
                patio.setPrecoDemaisFracoes(rs.getFloat("preco_demais_fracoes"));
                patio.setPrecoDiaria(rs.getFloat("preco_diaria"));
                patio.setPrecoPernoite(rs.getFloat("preco_pernoite"));
                patio.setDataEntrada(rs.getString("data_entrada"));
                patio.setHoraEntrada(rs.getString("hora_entrada"));
                patio.setToleranciaDesistencia(rs.getInt("tolerancia_desistencia"));
                patio.setToleranciaEntreFracoes(rs.getInt("tolerancia_entre_fracoes"));
                patio.setDiariaHoras(rs.getInt("diaria_horas"));
                patio.setDiariaMinutos(rs.getInt("diaria_minutos"));
                patio.setPernoiteInicio(rs.getString("pernoite_inicio"));
                patio.setPernoiteTermino(rs.getString("pernoite_termino"));

                if (rs.getString("data_saida") != null) {
                    patio.setDataSaida(rs.getString("data_saida"));
                    patio.setHoraSaida(rs.getString("hora_saida"));
                    patio.setPermanencia(rs.getString("permanencia"));
                    patio.setValorTotal(rs.getFloat("valor_total"));
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
            String sql = "INSERT INTO patio(id_contrato_fk, placa, rps, prisma, tipo, preco_30_minutos, preco_60_minutos, preco_demais_fracoes, preco_diaria, preco_pernoite, estacionado, data_entrada, hora_entrada, tolerancia_desistencia, tolerancia_entre_fracoes, diaria_horas, diaria_minutos, pernoite_inicio, pernoite_termino) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, patio.getIdContratoFk());
            stmt.setString(2, patio.getPlaca());
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
            String sql = "UPDATE patio SET estacionado=?, data_saida=?, hora_saida=?, permanencia=?, valor_total=?, data_entrada_hora_minuto=?, data_entrada_valor=?, data_saida_hora_minuto=?, data_saida_valor=?, diaria_quantidade=?, diaria_valor_total=?, pernoite_quantidade=?, pernoite_valor_total=? WHERE prisma=? AND estacionado='sim'";
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

    public Patio patioVerificaVeiculoEstacionado(String placa) {
        try {
            String sql = "SELECT * FROM patio WHERE placa=? AND estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            Patio patio = new Patio();
            if (rs.next()) {
                patio.setPlaca(rs.getString("placa"));
                patio.setPrisma(rs.getString("prisma"));
                patio.setEstacionado("sim");
            } else {
                patio.setEstacionado("nao");
            }
            rs.close();
            stmt.close();
            return patio;
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Patio patioVerificaPrismaUtilizado(Patio patio) {
        try {
            String sql = "SELECT * FROM patio WHERE prisma=? AND estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, patio.getPrisma());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patio.setEstacionado(rs.getString("estacionado"));
                System.out.println("Estacionado?: " + patio.getEstacionado());
                patio.setRps(rs.getString("rps"));
                System.out.println("Rps: " + patio.getRps());
                patio.setPlaca(rs.getString("placa"));
                System.out.println("Placa: " + patio.getPlaca());
                patio.setPrisma(rs.getString("prisma"));
                System.out.println("Prisma: " + patio.getPrisma());
                patio.setTipo(rs.getString("tipo"));
                System.out.println("Tipo: " + patio.getTipo());
                patio.setPreco30Minutos(rs.getFloat("preco_30_minutos"));
                System.out.println("Preço até 30 minutos: " + new DecimalFormat("R$ #,##0.00").format(patio.getPreco30Minutos()));
                patio.setPreco60Minutos(rs.getFloat("preco_60_minutos"));
                System.out.println("Preço até 60 minutos: " + new DecimalFormat("R$ #,##0.00").format(patio.getPreco60Minutos()));
                patio.setPrecoDemaisFracoes(rs.getFloat("preco_demais_fracoes"));
                System.out.println("Demais frações: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoDemaisFracoes()));
                patio.setPrecoDiaria(rs.getFloat("preco_diaria"));
                System.out.println("Preço Diária: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoDiaria()));
                patio.setPrecoPernoite(rs.getFloat("preco_pernoite"));
                System.out.println("Preço Pernoite: " + new DecimalFormat("R$ #,##0.00").format(patio.getPrecoPernoite()));
                patio.setDataEntrada(rs.getString("data_entrada"));
                System.out.println("Data Entrada: " + patio.getDataEntrada());
                patio.setHoraEntrada(rs.getString("hora_entrada"));
                System.out.println("Hora Entrada: " + patio.getHoraEntrada());
                patio.setToleranciaDesistencia(rs.getInt("tolerancia_desistencia"));
                patio.setToleranciaEntreFracoes(rs.getInt("tolerancia_entre_fracoes"));
                patio.setDiariaHoras(rs.getInt("diaria_horas"));
                patio.setDiariaMinutos(rs.getInt("diaria_minutos"));
                patio.setPernoiteInicio(rs.getString("pernoite_inicio"));
                patio.setPernoiteTermino(rs.getString("pernoite_termino"));
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

    public Patio contratoCienteVagaIsOcupada(Contrato contrato) {
        try {
            Patio patio = new Patio();
            String sql = "SELECT * FROM patio WHERE (placa=? OR placa=? OR placa=? OR placa=?) AND estacionado='sim'";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, contrato.getVeiculo1().getPlaca());
            stmt.setString(2, contrato.getVeiculo2().getPlaca());
            stmt.setString(3, contrato.getVeiculo3().getPlaca());
            stmt.setString(4, contrato.getVeiculo4().getPlaca());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patio.setPlaca(rs.getString("placa"));
                patio.setPrisma(rs.getString("prisma"));
            } else {
                patio.setPlaca("VagaLivre");
            }
            rs.close();
            stmt.close();
            return patio;
        } catch (SQLException ex) {
            Logger.getLogger(PatioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

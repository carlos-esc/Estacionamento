package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConfiguracoesService;

public class RotativoCalculaSaida {

    private RotativoTipoPreco rotativo = new RotativoTipoPreco();
    private ConfiguracoesService configuracoesService = new ConfiguracoesService();
    private Configuracoes configuracoes = new Configuracoes();

    private Calendar calendario;
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    private Date dataEntradaVariavel, dataEntrada, horaEntrada, dataSaida, horaSaida;
    private long permanenciaTotal;

    private int diariaQuantidade, pernoiteQuantidade = 0;
    private float valorRotativoNoDiaEntrada, horasRotativoNoDiaEntrada, minutosRotativoNoDiaEntrada,
            valorRotativoNoDiaSaida, horasRotativoNoDiaSaida, minutosRotativoNoDiaSaida = 0;

    public RotativoCalculaSaida() {
        configuracoes = configuracoesService.configuracoesCarregarTodos(configuracoes);
    }

    public Patio calcularPermanenciaValor(Patio patio) {
        try {
            dataEntradaVariavel = sdfData.parse(patio.getDataEntrada());
            dataEntrada = sdfData.parse(patio.getDataEntrada());
            horaEntrada = sdfHora.parse(patio.getHoraEntrada());
            dataSaida = sdfData.parse(patio.getDataSaida());
            horaSaida = sdfHora.parse(patio.getHoraSaida());
            permanenciaTotal = (dataSaida.getTime() + horaSaida.getTime()) - (dataEntrada.getTime() + horaEntrada.getTime());
            calcularPermanenciaTotal(permanenciaTotal, patio);
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dataSaida.equals(dataEntrada)) {
            calcularRotativoComSaidaNoMesmoDia(patio);
        } else {
            calcularRotativoComSaidaEmDiaDiferente(patio);
        }
        return patio;
    }

    private Patio calcularRotativoComSaidaNoMesmoDia(Patio patio) {
        long diferencaHorasMinutos = horaSaida.getTime() - horaEntrada.getTime();
        horasRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
        minutosRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 1000) % 60;
        patio.setDataSaidaHoras(new DecimalFormat("00h | ").format(horasRotativoNoDiaEntrada));
        patio.setDataSaidaMinutos(new DecimalFormat("00m").format(minutosRotativoNoDiaEntrada));
        patio.setDataEntradaHoras("");
        patio.setDataEntradaMinutos("");
        patio.setDataSaidaHoras("");
        patio.setDataSaidaMinutos("");
        if (horasRotativoNoDiaEntrada > configuracoes.getDiariaHora()) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoras("Diária");
            patio.setDiariaQuantidade(1);
        } else if (horasRotativoNoDiaEntrada >= configuracoes.getDiariaHora() && minutosRotativoNoDiaEntrada >= (configuracoes.getDiariaMinuto() + configuracoes.getToleranciaFracoes())) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoras("Diária");
            patio.setDiariaQuantidade(1);
        } else if (horasRotativoNoDiaEntrada == 1 && minutosRotativoNoDiaEntrada == configuracoes.getToleranciaFracoes()) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada > (30 + configuracoes.getToleranciaFracoes())) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada > configuracoes.getToleranciaDesistencia()) {
            patio.setValorTotal(patio.getPreco30Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada <= configuracoes.getToleranciaDesistencia()) {
            patio.setDataEntradaHoras("Tolerância");
            patio.setDataSaidaHoras("Tolerância");
            patio.setValorTotal(0);
        } else {
            long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
            long resto = diferencaHorasMinutos / (60 * 1000) % 30;
            valorRotativoNoDiaEntrada = (meiaHora - 2) * patio.getPrecoDemaisFracoes();
            if (resto > configuracoes.getToleranciaFracoes()) {
                valorRotativoNoDiaEntrada = valorRotativoNoDiaEntrada + patio.getPrecoDemaisFracoes();
            }
            patio.setValorTotal(valorRotativoNoDiaEntrada + patio.getPreco60Minutos());
        }
        return patio;
    }

    private Patio calcularRotativoComSaidaEmDiaDiferente(Patio patio) {
        calcularRotativoDiaDaEntrada(patio);
        calcularRotativoDiariasPernoites(patio);
        calcularRotativoDiaDaSaida(patio);
        return patio;
    }

    private Patio calcularRotativoDiaDaEntrada(Patio patio) {
        long diferencaHorasMinutos;
        patio.setDataEntradaHoras("");
        patio.setDataEntradaMinutos("");
        Date pernoiteInicio = null, pernoiteTermino = null;

        try {
            pernoiteInicio = sdfHora.parse(configuracoes.getPernoiteInicio());
            pernoiteTermino = sdfHora.parse(configuracoes.getPernoiteTermino());
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (horaEntrada.getTime() < pernoiteInicio.getTime()) {
            diferencaHorasMinutos = pernoiteInicio.getTime() - horaEntrada.getTime();
            horasRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            minutosRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 1000) % 60;
            if (horasRotativoNoDiaEntrada > configuracoes.getDiariaHora()) {
                diariaQuantidade++;
                patio.setDataEntradaHoras("Diária");
            } else if (horasRotativoNoDiaEntrada >= configuracoes.getDiariaHora() && minutosRotativoNoDiaEntrada >= configuracoes.getDiariaMinuto()) {
                diariaQuantidade++;
                patio.setDataEntradaHoras("Diária");
            } else {
                if (horasRotativoNoDiaEntrada == 1 && minutosRotativoNoDiaEntrada == 0) {
                    valorRotativoNoDiaEntrada = patio.getPreco60Minutos();
                } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada > 30) {
                    valorRotativoNoDiaEntrada = patio.getPreco60Minutos();
                } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada <= 30) {
                    valorRotativoNoDiaEntrada = patio.getPreco30Minutos();
                } else {
                    long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
                    long resto = diferencaHorasMinutos / (60 * 1000) % 30;
                    valorRotativoNoDiaEntrada = (meiaHora - 2) * patio.getPrecoDemaisFracoes();
                    if (resto != 0) {
                        valorRotativoNoDiaEntrada = valorRotativoNoDiaEntrada + patio.getPrecoDemaisFracoes();
                    }
                    valorRotativoNoDiaEntrada = valorRotativoNoDiaEntrada + patio.getPreco60Minutos();
                }
                patio.setDataEntradaHoras(new DecimalFormat("00h | ").format(horasRotativoNoDiaEntrada));
                patio.setDataEntradaMinutos(new DecimalFormat("00m").format(minutosRotativoNoDiaEntrada));
            }
            patio.setValorDataEntrada(valorRotativoNoDiaEntrada);
        }
        return patio;
    }

    private Patio calcularRotativoDiariasPernoites(Patio patio) {
        calendario = Calendar.getInstance();
        calendario.setTime(dataEntradaVariavel);
        calendario.add(Calendar.DATE, +1);
        dataEntradaVariavel = calendario.getTime();
        pernoiteQuantidade++;
        while (!dataEntradaVariavel.equals(dataSaida)) {
            diariaQuantidade++;
            pernoiteQuantidade++;
            calendario.add(Calendar.DATE, +1);
            dataEntradaVariavel = calendario.getTime();
        }
        return patio;
    }

    private Patio calcularRotativoDiaDaSaida(Patio patio) {
        Date pernoiteInicio = null, pernoiteTermino = null;
        try {
            pernoiteInicio = sdfHora.parse(configuracoes.getPernoiteInicio());
            pernoiteTermino = sdfHora.parse(configuracoes.getPernoiteTermino());
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (horaSaida.getTime() <= pernoiteTermino.getTime()) {
            patio.setDataSaidaHoras("Pernoite");
            patio.setDataSaidaMinutos("");
        } else {
            long diferencaHorasMinutos = horaSaida.getTime() - pernoiteTermino.getTime();
            horasRotativoNoDiaSaida = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            minutosRotativoNoDiaSaida = diferencaHorasMinutos / (60 * 1000) % 60;
            patio.setDataSaidaHoras("");
            patio.setDataSaidaMinutos("");
            if (horasRotativoNoDiaSaida > configuracoes.getDiariaHora()) {
                diariaQuantidade++;
                patio.setDataSaidaHoras("Diária");
            } else if (horasRotativoNoDiaSaida >= configuracoes.getDiariaHora() && minutosRotativoNoDiaSaida >= (configuracoes.getDiariaMinuto() + configuracoes.getToleranciaFracoes())) {
                diariaQuantidade++;
                patio.setDataSaidaHoras("Diária");
            } else {
                long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
                long resto = diferencaHorasMinutos / (60 * 1000) % 30;
                valorRotativoNoDiaSaida = meiaHora * patio.getPrecoDemaisFracoes();
                if (resto > configuracoes.getToleranciaFracoes()) {
                    valorRotativoNoDiaSaida = valorRotativoNoDiaSaida + patio.getPrecoDemaisFracoes();
                }
                patio.setDataSaidaHoras(new DecimalFormat("00h | ").format(horasRotativoNoDiaSaida));
                patio.setDataSaidaMinutos(new DecimalFormat("00m").format(minutosRotativoNoDiaSaida));
            }
        }
        patio.setValorDataSaida(valorRotativoNoDiaSaida);
        patio.setDiariaQuantidade(diariaQuantidade);
        patio.setPernoiteQuantidade(pernoiteQuantidade);
        patio.setDiariasValorTotal(diariaQuantidade * patio.getPrecoDiaria());
        patio.setPernoitesValorTotal(pernoiteQuantidade * patio.getPrecoPernoite());

        patio.setValorTotal(patio.getValorDataEntrada() + patio.getValorDataSaida() + patio.getDiariasValorTotal() + patio.getPernoitesValorTotal());
        return patio;
    }

    private Patio calcularPermanenciaTotal(long permanenciaTotal, Patio patio) {
        float permanenciaTotalDias = permanenciaTotal / (24 * 60 * 60 * 1000);
        float permanenciaTotalHoras = permanenciaTotal / (60 * 60 * 1000) % 24;
        float permanenciaTotalMinutos = permanenciaTotal / (60 * 1000) % 60;
        patio.setPermanencia(new DecimalFormat("000d | ").format(permanenciaTotalDias)
                + new DecimalFormat("00h | ").format(permanenciaTotalHoras)
                + new DecimalFormat("00m").format(permanenciaTotalMinutos));
        return patio;
    }
}

package calculo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Patio;
import modelo.Rotativo;

public class RotativoCalculoSaida {

    private Rotativo rotativo = new Rotativo();

    private Calendar calendario;
    private SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    private Date dataEntradaVariavel, dataEntrada, horaEntrada, dataSaida, horaSaida;
    private long permanenciaTotal;

    private int diariaQuantidade, pernoiteQuantidade = 0;
    private float valorRotativoNoDiaEntrada, horasRotativoNoDiaEntrada, minutosRotativoNoDiaEntrada,
            valorRotativoNoDiaSaida, horasRotativoNoDiaSaida, minutosRotativoNoDiaSaida = 0;

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
            Logger.getLogger(RotativoCalculoSaida.class.getName()).log(Level.SEVERE, null, ex);
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
        patio.setDataEntradaHoraMinuto("");
        if (horasRotativoNoDiaEntrada > patio.getDiariaHoras()) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoraMinuto("Diária");
            patio.setDiariaQuantidade(1);
        } else if (horasRotativoNoDiaEntrada >= patio.getDiariaHoras() && minutosRotativoNoDiaEntrada >= (patio.getDiariaMinutos() + patio.getToleranciaEntreFracoes())) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoraMinuto("Diária");
            patio.setDiariaQuantidade(1);
        } else if (horasRotativoNoDiaEntrada == 1 && minutosRotativoNoDiaEntrada == patio.getToleranciaEntreFracoes()) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada > (30 + patio.getToleranciaEntreFracoes())) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada > patio.getToleranciaDesistencia()) {
            patio.setValorTotal(patio.getPreco30Minutos());
        } else if (horasRotativoNoDiaEntrada == 0 && minutosRotativoNoDiaEntrada <= patio.getToleranciaDesistencia()) {
            patio.setDataEntradaHoraMinuto("Tolerância");
            patio.setValorTotal(0);
        } else {
            long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
            long resto = diferencaHorasMinutos / (60 * 1000) % 30;
            valorRotativoNoDiaEntrada = (meiaHora - 2) * patio.getPrecoDemaisFracoes();
            if (resto > patio.getToleranciaEntreFracoes()) {
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
        Date pernoiteInicio = null, pernoiteTermino = null;
        try {
            pernoiteInicio = sdfHora.parse(patio.getPernoiteInicio());
            pernoiteTermino = sdfHora.parse(patio.getPernoiteTermino());
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculoSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (horaEntrada.getTime() < pernoiteInicio.getTime()) {
            diferencaHorasMinutos = pernoiteInicio.getTime() - horaEntrada.getTime();
            horasRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            minutosRotativoNoDiaEntrada = diferencaHorasMinutos / (60 * 1000) % 60;
            if (horasRotativoNoDiaEntrada > patio.getDiariaHoras()) {
                diariaQuantidade++;
                patio.setDataEntradaHoraMinuto("Diária");
            } else if (horasRotativoNoDiaEntrada >= patio.getDiariaHoras() && minutosRotativoNoDiaEntrada >= patio.getDiariaMinutos()) {
                diariaQuantidade++;
                patio.setDataEntradaHoraMinuto("Diária");
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
                patio.setDataEntradaHoraMinuto(new DecimalFormat("00h | ").format(horasRotativoNoDiaEntrada) + new DecimalFormat("00m").format(minutosRotativoNoDiaEntrada));
            }
            patio.setDataEntradaValor(valorRotativoNoDiaEntrada);
        } else {
            patio.setDataEntradaHoraMinuto("Pernoite");
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
            pernoiteInicio = sdfHora.parse(patio.getPernoiteInicio());
            pernoiteTermino = sdfHora.parse(patio.getPernoiteTermino());
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculoSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (horaSaida.getTime() <= pernoiteTermino.getTime()) {
            patio.setDataSaidaHoraMinuto("Pernoite");
        } else {
            long diferencaHorasMinutos = horaSaida.getTime() - pernoiteTermino.getTime();
            horasRotativoNoDiaSaida = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            minutosRotativoNoDiaSaida = diferencaHorasMinutos / (60 * 1000) % 60;
            patio.setDataSaidaHoraMinuto("");
            if (horasRotativoNoDiaSaida > patio.getDiariaHoras()) {
                diariaQuantidade++;
                patio.setDataSaidaHoraMinuto("Diária");
            } else if (horasRotativoNoDiaSaida >= patio.getDiariaHoras() && minutosRotativoNoDiaSaida >= (patio.getDiariaMinutos() + patio.getToleranciaEntreFracoes())) {
                diariaQuantidade++;
                patio.setDataSaidaHoraMinuto("Diária");
            } else {
                long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
                long resto = diferencaHorasMinutos / (60 * 1000) % 30;
                valorRotativoNoDiaSaida = meiaHora * patio.getPrecoDemaisFracoes();
                if (resto > patio.getToleranciaEntreFracoes()) {
                    valorRotativoNoDiaSaida = valorRotativoNoDiaSaida + patio.getPrecoDemaisFracoes();
                }
                patio.setDataSaidaHoraMinuto(new DecimalFormat("00h | ").format(horasRotativoNoDiaSaida) + new DecimalFormat("00m").format(minutosRotativoNoDiaSaida));
            }
        }
        patio.setDataSaidaValor(valorRotativoNoDiaSaida);
        patio.setDiariaQuantidade(diariaQuantidade);
        patio.setPernoiteQuantidade(pernoiteQuantidade);
        patio.setDiariaValorTotal(diariaQuantidade * patio.getPrecoDiaria());
        patio.setPernoiteValorTotal(pernoiteQuantidade * patio.getPrecoPernoite());

        patio.setValorTotal(patio.getDataEntradaValor() + patio.getDataSaidaValor() + patio.getDiariaValorTotal() + patio.getPernoiteValorTotal());
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
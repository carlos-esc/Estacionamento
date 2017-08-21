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
    private Date patioDataEntradaVariavel, patioDataEntrada, patioHoraEntrada, patioDataSaida, patioHoraSaida;
    private long patioPermanenciaTotal;

    private int diariaQuantidade, pernoiteQuantidade;
    private float rotativoHoraEntrada = 0, rotativoMinutoEntrada = 0, rotativoDataEntradaValor = 0, 
                  rotativoHoraSaida = 0, rotativoMinutoSaida = 0, rotativoDataSaidaValor = 0;
    
    public Patio calcularPermanenciaValor(Patio patio) {
        try {
            patioDataEntradaVariavel = sdfData.parse(patio.getDataEntrada());
            patioDataEntrada = sdfData.parse(patio.getDataEntrada());
            patioHoraEntrada = sdfHora.parse(patio.getHoraEntrada());
            patioDataSaida = sdfData.parse(patio.getDataSaida());
            patioHoraSaida = sdfHora.parse(patio.getHoraSaida());
            diariaQuantidade = 0;
            pernoiteQuantidade = 0;
            patioPermanenciaTotal = (patioDataSaida.getTime() + patioHoraSaida.getTime()) - (patioDataEntrada.getTime() + patioHoraEntrada.getTime());
            calcularPermanenciaTotal(patioPermanenciaTotal, patio);
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculoSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (patioDataSaida.equals(patioDataEntrada)) {
            calcularRotativoComSaidaNoMesmoDia(patio);
        } else {
            calcularRotativoComSaidaEmDiaDiferente(patio);
        }
        return patio;
    }

    private Patio calcularRotativoComSaidaNoMesmoDia(Patio patio) {
       long diferencaHorasMinutos = patioHoraSaida.getTime() - patioHoraEntrada.getTime();
        rotativoHoraEntrada = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
        rotativoMinutoEntrada = diferencaHorasMinutos / (60 * 1000) % 60;
        patio.setDataEntradaHoraMinuto("");
        if (rotativoHoraEntrada > patio.getDiariaHoras()) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoraMinuto("Diária");
            patio.setDiariaQuantidade(1);
        } else if (rotativoHoraEntrada >= patio.getDiariaHoras() && rotativoMinutoEntrada >= (patio.getDiariaMinutos() + patio.getToleranciaEntreFracoes())) {
            patio.setValorTotal(patio.getPrecoDiaria());
            patio.setDataEntradaHoraMinuto("Diária");
            patio.setDiariaQuantidade(1);
        } else if (rotativoHoraEntrada == 1 && rotativoMinutoEntrada == patio.getToleranciaEntreFracoes()) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (rotativoHoraEntrada == 0 && rotativoMinutoEntrada > (30 + patio.getToleranciaEntreFracoes())) {
            patio.setValorTotal(patio.getPreco60Minutos());
        } else if (rotativoHoraEntrada == 0 && rotativoMinutoEntrada > patio.getToleranciaDesistencia()) {
            patio.setValorTotal(patio.getPreco30Minutos());
        } else if (rotativoHoraEntrada == 0 && rotativoMinutoEntrada <= patio.getToleranciaDesistencia()) {
            patio.setDataEntradaHoraMinuto("Tolerância");
            patio.setValorTotal(0);
        } else {
            long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
            long resto = diferencaHorasMinutos / (60 * 1000) % 30;
            rotativoDataEntradaValor = (meiaHora - 2) * patio.getPrecoDemaisFracoes();
            if (resto > patio.getToleranciaEntreFracoes()) {
                rotativoDataEntradaValor = rotativoDataEntradaValor + patio.getPrecoDemaisFracoes();
            }
            patio.setValorTotal(rotativoDataEntradaValor + patio.getPreco60Minutos());
        }
        return patio;
    }

    private Patio calcularRotativoComSaidaEmDiaDiferente(Patio patio) {
        patio = calcularRotativoDiaDaEntrada(patio);
        patio = calcularRotativoDiariasPernoites(patio);
        patio = calcularRotativoDiaDaSaida(patio);
        return patio;
    }

    private Patio calcularRotativoDiaDaEntrada(Patio patio) {
        long diferencaHorasMinutos = 0;
        Date pernoiteInicio = null, pernoiteTermino = null;
        try {
            pernoiteInicio = sdfHora.parse(patio.getPernoiteInicio());
            pernoiteTermino = sdfHora.parse(patio.getPernoiteTermino());
        } catch (ParseException ex) {
            Logger.getLogger(RotativoCalculoSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (patioHoraEntrada.getTime() < pernoiteInicio.getTime()) {
            diferencaHorasMinutos = pernoiteInicio.getTime() - patioHoraEntrada.getTime();
            rotativoHoraEntrada = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            rotativoMinutoEntrada = diferencaHorasMinutos / (60 * 1000) % 60;
            if (rotativoHoraEntrada > patio.getDiariaHoras()) {
                diariaQuantidade++;
                patio.setDataEntradaHoraMinuto("Diária");
            } else if (rotativoHoraEntrada >= patio.getDiariaHoras() && rotativoMinutoEntrada >= patio.getDiariaMinutos()) {
                diariaQuantidade++;
                patio.setDataEntradaHoraMinuto("Diária");
            } else {
                if (rotativoHoraEntrada == 1 && rotativoMinutoEntrada == 0) {
                    rotativoDataEntradaValor = patio.getPreco60Minutos();
                } else if (rotativoHoraEntrada == 0 && rotativoMinutoEntrada > 30) {
                    rotativoDataEntradaValor = patio.getPreco60Minutos();
                } else if (rotativoHoraEntrada == 0 && rotativoMinutoEntrada <= 30) {
                    rotativoDataEntradaValor = patio.getPreco30Minutos();
                } else {
                    long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
                    long resto = diferencaHorasMinutos / (60 * 1000) % 30;
                    rotativoDataEntradaValor = (meiaHora - 2) * patio.getPrecoDemaisFracoes();
                    if (resto != 0) {
                        rotativoDataEntradaValor = rotativoDataEntradaValor + patio.getPrecoDemaisFracoes();
                    }
                    rotativoDataEntradaValor = rotativoDataEntradaValor + patio.getPreco60Minutos();
                }
                patio.setDataEntradaHoraMinuto(new DecimalFormat("00h | ").format(rotativoHoraEntrada) + new DecimalFormat("00m").format(rotativoMinutoEntrada));
            }
            patio.setDataEntradaValor(rotativoDataEntradaValor);
        } else {
            patio.setDataEntradaHoraMinuto("Pernoite");
        }
        return patio;
    }

    private Patio calcularRotativoDiariasPernoites(Patio patio) {
        calendario = Calendar.getInstance();
        calendario.setTime(patioDataEntradaVariavel);
        calendario.add(Calendar.DATE, +1);
        patioDataEntradaVariavel = calendario.getTime();
        pernoiteQuantidade++;
        while (!patioDataEntradaVariavel.equals(patioDataSaida)) {
            diariaQuantidade++;
            pernoiteQuantidade++;
            calendario.add(Calendar.DATE, +1);
            patioDataEntradaVariavel = calendario.getTime();
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
        if (patioHoraSaida.getTime() <= pernoiteTermino.getTime()) {
            patio.setDataSaidaHoraMinuto("Pernoite");
        } else {
            long diferencaHorasMinutos = patioHoraSaida.getTime() - pernoiteTermino.getTime();
            rotativoHoraSaida = diferencaHorasMinutos / (60 * 60 * 1000) % 24;
            rotativoMinutoSaida = diferencaHorasMinutos / (60 * 1000) % 60;
            patio.setDataSaidaHoraMinuto("");
            if (rotativoHoraSaida > patio.getDiariaHoras()) {
                diariaQuantidade++;
                patio.setDataSaidaHoraMinuto("Diária");
            } else if (rotativoHoraSaida >= patio.getDiariaHoras() && rotativoMinutoSaida >= (patio.getDiariaMinutos() + patio.getToleranciaEntreFracoes())) {
                diariaQuantidade++;
                patio.setDataSaidaHoraMinuto("Diária");
            } else {
                long meiaHora = (int) (diferencaHorasMinutos / (60 * 1000)) / 30;
                long resto = diferencaHorasMinutos / (60 * 1000) % 30;
                rotativoDataSaidaValor = meiaHora * patio.getPrecoDemaisFracoes();
                if (resto > patio.getToleranciaEntreFracoes()) {
                    rotativoDataSaidaValor = rotativoDataSaidaValor + patio.getPrecoDemaisFracoes();
                }
                patio.setDataSaidaHoraMinuto(new DecimalFormat("00h | ").format(rotativoHoraSaida) + new DecimalFormat("00m").format(rotativoMinutoSaida));
            }
        }
        patio.setDataSaidaValor(rotativoDataSaidaValor);
        patio.setDiariaQuantidade(diariaQuantidade);
        patio.setPernoiteQuantidade(pernoiteQuantidade);
        patio.setDiariaValorTotal(diariaQuantidade * patio.getPrecoDiaria());
        patio.setPernoiteValorTotal(pernoiteQuantidade * patio.getPrecoPernoite());

        patio.setValorTotal(patio.getDataEntradaValor() + patio.getDataSaidaValor() + patio.getDiariaValorTotal() + patio.getPernoiteValorTotal());
        
        System.out.print("\n\n\nDiaria quantidade: " + patio.getDiariaQuantidade());
        System.out.print("\nPernoite quantidade: " + patio.getPernoiteQuantidade());
        System.out.print("\nData entrada valor R$ " + patio.getDataEntradaValor());
        System.out.print("\nData saida valor R$ " + patio.getDataSaidaValor());
        System.out.print("\nDiaria valor R$ " + patio.getDiariaValorTotal());
        System.out.print("\nPernoite valorR$ " + patio.getPernoiteValorTotal());
        System.out.print("\nValor total R$ " + patio.getValorTotal());
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
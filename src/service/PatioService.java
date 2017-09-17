package service;

import dao.PatioDAO;
import java.util.List;
import modelo.Contrato;
import modelo.Patio;

public class PatioService { 
    PatioDAO patioDAO = new PatioDAO();
    
    public List patioLista (List patioLista, String patioOrdenarLista) {
        patioDAO.patioLista(patioLista, patioOrdenarLista);
        return patioLista;
    }
    
    public List movimentoListaNew (List movimentoLista, String movimentoData, String movimentoHora) {
        patioDAO.movimentoListaNew(movimentoLista, movimentoData, movimentoHora);
        return movimentoLista;
    }
    
    public List movimentoLista (List movimentoLista, String movimentoData) {
        patioDAO.movimentoLista(movimentoLista, movimentoData);
        return movimentoLista;
    }
    
    public Patio estacionarVeiculo (Patio patio) {
        patioDAO.patioEstacionaVeiculo(patio);
        return patio;
    }
    
    public Patio retiraVeiculo (Patio patio) {
        patioDAO.PatioRetiraVeiculo(patio);
        return patio;
    }
    
    public Patio veiculoIsEstacionado (String placa) {
        Patio patio = new Patio();
        patio = patioDAO.veiculoIsEstacionado(placa);
        return patio;
    }    
    
    public Patio verificarPrisma (Patio patio) {
        patioDAO.patioVerificaPrismaUtilizado(patio);
        return patio;
    }
    
    public Patio contratoClienteVagaIsOcupada(Contrato contrato, Patio patio) {
        patio = patioDAO.contratoCienteVagaIsOcupada(contrato, patio);
        return patio;
    }
}

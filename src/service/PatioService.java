package service;

import dao.PatioDAO;
import java.util.List;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Patio;
import modelo.Veiculo;

public class PatioService { 
    PatioDAO patioDAO = new PatioDAO();
    
    public List patioLista (List patioLista, String patioOrdenarLista) {
        patioDAO.patioLista(patioLista, patioOrdenarLista);
        return patioLista;
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
    
    public Patio verificarVeiculo (String placa) {
        Patio patio = new Patio();
        patio = patioDAO.patioVerificaVeiculoEstacionado(placa);
        return patio;
    }    
    
    public Patio verificarPrisma (Patio patio) {
        patioDAO.patioVerificaPrismaUtilizado(patio);
        return patio;
    }
    
    public Patio contratoClienteVagaIsOcupada(Contrato contrato) {
        Patio patio = new Patio();
        patio = patioDAO.contratoCienteVagaIsOcupada(contrato);
        return patio;
    }
}

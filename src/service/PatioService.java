package service;

import dao.PatioDAO;
import java.util.List;
import modelo.Patio;

public class PatioService { 
    PatioDAO patioDAO = new PatioDAO();
    
    public List patioLista (List patioLista) {
        patioDAO.patioLista(patioLista);
        return patioLista;
    }
    
    public Patio estacionarVeiculo (Patio patio) {
        patioDAO.patioEstacionaVeiculo(patio);
        return patio;
    }
    
    public Patio retiraVeiculo (Patio patio) {
        patioDAO.PatioRetiraVeiculo(patio);
        return patio;
    }
    
    public Patio verificarVeiculo (Patio patio) {
        patioDAO.patioVerificaVeiculoEstacionado(patio);
        return patio;
    }    
    
    public Patio verificarPrisma (Patio patio) {
        patioDAO.patioVerificaPrismaUtilizado(patio);
        return patio;
    }
}

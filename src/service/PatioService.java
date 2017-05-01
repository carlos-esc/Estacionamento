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
        patioDAO.estacionaVeiculo(patio);
        return patio;
    }
    
    public Patio retiraVeiculo (Patio patio) {
        patioDAO.retiraVeiculo(patio);
        return patio;
    }
    
    public Patio verificarVeiculo (Patio patio) {
        patioDAO.verificaVeiculoEstacionado(patio);
        return patio;
    }    
    
    public Patio verificarPrisma (Patio patio) {
        patioDAO.verificaPrismaUtilizado(patio);
        return patio;
    }
}

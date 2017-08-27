package service;

import dao.VeiculoDAO;
import modelo.Veiculo;

public class VeiculoService {
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public Veiculo veiculoIncluir (Veiculo veiculo) {
        veiculoDAO.veiculoIncluir(veiculo);
        return veiculo;
    }
    
    public Veiculo veiculoAlterar (Veiculo veiculo) {
        veiculoDAO.veiculoAlterar(veiculo);
        return veiculo;
    }
    
    public Veiculo veiculoIsCadastrado (String placaVeiculo) {
        Veiculo veiculo = new Veiculo();
        veiculo = veiculoDAO.veiculoIsCadastrado(placaVeiculo);
        return veiculo;
    }
  
}

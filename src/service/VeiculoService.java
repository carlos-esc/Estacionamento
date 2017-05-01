package service;

import dao.VeiculoDAO;
import modelo.Veiculo;

public class VeiculoService {
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public Veiculo cadastrarVeiculo (Veiculo veiculo) {
        veiculoDAO.cadastraVeiculo(veiculo);
        return veiculo;
    }
    
    public Veiculo verificarCadastroVeiculo (Veiculo veiculo) {
        veiculoDAO.verificaCadastroVeiculo(veiculo);
        return veiculo;
    }
  
}

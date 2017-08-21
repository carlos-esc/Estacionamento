package service;

import dao.ContratoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Contrato;

public class ContratoService {
    ContratoDAO contratoDAO = new ContratoDAO();

    public List contratoList(String clienteNome, String contratoTipo, String contratoStatus, String numeroContrato) {
        List<Contrato> contratoArrayList = new ArrayList<>();
        contratoArrayList = contratoDAO.ContratoList(clienteNome, contratoTipo, contratoStatus, numeroContrato);
        return contratoArrayList;
    }
    
    public Contrato contratoPlacaIsCliente(String placa) {
        Contrato contrato = new Contrato();
        contrato = contratoDAO.placaIsContratoCliente(contrato, placa);
        return contrato;
    }
    
    public Contrato contratoIncluir(Contrato contrato){
        contrato = contratoDAO.contratoIncluir(contrato);
        return contrato;
    }
}

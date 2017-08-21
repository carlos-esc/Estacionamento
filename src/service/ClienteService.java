package service;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Contrato;

public class ClienteService {

    ClienteDAO clienteDAO = new ClienteDAO();

    public List clienteList(String clienteNome, String clienteCPF) {
        List<Cliente> clienteArrayList = new ArrayList<>();
        clienteArrayList = clienteDAO.clienteList(clienteNome, clienteCPF);
        return clienteArrayList;
    }
    
    public Contrato clienteIncluir(Contrato contrato){
        contrato = clienteDAO.clienteIncluir(contrato);
        return contrato;
    }
    
    public Contrato clienteAlterar(Contrato contrato){
        clienteDAO.clientaAlterar(contrato);
        return contrato;
    }
}

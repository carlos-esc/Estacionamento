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
    
    public Cliente clienteIncluir(Cliente cliente){
        cliente = clienteDAO.clienteIncluir(cliente);
        return cliente;
    }
    
    public Cliente clienteAlterar(Cliente cliente){
        clienteDAO.clientaAlterar(cliente);
        return cliente;
    }
}

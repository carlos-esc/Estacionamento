package service;

import dao.FaturaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Fatura;

public class FaturaService {
    FaturaDAO faturaDAO = new FaturaDAO();
    
    public List faturasContratoCliente (int numeroContratoCliente) {
        List<Fatura> faturaArrayList = new ArrayList<>();
        faturaArrayList = faturaDAO.faturasContratoCliente(numeroContratoCliente);
        return faturaArrayList;
    }
}

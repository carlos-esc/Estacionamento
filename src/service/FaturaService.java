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
    
    public boolean existeFaturaMesCorrente(int numeroContratoCliente, String mesReferencia) {
        boolean boole = faturaDAO.existeFaturaMesCorrente(numeroContratoCliente, mesReferencia);
        return boole;
    }
    
    public Fatura faturaIncluir(Fatura fatura) {
        fatura = faturaDAO.faturaIncluir(fatura);
        return fatura;
    }
}

package service;

import dao.FaturaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Fatura;

public class FaturaService {

    FaturaDAO faturaDAO = new FaturaDAO();

    public List faturasContratoCliente(int numeroContratoCliente) {
        List<Fatura> faturaArrayList = new ArrayList<>();
        faturaArrayList = faturaDAO.faturasContratoCliente(numeroContratoCliente);
        return faturaArrayList;
    }

    public List faturaPesquisaList(String idContrato, String mesReferencia, String vencimento, String dataPagamento, String valor, String status) {
        List<Fatura> faturaArrayList = new ArrayList<>();
        faturaArrayList = faturaDAO.faturaPesquisaList(idContrato, mesReferencia, vencimento, dataPagamento, valor, status);
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

    public void faturaPagamento(int idFatura) {
        faturaDAO.faturaPagamento(idFatura);
    }
}

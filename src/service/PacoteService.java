package service;
import dao.PacoteDAO;
import java.util.List;
import modelo.Pacote;

public class PacoteService {
    
    PacoteDAO pacoteServiceDAO = new PacoteDAO();
    
    public List pacoteCarregarLista(List pacoteArrayList){
        pacoteServiceDAO.pacoteCarregarLista(pacoteArrayList);
        return pacoteArrayList;
    }
    
    public Pacote pacoteCarregarAtributos(Pacote pacote){
        pacoteServiceDAO.pacoteCarregarAtributos(pacote);
        return pacote;
    }
    
    public Pacote pacoteIncluir(Pacote pacote){
        pacoteServiceDAO.pacoteIncluir(pacote);
        return pacote;
    }
    
    public Pacote pacoteExcluir(Pacote pacote){
        pacoteServiceDAO.pacoteExcluir(pacote);
        return pacote;
    }
    
    public Pacote pacoteAlterar(String pacoteNomeAnterior, Pacote pacote){
        pacoteServiceDAO.pacoteAlterar(pacoteNomeAnterior, pacote);
        return pacote;
    }
    
    public Pacote pacoteVerificaExistencia(Pacote pacote){
        pacoteServiceDAO.pacoteCarregarAtributos(pacote);
        return pacote;
    }
}

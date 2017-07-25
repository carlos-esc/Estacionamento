package service;

import dao.MensalistaDAO;
import java.util.List;
import modelo.Mensalista;

public class MensalistaService {

    MensalistaDAO mensalistaDAO = new MensalistaDAO();

    public List mensalistaCarregarPesquisa(List mensalistaLista, String mensalistaNomePesquisa) {
        mensalistaDAO.mensalistaCarregarPesquisa(mensalistaLista, mensalistaNomePesquisa);
        return mensalistaLista;
    }
    
    public Mensalista mensalistaCarregarAtributos(Mensalista mensalista) {
        mensalistaDAO.mensalistaCarregarAtributos(mensalista);
        return mensalista;
    }
    
    public Mensalista mensalistaIncluir(Mensalista mensalista){
        mensalistaDAO.mensalistaIncluir(mensalista);
        return mensalista;
    }
    
    public Mensalista mensalistaAlterar(Mensalista mensalista){
        mensalistaDAO.mensalistaAlterar(mensalista);
        return mensalista;
    }
}

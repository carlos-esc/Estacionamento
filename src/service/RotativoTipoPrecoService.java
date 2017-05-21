package service;

import dao.RotativoTipoPrecoDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import modelo.RotativoTipoPreco;

public class RotativoTipoPrecoService {

    RotativoTipoPrecoDAO precosDAO = new RotativoTipoPrecoDAO();

    public RotativoTipoPreco rotativoIncluirTipoPrecos(RotativoTipoPreco rotativoTipoPreco){
        precosDAO.rotativoIncluirTipoPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public RotativoTipoPreco rotativoExcluirTipoPrecos(RotativoTipoPreco rotativoTipoPreco){
        precosDAO.rotativoExcluirTipoPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public RotativoTipoPreco rotativoCarregarPrecos(RotativoTipoPreco rotativoTipoPreco){
        precosDAO.rotativoCarregarPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public RotativoTipoPreco rotativoAlterarPrecos(String rotativoTipoAnterior, RotativoTipoPreco rotativoTipoPreco){
        precosDAO.rotativoAlterarPrecos(rotativoTipoAnterior, rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public DefaultListModel rotativoCarregarTipos(DefaultListModel rotativoTipoLista){
        precosDAO.rotativoCarregarTipos(rotativoTipoLista);
        return rotativoTipoLista;
    }
    
    public List rotativoCarregarTipoPrecoLista(List rotativoTipoPrecoLista){
        precosDAO.rotativoCarregarTipoPrecoLista(rotativoTipoPrecoLista);
        return rotativoTipoPrecoLista;
    }
        
}

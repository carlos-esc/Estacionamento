package service;

import dao.RotativoDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import modelo.Rotativo;

public class RotativoService {

    RotativoDAO precosDAO = new RotativoDAO();

    public Rotativo rotativoIncluirTipoPrecos(Rotativo rotativoTipoPreco){
        precosDAO.rotativoIncluirTipoPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoExcluirTipoPrecos(Rotativo rotativoTipoPreco){
        precosDAO.rotativoExcluirTipoPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoCarregarPrecos(Rotativo rotativoTipoPreco){
        precosDAO.rotativoCarregarPrecos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoAlterarPrecos(String rotativoTipoAnterior, Rotativo rotativoTipoPreco){
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

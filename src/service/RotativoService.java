package service;

import dao.RotativoDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import modelo.Rotativo;

public class RotativoService {

    RotativoDAO rotativoServiceDAO = new RotativoDAO();

    public Rotativo rotativoIncluirTipoPrecos(Rotativo rotativoTipoPreco){
        rotativoServiceDAO.rotativoIncluir(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoExcluirTipoPrecos(Rotativo rotativoTipoPreco){
        rotativoServiceDAO.rotativoExcluir(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoCarregarAtributos(Rotativo rotativoTipoPreco){
        rotativoServiceDAO.rotativoCarregarAtributos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public Rotativo rotativoAlterarPrecos(String rotativoTipoAnterior, Rotativo rotativoTipoPreco){
        rotativoServiceDAO.rotativoAlterar(rotativoTipoAnterior, rotativoTipoPreco);
        return rotativoTipoPreco;
    }
    
    public DefaultListModel rotativoCarregarLista(DefaultListModel rotativoDefaultListModel){
        rotativoServiceDAO.rotativoCarregarLista(rotativoDefaultListModel);
        return rotativoDefaultListModel;
    }
    
    public List rotativoCarregarTipoPrecoLista(List rotativoTipoPrecoLista){
        rotativoServiceDAO.rotativoCarregarListaTodos(rotativoTipoPrecoLista);
        return rotativoTipoPrecoLista;
    }
    
    public Rotativo rotativoVerificaExistencia(Rotativo rotativoTipoPreco){
        rotativoServiceDAO.rotativoCarregarAtributos(rotativoTipoPreco);
        return rotativoTipoPreco;
    }   
}

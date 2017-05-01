package service;

import dao.ConfiguracoesDAO;
import modelo.Configuracoes;

public class ConfiguracoesService {

    ConfiguracoesDAO configuracoesDAO = new ConfiguracoesDAO();

    public Configuracoes configuracoesCarregarTodos (Configuracoes configuracoes){
        configuracoesDAO.configuracoesCarregarTodos(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesCarregarTolerancia(Configuracoes configuracoes) {
        configuracoesDAO.configuracoesCarregarTolerancia(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesAlterarTolerancia(Configuracoes configuracoes){
        configuracoesDAO.configuracoesAlterarTolerancia(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesCarregarDiaria (Configuracoes configuracoes){
        configuracoesDAO.configuracoesCarregarDiaria(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesAlterarDiaria(Configuracoes configuracoes){
        configuracoesDAO.configuracoesAlterarDiaria(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesCarregarPernoite (Configuracoes configuracoes){
        configuracoesDAO.configuracoesCarregarPernoite(configuracoes);
        return configuracoes;
    }
    
    public Configuracoes configuracoesAlterarPernoite(Configuracoes configuracoes){
        configuracoesDAO.configuracoesAlterarPernoite(configuracoes);
        return configuracoes;
    }
    
}

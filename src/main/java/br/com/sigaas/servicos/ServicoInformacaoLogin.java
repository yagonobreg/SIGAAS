package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.EventoDAO;
import br.com.sigaas.dao.InformacaoLoginDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Evento;
import br.com.sigaas.modelo.InformacaoLogin;

public class ServicoInformacaoLogin {
	private InformacaoLoginDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoInformacaoLogin(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new InformacaoLoginDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(InformacaoLogin informacaoLogin){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(informacaoLogin);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<InformacaoLogin> findAll(){
        return dao.findAll();
    }
}

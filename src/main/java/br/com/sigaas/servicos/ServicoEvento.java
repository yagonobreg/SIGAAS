package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.AulaDAO;
import br.com.sigaas.dao.EventoDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Aula;
import br.com.sigaas.modelo.Evento;

public class ServicoEvento {
	private EventoDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoEvento(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new EventoDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Evento evento){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(evento);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Evento> findAll(){
        return dao.findAll();
    }
}

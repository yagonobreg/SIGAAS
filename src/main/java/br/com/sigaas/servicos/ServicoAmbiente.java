package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.AmbienteDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Ambiente;

public class ServicoAmbiente {
	 	private AmbienteDAO dao;
     
	    private SimpleEntityManager simpleEntityManager;
	     
	    public ServicoAmbiente(SimpleEntityManager simpleEntityManager){
	        this.simpleEntityManager = simpleEntityManager;
	        dao = new AmbienteDAO(simpleEntityManager.getEntityManager());
	    }
	     
	    public void save(Ambiente ambiente){
	        try{
	            simpleEntityManager.beginTransaction();
	            dao.save(ambiente);
	            simpleEntityManager.commit();
	        }catch(Exception e){
	            e.printStackTrace();
	            simpleEntityManager.rollBack();
	        }
	    }
	     
	    public List<Ambiente> findAll(){
	        return dao.findAll();
	    }
}

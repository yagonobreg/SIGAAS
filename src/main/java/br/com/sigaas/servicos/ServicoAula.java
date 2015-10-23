package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.AmbienteDAO;
import br.com.sigaas.dao.AulaDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Ambiente;
import br.com.sigaas.modelo.Aula;

public class ServicoAula {
	private AulaDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoAula(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new AulaDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Aula aula){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(aula);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Aula> findAll(){
        return dao.findAll();
    }
}

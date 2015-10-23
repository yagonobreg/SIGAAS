package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.InformacaoLoginDAO;
import br.com.sigaas.dao.PapelDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.InformacaoLogin;
import br.com.sigaas.modelo.Papel;

public class ServicoPapel {
	private PapelDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoPapel(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new PapelDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Papel papel){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(papel);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Papel> findAll(){
        return dao.findAll();
    }
    
    public Papel getPapelAluno(){
    	return dao.getById("aluno");
    }
    
    public Papel getPapelProfessor(){
    	return dao.getById("professor");
    }
}

package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.PapelDAO;
import br.com.sigaas.dao.SolicitacaoTrocaDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Papel;
import br.com.sigaas.modelo.SolicitacaoTroca;

public class ServicoSolicitacaoTroca {
	private SolicitacaoTrocaDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoSolicitacaoTroca(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new SolicitacaoTrocaDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(SolicitacaoTroca solicitacaoTroca){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(solicitacaoTroca);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<SolicitacaoTroca> findAll(){
        return dao.findAll();
    }
}

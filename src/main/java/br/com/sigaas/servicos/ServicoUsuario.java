package br.com.sigaas.servicos;

import java.util.List;

import br.com.sigaas.dao.SolicitacaoTrocaDAO;
import br.com.sigaas.dao.UsuarioDAO;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.SolicitacaoTroca;
import br.com.sigaas.modelo.Usuario;

public class ServicoUsuario {
	private UsuarioDAO dao;
    
    private SimpleEntityManager simpleEntityManager;
     
    public ServicoUsuario(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new UsuarioDAO(simpleEntityManager.getEntityManager());
    }
     
    public void save(Usuario usuario){
        try{
            simpleEntityManager.beginTransaction();
            dao.save(usuario);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Usuario> findAll(){
        return dao.findAll();
    }
}

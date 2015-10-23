package modelo2;

import java.util.List;

import org.hibernate.Query;


public class RequisitanteDao extends GenericDao<Requisitante>{
	public void salvar(Requisitante requisitante) {
        save(requisitante);
    }
 
    public void alterar(Requisitante requisitante) {
        update(requisitante);
    }
 
    public void excluir(String id) {
    	Requisitante requisitante = findById(id);
        delete(requisitante);
    }
    public List<String> getEmails(){
    	String hql = "SELECT R.email FROM Requisitante R";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
    }
}

package modelo2;

import java.util.List;

import org.hibernate.Query;


public class SalaDao extends GenericDao<Sala>{
	public void salvar(Sala sala) {
        save(sala);
    }
 
    public void alterar(Sala sala) {
        update(sala);
    }
 
    public void excluir(String id) {
    	Sala sala = findById(id);
        delete(sala);
    }

	public List<String> getNomes() {
		String hql = "SELECT S.nome FROM Sala S";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
	}
}

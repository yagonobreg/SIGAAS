package modelo2;

import java.io.Serializable;



public class RequisicaoDao  extends GenericDao<Requisicao2> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void salvar(Requisicao2 requisicao) {
		System.out.println("save");
        save(requisicao);
    }
 
    public void alterar(Requisicao2 requisicao) {
        update(requisicao);
    }
 
    public void excluir(int id) {
    	Requisicao2 requisicao = findById(id);
        delete(requisicao);
    }
}

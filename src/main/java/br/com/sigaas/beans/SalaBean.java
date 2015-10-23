package br.com.sigaas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import modelo2.Sala;
import modelo2.SalaDao;


@ManagedBean()
@RequestScoped
public class SalaBean {
	Sala sala;
	
	SalaDao dao;
	
	public SalaBean() {
		sala = new Sala();
		dao = new SalaDao();
	}
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public void salvar(ActionEvent actionEvent){
		try {
			dao.salvar(sala);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = new Sala();
	}
}

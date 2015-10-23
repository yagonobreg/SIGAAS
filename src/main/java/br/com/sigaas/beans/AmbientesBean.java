package br.com.sigaas.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Ambiente;
import br.com.sigaas.modelo.Usuario;
import br.com.sigaas.servicos.ServicoAmbiente;
import br.com.sigaas.servicos.ServicoUsuario;

@ManagedBean
@ViewScoped
public class AmbientesBean {
private static final long serialVersionUID = 1L;
	
	private SimpleEntityManager simpleEntityManager;
	private ServicoAmbiente servicoAmbiente;
	private ArrayList<Ambiente> ambientes;
	private Ambiente ambienteSelecionado;
	private ArrayList<Ambiente> ambientesSelecionados;
	
	public AmbientesBean() {
		simpleEntityManager = new SimpleEntityManager("sigaasPU");
		servicoAmbiente = new ServicoAmbiente(simpleEntityManager);
		ambientes = (ArrayList<Ambiente>) servicoAmbiente.findAll();
		simpleEntityManager.close();
	}
	
	public ArrayList<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(ArrayList<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	public Ambiente getAmbienteSelecionado() {
		return ambienteSelecionado;
	}

	public void setAmbienteSelecionado(Ambiente ambienteSelecionado) {
		this.ambienteSelecionado = ambienteSelecionado;
	}

	public ArrayList<Ambiente> getAmbientesSelecionados() {
		return ambientesSelecionados;
	}

	public void setAmbientesSelecionados(ArrayList<Ambiente> ambientesSelecionados) {
		this.ambientesSelecionados = ambientesSelecionados;
	}
}

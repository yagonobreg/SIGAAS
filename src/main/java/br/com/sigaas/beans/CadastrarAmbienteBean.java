package br.com.sigaas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Ambiente;
import br.com.sigaas.modelo.InformacaoLogin;
import br.com.sigaas.modelo.Papel;
import br.com.sigaas.modelo.Usuario;
import br.com.sigaas.servicos.ServicoAmbiente;
import br.com.sigaas.servicos.ServicoPapel;
import br.com.sigaas.servicos.ServicoUsuario;

@ManagedBean
@RequestScoped
public class CadastrarAmbienteBean {
	private SimpleEntityManager simpleEntityManager;
	private ServicoAmbiente servicoAmbiente;
	private Ambiente ambiente;
	public CadastrarAmbienteBean() {
		ambiente = new Ambiente();	
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public void salvarAmbiente(){
		simpleEntityManager = new SimpleEntityManager("sigaasPU");
		servicoAmbiente = new ServicoAmbiente(simpleEntityManager);
		servicoAmbiente.save(ambiente);
		simpleEntityManager.close();
		ambiente = new Ambiente();
	}
	
}

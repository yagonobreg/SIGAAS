package br.com.sigaas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.InformacaoLogin;
import br.com.sigaas.modelo.Papel;
import br.com.sigaas.modelo.Usuario;
import br.com.sigaas.servicos.ServicoPapel;
import br.com.sigaas.servicos.ServicoUsuario;
@ManagedBean
@RequestScoped
public class CadastrarChefeDepartamentoBean {
	private SimpleEntityManager simpleEntityManager;
	private ServicoUsuario servicoUsuario;
	private Usuario usuario;
	private Papel papel;
	private InformacaoLogin informacaoLogin;
	public CadastrarChefeDepartamentoBean() {
		usuario = new Usuario();
		papel = new Papel();
		informacaoLogin = new InformacaoLogin();
		papel.setNome("Chefe de departamento");
		usuario.addPapel(papel);
		usuario.setInformacaoLogin(informacaoLogin);
	}
	public Papel getPapel() {
		return papel;
	}
	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	public InformacaoLogin getInformacaoLogin() {
		return informacaoLogin;
	}
	public void setInformacaoLogin(InformacaoLogin informacaoLogin) {
		this.informacaoLogin = informacaoLogin;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void salvarChefe(){
		simpleEntityManager = new SimpleEntityManager("sigaasPU");
		ServicoUsuario servicoUsuario = new ServicoUsuario(simpleEntityManager);
		servicoUsuario.save(usuario);
		simpleEntityManager.close();
		usuario = new Usuario();
		informacaoLogin = new InformacaoLogin();
		papel = new Papel();
	}
}

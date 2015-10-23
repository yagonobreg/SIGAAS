package br.com.sigaas.beans;

import java.util.ArrayList;

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
public class CadastrarAlunoBean {
	private SimpleEntityManager simpleEntityManager;
	private ServicoUsuario servicoUsuario;
	private Usuario usuario;
	private InformacaoLogin informacaoLogin;
	public CadastrarAlunoBean() {
		usuario = new Usuario();
		informacaoLogin = new InformacaoLogin();
		usuario.setInformacaoLogin(informacaoLogin);
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
	public void salvarAluno(){
		System.out.println("Telefone: "+usuario.getTelefone());
		System.out.println("Email: "+usuario.getEmail());
		simpleEntityManager = new SimpleEntityManager("sigaasPU");
		ServicoUsuario servicoUsuario = new ServicoUsuario(simpleEntityManager);
		ServicoPapel servicoPapel = new ServicoPapel(simpleEntityManager);
		Papel papelAluno = servicoPapel.getPapelAluno();
		usuario.addPapel(papelAluno);
		servicoUsuario.save(usuario);
		simpleEntityManager.close();
		usuario = new Usuario();
		informacaoLogin = new InformacaoLogin();
		System.out.println("cadastrado");
	}
	
}

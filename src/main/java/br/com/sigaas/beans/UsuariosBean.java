package br.com.sigaas.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sigaas.servicos.ServicoUsuario;
import br.com.sigaas.gerenciadores.SimpleEntityManager;
import br.com.sigaas.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuariosBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private SimpleEntityManager simpleEntityManager;
	private ServicoUsuario servicoUsuario;
	private ArrayList<Usuario> usuarios;
	private Usuario usuarioSelecionado;
	private ArrayList<Usuario> usuariosSelecionados;
	public UsuariosBean() {
		simpleEntityManager = new SimpleEntityManager("sigaasPU");
		ServicoUsuario servicoUsuario = new ServicoUsuario(simpleEntityManager);
		usuarios = (ArrayList<Usuario>) servicoUsuario.findAll();
		simpleEntityManager.close();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Usuario> getUsuariosSelecionados() {
		return usuariosSelecionados;
	}

	public void setUsuariosSelecionados(ArrayList<Usuario> usuariosSelecionados) {
		this.usuariosSelecionados = usuariosSelecionados;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
}

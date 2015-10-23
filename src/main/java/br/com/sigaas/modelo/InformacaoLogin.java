package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class InformacaoLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String login;

	private String senha;

	@OneToOne
	@JoinColumn (name="usuario")
	private Usuario usuario;

	public InformacaoLogin() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
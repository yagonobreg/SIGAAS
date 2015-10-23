package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Papel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private String nomeDepartamento;


	@ManyToMany(mappedBy="papeis")
	private List<Usuario> usuarios;

	public Papel() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeDepartamento() {
		return this.nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
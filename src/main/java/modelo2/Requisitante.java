package modelo2;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the requisitante database table.
 * 
 */
@Entity
@NamedQuery(name="Requisitante.findAll", query="SELECT r FROM Requisitante r")
public class Requisitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Column(name="requisitante_role")
	private String requisitanteRole;

	//bi-directional many-to-one association to Requisicao
	@OneToMany(mappedBy="requisitante")
	private List<Requisicao2> requisicoes;

	public Requisitante() {}
	
	
	public Requisitante(String email, String requisitanteRole) {
		this.email = email;
		this.requisitanteRole = requisitanteRole;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRequisitanteRole() {
		return this.requisitanteRole;
	}

	public void setRequisitanteRole(String requisitanteRole) {
		this.requisitanteRole = requisitanteRole;
	}

	public List<Requisicao2> getRequisicoes() {
		return this.requisicoes;
	}

	public void setRequisicoes(List<Requisicao2> requisicoes) {
		this.requisicoes = requisicoes;
	}

	public Requisicao2 addRequisicao(Requisicao2 requisicao) {
		getRequisicoes().add(requisicao);
		requisicao.setRequisitante(this);
		return requisicao;
	}

	public Requisicao2 removeRequisicao(Requisicao2 requisicao) {
		getRequisicoes().remove(requisicao);
		requisicao.setRequisitante(null);
		return requisicao;
	}

}
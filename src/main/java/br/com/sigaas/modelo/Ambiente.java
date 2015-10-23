package br.com.sigaas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Ambiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private Integer qtdlugares;

	private String tipo;

	@OneToMany(mappedBy="ambiente")
	private List<Requisicao> requisicoes;

	public Ambiente() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdlugares() {
		return this.qtdlugares;
	}

	public void setQtdlugares(Integer qtdlugares) {
		this.qtdlugares = qtdlugares;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Requisicao> getRequisicoes() {
		return this.requisicoes;
	}

	public void setRequisicoes(List<Requisicao> requisicaos) {
		this.requisicoes = requisicaos;
	}

	public Requisicao addRequisicao(Requisicao requisicao) {
		getRequisicoes().add(requisicao);
		requisicao.setAmbiente(this);

		return requisicao;
	}

	public Requisicao removeRequisicao(Requisicao requisicao) {
		getRequisicoes().remove(requisicao);
		requisicao.setAmbiente(null);
		return requisicao;
	}

}
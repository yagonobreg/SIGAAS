package br.com.sigaas.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Evento extends Requisicao implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descricao;

	private String documento;

	private String nome;

	private String tipoEvento;

	private String tipoOrganizacao;

	public Evento() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoevento() {
		return this.tipoEvento;
	}

	public void setTipoevento(String tipoevento) {
		this.tipoEvento = tipoevento;
	}

	public String getTipoOrganizacao() {
		return this.tipoOrganizacao;
	}

	public void setTipoOrganizacao(String tipoOrganizacao) {
		this.tipoOrganizacao = tipoOrganizacao;
	}

}
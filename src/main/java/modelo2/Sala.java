package modelo2;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private Integer capacidade;

	//bi-directional many-to-one association to Requisicao
	@OneToMany(mappedBy="sala_requisitada")
	private List<Requisicao2> foiRequisitadaEm;

	//bi-directional many-to-one association to Requisicao
	@OneToMany(mappedBy="sala_sugerida")
	private List<Requisicao2> foiSugeridaEm;

	public Sala() {
		
	}
	
	public Sala(String nome, Integer capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacidade() {
		return this.capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public List<Requisicao2> getOndeFoiRequisitada() {
		return this.foiRequisitadaEm;
	}

	public void setOndeFoiRequisitada(List<Requisicao2> foiRequisitadaEm) {
		this.foiRequisitadaEm = foiRequisitadaEm;
	}

	public Requisicao2 addRequisicao(Requisicao2 requisicao) {
		this.getOndeFoiRequisitada().add(requisicao);
		requisicao.setSalaRequisitada(this);
		return requisicao;
	}

	public Requisicao2 removeRequisicao(Requisicao2 requisicao) {
		this.getOndeFoiRequisitada().remove(requisicao);
		requisicao.setSalaRequisitada(null);
		return requisicao;
	}

	public List<Requisicao2> getOndeFoiSugerida() {
		return this.foiSugeridaEm;
	}

	public void setOndeFoiSugerida(List<Requisicao2> foiSugeridaEm) {
		this.foiSugeridaEm = foiSugeridaEm;
	}

	public Requisicao2 addSugestao(Requisicao2 requisicao) {
		this.getOndeFoiSugerida().add(requisicao);
		requisicao.setSalaSugerida(this);
		return requisicao;
	}

	public Requisicao2 removeSugestao(Requisicao2 requisicao) {
		this.getOndeFoiSugerida().remove(requisicao);
		requisicao.setSalaSugerida(null);
		return requisicao;
	}

}
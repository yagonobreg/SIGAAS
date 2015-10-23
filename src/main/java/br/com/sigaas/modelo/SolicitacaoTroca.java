package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;



@Entity
public class SolicitacaoTroca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sequenceGenerator2", strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator2", sequenceName = "solicitacaotroca_id_seq")
	private Integer id;

	private String justificativa;

	
	@ManyToOne
	@JoinColumn(name="requisicao")
	private Requisicao requisicao;

	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

	public SolicitacaoTroca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Requisicao getRequisicaoBean() {
		return this.requisicao;
	}

	public void setRequisicaoBean(Requisicao requisicaoBean) {
		this.requisicao = requisicaoBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuario;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuario = usuarioBean;
	}

}
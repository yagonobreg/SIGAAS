package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.com.sigaas.usertypes.DateArrayType;

import java.util.Date;
import java.util.List;


@Entity
@TypeDefs({ @TypeDef(name = "DateArrayType", typeClass = DateArrayType.class) })
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Requisicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sequenceGenerator", strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "requisicao_id_seq")
	private Integer id;

	private String materiais;
	
	private String papelUsuario;

	private Integer qtdParticipantes;

	private String tipo;
	
	@Type(type = "DateArrayType")
	private Date[] data_requisicao;
	
	public Date[] getData_requisicao() {
		return data_requisicao;
	}

	public void setData_requisicao(Date[] data_requisicao) {
		this.data_requisicao = data_requisicao;
	}


	@ManyToOne
	@JoinColumn(name="ambiente")
	private Ambiente ambiente;


	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

	
	@OneToMany(mappedBy="requisicao")
	private List<SolicitacaoTroca> solicitacoesTroca;

	public Requisicao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateriais() {
		return this.materiais;
	}

	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}

	public String getPapelusuario() {
		return this.papelUsuario;
	}

	public void setPapelUsuario(String papelUsuario) {
		this.papelUsuario = papelUsuario;
	}

	public Integer getQtdparticipantes() {
		return this.qtdParticipantes;
	}

	public void setQtdparticipantes(Integer qtdParticipantes) {
		this.qtdParticipantes = qtdParticipantes;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<SolicitacaoTroca> getSolicitacoesTroca() {
		return this.solicitacoesTroca;
	}

	public void setSolicitacoestroca(List<SolicitacaoTroca> solicitacaotrocas) {
		this.solicitacoesTroca = solicitacaotrocas;
	}

	public SolicitacaoTroca addSolicitacaotroca(SolicitacaoTroca solicitacaotroca) {
		getSolicitacoesTroca().add(solicitacaotroca);
		solicitacaotroca.setRequisicaoBean(this);

		return solicitacaotroca;
	}

	public SolicitacaoTroca removeSolicitacaotroca(SolicitacaoTroca solicitacaotroca) {
		getSolicitacoesTroca().remove(solicitacaotroca);
		solicitacaotroca.setRequisicaoBean(null);

		return solicitacaotroca;
	}

}
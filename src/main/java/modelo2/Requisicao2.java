package modelo2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Requisicao2 implements Serializable {


	public enum status {A, R, D, E}
	
	@Id
	@GeneratedValue(generator = "sequenceGenerator3", strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "sequenceGenerator3", sequenceName = "requisicao_id_seq")
	private Integer id;
	
	private String descricao;

	private String materiais;
	

	@Column(name="qtdPessoas")
	private Integer qtdPessoas;
	
	@Column(name = "horarioInicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horarioInicio;
	
	@Column(name = "horarioFinal")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horarioFinal;
	
	@Column(name="statusRequisicao")
    //@Enumerated(EnumType.STRING)
	private String statusRequisicao;

	private String titulo;

	//bi-directional many-to-one association to Requisitante
	@ManyToOne
	@JoinColumn(name="requisitante_email")
	private Requisitante requisitante;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="sala_requisitada")
	private Sala sala_requisitada;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="sala_sugerida")
	private Sala sala_sugerida;

	public Requisicao2() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMateriais() {
		return this.materiais;
	}

	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}

	public Integer getQtdPessoas() {
		return this.qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getStatusRequisicao() {
		return this.statusRequisicao;
	}

	public void setStatusRequisicao(String statusRequisicao) {
		this.statusRequisicao = statusRequisicao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Requisitante getRequisitante() {
		return this.requisitante;
	}

	public void setRequisitante(Requisitante requisitante) {
		this.requisitante = requisitante;
	}

	public Sala getSalaRequisitada() {
		return this.sala_requisitada;
	}

	public void setSalaRequisitada(Sala sala) {
		this.sala_requisitada = sala;
	}

	public Sala getSalaSugerida() {
		return this.sala_sugerida;
	}

	public void setSalaSugerida(Sala sala) {
		this.sala_sugerida = sala;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
	
}
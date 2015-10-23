package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	
	@Column(columnDefinition = "bpchar(3)")
	private String ddd;

	private String documentoindentificacao;

	private String nome;

	private String telefone;

	@ManyToMany
	@JoinTable(
		name="auladocente"
		, joinColumns={
			@JoinColumn(name="docente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="aula")
			}
		)
	private List<Aula> aulas;

	@OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
	private InformacaoLogin informacaoLogin;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name="papelusuario"
		, joinColumns={
			@JoinColumn(name="usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="papel")
			}
		)
	private List<Papel> papeis;

	
	@OneToMany(mappedBy="usuario")
	private List<Requisicao> requisicoes;

	
	@OneToMany(mappedBy="usuario")
	private List<SolicitacaoTroca> solicitacaotrocas;

	public Usuario() {
		this.solicitacaotrocas = new ArrayList<SolicitacaoTroca>();
		this.requisicoes = new ArrayList<Requisicao>();
		this.papeis = new ArrayList<Papel>();
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDocumentoindentificacao() {
		return this.documentoindentificacao;
	}

	public void setDocumentoindentificacao(String documentoindentificacao) {
		this.documentoindentificacao = documentoindentificacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public InformacaoLogin getInformacaoLogin() {
		return informacaoLogin;
	}

	public void setInformacaoLogin(InformacaoLogin informacaoLogin) {
		this.informacaoLogin = informacaoLogin;
		informacaoLogin.setUsuario(this);
	}

	public List<Papel> getPapeis() {
		return this.papeis;
	}

	public void setPapels(List<Papel> papels) {
		this.papeis = papels;
	}

	public List<Requisicao> getRequisicoes() {
		return this.requisicoes;
	}

	public void setRequisicoes(List<Requisicao> requisicaos) {
		this.requisicoes = requisicaos;
	}
	
	public Papel addPapel(Papel papel) {
		getPapeis().add(papel);
		papel.getUsuarios().add(this);
		return papel;
	}

	public Papel removePapel(Papel papel) {
		getPapeis().remove(papel);
		papel.getUsuarios().remove(this);
		return papel;
	}
	
	public Requisicao addRequisicao(Requisicao requisicao) {
		getRequisicoes().add(requisicao);
		requisicao.setUsuario(this);
		return requisicao;
	}

	public Requisicao removeRequisicao(Requisicao requisicao) {
		getRequisicoes().remove(requisicao);
		requisicao.setUsuario(null);

		return requisicao;
	}

	public List<SolicitacaoTroca> getSolicitacaotrocas() {
		return this.solicitacaotrocas;
	}

	public void setSolicitacaotrocas(List<SolicitacaoTroca> solicitacaotrocas) {
		this.solicitacaotrocas = solicitacaotrocas;
	}

	public SolicitacaoTroca addSolicitacaotroca(SolicitacaoTroca solicitacaotroca) {
		getSolicitacaotrocas().add(solicitacaotroca);
		solicitacaotroca.setUsuarioBean(this);
		return solicitacaotroca;
	}

	public SolicitacaoTroca removeSolicitacaotroca(SolicitacaoTroca solicitacaotroca) {
		getSolicitacaotrocas().remove(solicitacaotroca);
		solicitacaotroca.setUsuarioBean(null);
		return solicitacaotroca;
	}
	
	public String getTelefoneComDDD(){
		return "("+this.getDdd()+")"+this.getTelefone();
	}

}
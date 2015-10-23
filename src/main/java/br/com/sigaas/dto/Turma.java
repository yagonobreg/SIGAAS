package br.com.sigaas.dto;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private String codDisciplina;
	private String nomeDisclina;
	private String nomeTurma;
	private int ano;
	private int periodo;
	private String nivel;
	private List<String> docentes;
	private String tipo;
	private String modalidade;
	private String situação;
	private List<String> horarios;
	private String local;
	private int qtdAlunosMatriculados;
	private int capacidadeTurma;
	
	public Turma(String codDisciplina, String nomeDisclina, String nomeTurma,
			int ano, int periodo, String nivel,
			String tipo, String modalidade, String situação, String local, int qtdAlunosMatriculados,
			int capacidadeTurma) {
		this.codDisciplina = codDisciplina;
		this.nomeDisclina = nomeDisclina;
		this.nomeTurma = nomeTurma;
		this.ano = ano;
		this.periodo = periodo;
		this.nivel = nivel;
		this.docentes = new ArrayList<String>();
		this.tipo = tipo;
		this.modalidade = modalidade;
		this.situação = situação;
		this.horarios = new ArrayList<String>();
		this.local = local;
		this.qtdAlunosMatriculados = qtdAlunosMatriculados;
		this.capacidadeTurma = capacidadeTurma;
	}
	public Turma() {
		this.docentes = new ArrayList<String>();
		this.horarios = new ArrayList<String>();
	}
	public void addDocente(String docente){
		this.docentes.add(docente);
	}
	
	public void addHorario(String horario){
		this.horarios.add(horario);
	}
	
	@Override
	public String toString() {
		return "Turma \n"
				+ "    codDisciplina: " + codDisciplina +"\n"
				+ "    Nome disciplina: "+nomeDisclina +"\n"
				+ "    Nome Turma: " + nomeTurma +"\n"
				+ "    Ano: " + ano +"\n"
				+ "    Periodo: " + periodo + "\n"
				+ "    Nivel: " + nivel + "\n"
				+ "    Docentes: " + docentes + "\n"
				+ "    Tipo: " + tipo + "\n"
				+ "    Modalidade: " + modalidade + "\n"
				+ "    Situação: " + situação + "\n"
				+ "    Horarios: " + horarios+ "\n"
				+ "    Local: " + local + "\n"
				+ "    QtdAlunosMatriculados: " + qtdAlunosMatriculados + "\n"
				+ "    CapacidadeTurma: " + capacidadeTurma + "\n";
	}


	public String getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getNomeDisclina() {
		return nomeDisclina;
	}
	public void setNomeDisclina(String nomeDisclina) {
		this.nomeDisclina = nomeDisclina;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public List<String> getDocentes() {
		return docentes;
	}
	public void setDocentes(List<String> docentes) {
		this.docentes = docentes;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getSituação() {
		return situação;
	}
	public void setSituação(String situação) {
		this.situação = situação;
	}
	public List<String> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getQtdAlunosMatriculados() {
		return qtdAlunosMatriculados;
	}
	public void setQtdAlunosMatriculados(int qtdAlunosMatriculados) {
		this.qtdAlunosMatriculados = qtdAlunosMatriculados;
	}
	public int getCapacidadeTurma() {
		return capacidadeTurma;
	}
	public void setCapacidadeTurma(int capacidadeTurma) {
		this.capacidadeTurma = capacidadeTurma;
	}
	
}

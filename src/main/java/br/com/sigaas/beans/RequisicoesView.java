package br.com.sigaas.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import modelo2.Requisicao2;
import modelo2.RequisicaoDao;
import modelo2.RequisicaoEvent;
import modelo2.Requisitante;
import modelo2.RequisitanteDao;
import modelo2.Sala;
import modelo2.SalaDao;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;



@ManagedBean
@ViewScoped
public class RequisicoesView {

	/**
	 * 
	 */

	private ScheduleModel eventModel;
	private RequisicaoDao dao;
	private RequisitanteDao requisitanteDao;
	private SalaDao salaDao;
	private RequisicaoEvent event;
	private String emailRequisitante;
	private List<String> emailsRequisitantes;
	private String nomeSala;
	private Date diaAgenda;
	
	private List<String> nomesSalas;

	public RequisicoesView() {
		diaAgenda = new Date();
		event = new RequisicaoEvent(new Requisicao2());
		eventModel = new DefaultScheduleModel();
		dao = new RequisicaoDao();
		salaDao = new SalaDao();
		requisitanteDao = new RequisitanteDao();
		List<Requisicao2> requisicoes = null;
		try {
			requisicoes = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			emailsRequisitantes = requisitanteDao.getEmails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			nomesSalas = salaDao.getNomes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Requisicao2 requisicao : requisicoes) {

			RequisicaoEvent evento = new RequisicaoEvent(requisicao);
			eventModel.addEvent(evento);
		}
	}

	public String getEmailRequisitante() {
		return emailRequisitante;
	}

	public void setEmailRequisitante(String emailRequisitante) {
		this.emailRequisitante = emailRequisitante;
	}

	public List<String> completeRequisitante(String query) {
		List<String> emails = new ArrayList<>();
		for (String email : this.emailsRequisitantes) {
			if (email.startsWith(query)) {
				emails.add(email);
			}
		}
		return emails;
	}

	public List<String> completeSala(String query) {
		return nomesSalas;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public RequisicaoEvent getEvent() {
		return event;
	}

	public void setEvent(RequisicaoEvent event) {
		this.event = event;
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (RequisicaoEvent) selectEvent.getObject();
		this.nomeSala = event.getRequisicao().getSalaRequisitada().getNome();
	}

	public void salvar(ActionEvent actionEvent) {

		Requisicao2 requisicao = event.getRequisicao();
		Sala sala = salaDao.findById(this.getNomeSala());
		Requisitante requisitante = requisitanteDao.findById(this
				.getEmailRequisitante());
		if (sala != null && requisitante != null) {
			sala.addRequisicao(requisicao);
			requisitante.addRequisicao(requisicao);
			try {
				dao.salvar(requisicao);
				eventModel.addEvent(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.apagarCampos();
		
	}
	
	private void apagarCampos(){
		this.nomeSala = "";
		this.emailRequisitante = "";
		Requisicao2 requisicao = new Requisicao2();
		requisicao.setStatusRequisicao("pendente");
		this.event = new RequisicaoEvent(requisicao);
	}
	
	public void editar(ActionEvent actionEvent) {

		Requisicao2 requisicao = event.getRequisicao();
		if (!this.getNomeSala().equalsIgnoreCase(
				requisicao.getSalaRequisitada().getNome())) {
			Sala antigaSala = requisicao.getSalaRequisitada();
			Sala novaSala = salaDao.findById(this.getNomeSala());
			if (novaSala != null) {
				antigaSala.removeRequisicao(requisicao);
				novaSala.addRequisicao(requisicao);
			}
		}
		try {
			dao.salvar(requisicao);
			eventModel.updateEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.apagarCampos();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		System.out.println("Date");
		Requisicao2 novaRequisicao = new Requisicao2();
		novaRequisicao.setStatusRequisicao("pendente");
		novaRequisicao.setHorarioInicio((Date) selectEvent.getObject());
		novaRequisicao.setHorarioFinal((Date) (Date) selectEvent.getObject());
		event = new RequisicaoEvent(novaRequisicao);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		RequisicaoEvent evento = (RequisicaoEvent) event.getScheduleEvent();
		dao.salvar(evento.getRequisicao());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		RequisicaoEvent evento = (RequisicaoEvent) event.getScheduleEvent();
		dao.salvar(evento.getRequisicao());
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public Date getDiaAgenda() {
		return diaAgenda;
	}

	public void setDiaAgenda(Date diaAgenda) {
		this.diaAgenda = diaAgenda;
	}
}

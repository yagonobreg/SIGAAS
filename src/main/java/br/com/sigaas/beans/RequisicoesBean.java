package br.com.sigaas.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo2.Requisicao2;
import modelo2.RequisicaoDao;



@ManagedBean
@ViewScoped
public class RequisicoesBean {

	/**
	 * 
	 */

	List<Requisicao2> requisicoes;
	List<Requisicao2> selectedRequisicoes;
	public List<Requisicao2> getSelectedRequisicoes() {
		return selectedRequisicoes;
	}
	public void setSelectedRequisicoes(List<Requisicao2> selectedRequisicoes) {
		this.selectedRequisicoes = selectedRequisicoes;
	}
	public List<Requisicao2> getRequisicoes() {
		return requisicoes;
	}
	public void setRequisicoes(List<Requisicao2> requisicoes) {
		this.requisicoes = requisicoes;
	}
	private RequisicaoDao dao;
	public RequisicoesBean() {
		dao = new RequisicaoDao();
		requisicoes = null;
		try {
			requisicoes = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

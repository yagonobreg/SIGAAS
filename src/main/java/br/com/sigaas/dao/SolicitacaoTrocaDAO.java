package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.SolicitacaoTroca;


public class SolicitacaoTrocaDAO extends DAOgenerico<Integer,SolicitacaoTroca>{
	public SolicitacaoTrocaDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
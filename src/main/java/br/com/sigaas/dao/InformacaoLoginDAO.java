package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.InformacaoLogin;


public class InformacaoLoginDAO extends DAOgenerico<String,InformacaoLogin>{
	public  InformacaoLoginDAO (EntityManager entityManager) {
        super(entityManager);
    }
}
package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.Ambiente;
import br.com.sigaas.modelo.Evento;



public class  EventoDAO extends DAOgenerico<Integer,Evento>{
	public EventoDAO (EntityManager entityManager) {
        super(entityManager);
    }
}
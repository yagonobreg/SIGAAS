package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.Ambiente;

public class AmbienteDAO extends DAOgenerico<String, Ambiente>{
	public AmbienteDAO (EntityManager entityManager) {
        super(entityManager);
    }
}

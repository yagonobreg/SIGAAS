package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.Aula;

public class AulaDAO extends DAOgenerico<Integer, Aula>{
	public AulaDAO (EntityManager entityManager) {
        super(entityManager);
    }
}

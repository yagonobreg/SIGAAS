package br.com.sigaas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.Papel;


public class PapelDAO extends DAOgenerico<String,Papel>{
	public PapelDAO  (EntityManager entityManager) {
        super(entityManager);
    }

}
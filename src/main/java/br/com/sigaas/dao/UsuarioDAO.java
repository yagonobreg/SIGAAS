package br.com.sigaas.dao;

import javax.persistence.EntityManager;

import br.com.sigaas.modelo.Usuario;


public class UsuarioDAO extends DAOgenerico<String,Usuario>{
	public  UsuarioDAO (EntityManager entityManager) {
        super(entityManager);
    }
}
package br.mw.conc.model.persistencia;

/**
 * Classe que gerencia o acesso ao banco de dados. 
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author marcos
 * 
 */
public class FabricaEntityManager {

	private static EntityManager entityManager = null;

	/*
	 * @return EntityManager - Retorna um EntityManager caso exista. Se não,
	 * cria um, e então o retorna.
	 */
	public static EntityManager obtemEntityManager() {
		if (entityManager != null) {
			return entityManager;
		} else {
			EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("concurseiro");
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		}
	}

}

package br.mw.conc.model.persistencia;

/**
 * Classe com as funcionalidades para acesso ao banco de dados.
 * Especificamente com métodos para gerenciar a tabela pergunta no bd.
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.mw.conc.model.Pergunta;

/**
 * @author marcos
 * 
 */
public class PerguntaDAO {

	private EntityManager entityManager;

	public PerguntaDAO() {
		entityManager = FabricaEntityManager.obtemEntityManager();
	}

	public void add(Pergunta pergunta) {
		entityManager.getTransaction().begin();
		entityManager.persist(pergunta);
		entityManager.getTransaction().commit();
	}

	public void update(Pergunta pergunta) {
		entityManager.getTransaction().begin();
		entityManager.merge(pergunta);
		entityManager.getTransaction().commit();
	}

	public void del(Pergunta pergunta) {
		entityManager.getTransaction().begin();
		entityManager.remove(pergunta);
		entityManager.getTransaction().commit();
	}

	public Pergunta busca(long codPergunta) {
		Pergunta pergunta = entityManager.find(Pergunta.class, codPergunta);
		return pergunta;
	}

	public List<Pergunta> lista() {
		Query query = entityManager.createQuery("SELECT p FROM Pergunta p");
		List<Pergunta> perguntas = query.getResultList();
		return perguntas;
	}

	public Pergunta ultimoRegistro() {
		Query query;
		query = entityManager
				.createQuery("SELECT p FROM Pergunta p ORDER BY cod desc");
		query.setMaxResults(1);
		Pergunta pergunta = (Pergunta) query.getSingleResult();
		return pergunta;
	}

}

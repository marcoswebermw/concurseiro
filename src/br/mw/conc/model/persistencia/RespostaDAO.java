package br.mw.conc.model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.mw.conc.model.Resposta;

public class RespostaDAO {

	private EntityManager entityManager;

	public RespostaDAO() {
		entityManager = FabricaEntityManager.obtemEntityManager();
	}

	public void add(Resposta resposta) {
		entityManager.getTransaction().begin();
		entityManager.persist(resposta);
		entityManager.getTransaction().commit();
		// TODO: Lançar uma nova exceção caso ocorra algum erro de integridade
		// referencial
		// por falta de pergunta para a resposta.
	}

	public void update(Resposta resposta) {
		entityManager.getTransaction().begin();
		entityManager.merge(resposta);
		entityManager.getTransaction().commit();
	}

	public void del(Resposta resposta) {
		entityManager.getTransaction().begin();
		entityManager.remove(resposta);
		entityManager.getTransaction().commit();
	}

	public Resposta busca(long codResposta) {
		Resposta resposta = entityManager.find(Resposta.class, codResposta);
		return resposta;
	}

	public List<Resposta> buscaRespostaPergunta(long codPergunta) {
		Query query = entityManager
				.createQuery("SELECT r FROM Resposta r WHERE fk_pergunta_cod = "
						+ codPergunta);
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

	public List<Resposta> lista() {
		Query query = entityManager.createQuery("SELECT r FROM Resposta r");
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

	public Resposta ultimoRegistro() {
		Query query;
		query = entityManager
				.createQuery("SELECT r FROM Resposta r ORDER BY cod desc");
		query.setMaxResults(1);
		Resposta resposta = (Resposta) query.getSingleResult();
		return resposta;
	}

}

package br.mw.conc.controller;

import java.util.List;

import br.mw.conc.model.Resposta;
import br.mw.conc.model.persistencia.RespostaDAO;

public class RespostaController {

	public void adicionar(Resposta resposta) {
		// TODO: Verificar se a resposta tem uma pergunta relacionada
		// se não então lançar uma excessão.
		// throw new RuntimeException("Não existe pergunta para esta resposta");
		new RespostaDAO().add(resposta);
	}

	public void atualizar(Resposta resposta) {
		new RespostaDAO().update(resposta);
	}

	public void deletar(Resposta resposta) {
		new RespostaDAO().del(resposta);
	}

	public Resposta buscar(long codResposta) {
		return new RespostaDAO().busca(codResposta);
	}

	public List<Resposta> buscaRespostaPergunta(long codPergunta){
		return new RespostaDAO().buscaRespostaPergunta(codPergunta);
	}
	
	public List<Resposta> listar() {
		return new RespostaDAO().lista();
	}

	public Resposta RetornaUltimoRegistro() {
		return new RespostaDAO().ultimoRegistro();
	}
}

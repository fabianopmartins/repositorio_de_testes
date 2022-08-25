package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Pergunta;
import javassist.tools.rmi.ObjectNotFoundException;

public interface PerguntaService {

	Pergunta search(Integer id) throws ObjectNotFoundException;

	List<Pergunta> searchAll();

	Pergunta save(Pergunta pergunta);

	Pergunta edit(Pergunta pergunta) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Avaliacao;
import javassist.tools.rmi.ObjectNotFoundException;

public interface AvaliacaoService {

	Avaliacao search(Integer id) throws ObjectNotFoundException;

	List<Avaliacao> searchAll();

	Avaliacao save(Avaliacao avaliacao);

	Avaliacao edit(Avaliacao avaliacao) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
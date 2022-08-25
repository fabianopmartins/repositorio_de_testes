package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Resposta;
import javassist.tools.rmi.ObjectNotFoundException;

public interface RespostaService {

	Resposta search(Integer id) throws ObjectNotFoundException;

	List<Resposta> searchAll();

	Resposta save(Resposta resposta);

	Resposta edit(Resposta resposta) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
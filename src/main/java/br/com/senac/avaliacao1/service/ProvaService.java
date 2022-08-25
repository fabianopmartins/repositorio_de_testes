package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Prova;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ProvaService {

	Prova search(Integer id) throws ObjectNotFoundException;

	List<Prova> searchAll();

	Prova save(Prova prova);

	Prova edit(Prova prova) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
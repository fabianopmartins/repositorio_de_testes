package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Permissao;
import javassist.tools.rmi.ObjectNotFoundException;

public interface PermissaoService {
	
	Permissao search(Integer id) throws ObjectNotFoundException;
	
	List<Permissao> searchAll();

	Permissao findByNomePermissao(String nomePermissao);
	
	Permissao save(Permissao permissao	);

	Permissao edit(Permissao permissao) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface UsuarioService {

	Usuario search(Integer id) throws ObjectNotFoundException;

	Usuario findByEmail(String email);
	
	List<Usuario> searchAll();

	Usuario save(Usuario usuario);

	Usuario edit(Usuario usuario) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
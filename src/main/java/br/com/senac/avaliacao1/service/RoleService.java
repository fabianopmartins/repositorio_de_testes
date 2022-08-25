package br.com.senac.avaliacao1.service;

import java.util.List;

import br.com.senac.avaliacao1.entity.Role;
import javassist.tools.rmi.ObjectNotFoundException;

public interface RoleService {
	
	Role search(Integer id) throws ObjectNotFoundException;
	
	List<Role> searchAll();

	Role findByNomeRole(String nomeRole);
	
	Role save(Role role	);

	Role edit(Role role) throws ObjectNotFoundException;
	
	void delete(Integer id);
}
package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.avaliacao1.entity.Role;
import br.com.senac.avaliacao1.repository.RoleRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public Role search(Integer id) throws ObjectNotFoundException {
		Optional<Role> role = repository.findById(id);

		return role.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Role.class.getName()));
	}
	
	public List<Role> searchAll() {
		return repository.findAll();
	}

	public Role findByNomeRole(String nomeRole) {
		return repository.findByNomeRole(nomeRole);
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}

	public Role edit(Role role) throws ObjectNotFoundException {
		Role roleAntigo = search(role.getId());
		roleAntigo.setNomeRole(role.getNomeRole());
		return save(roleAntigo);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
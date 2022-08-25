package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.avaliacao1.entity.Permissao;
import br.com.senac.avaliacao1.repository.PermissaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Transactional
@Service
public class PermissaoServiceImpl implements PermissaoService {

	@Autowired
	private PermissaoRepository repository;

	public Permissao search(Integer id) throws ObjectNotFoundException {
		Optional<Permissao> permissao = repository.findById(id);

		return permissao.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Permissao.class.getName()));
	}

	public List<Permissao> searchAll() {
		return repository.findAll();
	}

	public Permissao findByNomePermissao(String nomePermissao) {
		return repository.findByNomePermissao(nomePermissao);
	}

	public Permissao save(Permissao permissao) {
		return repository.save(permissao);
	}

	public Permissao edit(Permissao permissao) throws ObjectNotFoundException {
		Permissao permissaoAntiga = search(permissao.getId());
		permissaoAntiga.setNomePermissao(permissao.getNomePermissao());
		return save(permissaoAntiga);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
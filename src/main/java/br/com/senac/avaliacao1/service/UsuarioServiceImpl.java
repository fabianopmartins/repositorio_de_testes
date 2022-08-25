package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.senac.avaliacao1.entity.Usuario;
import br.com.senac.avaliacao1.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario search(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> usuario = repository.findById(id);

		return usuario.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Usuario.class.getName()));
	}

	@Override
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public List<Usuario> searchAll() {
		return repository.findAll();
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario edit(Usuario usuario) throws ObjectNotFoundException {
		Usuario usuarioAntigo = search(usuario.getId());
		usuarioAntigo.setNome(usuario.getNome());
		usuarioAntigo.setEmail(usuario.getEmail());
		usuarioAntigo.setAvaliacoes(usuario.getAvaliacoes());
		usuarioAntigo.setRoles(usuario.getRoles());
		usuarioAntigo.setPermissoes(usuario.getPermissoes());
		return save(usuarioAntigo);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Usuario usuarioLogado() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = this.findByEmail(email);
		return usuario;
	}
}
package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.avaliacao1.entity.Prova;
import br.com.senac.avaliacao1.repository.ProvaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProvaServiceImpl implements ProvaService {

	@Autowired
	private ProvaRepository repository;

	public Prova search(Integer id) throws ObjectNotFoundException {
		Optional<Prova> prova = repository.findById(id);

		return prova.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Prova.class.getName()));
	}

	public List<Prova> searchAll() {
		return repository.findAll();
	}

	public Prova save(Prova prova) {
		return repository.save(prova);
	}

	public Prova edit(Prova prova) throws ObjectNotFoundException {
		Prova provaAntigo = search(prova.getId());
		provaAntigo.setNome(prova.getNome());
		provaAntigo.setAvaliacoes(prova.getAvaliacoes());
		provaAntigo.setPerguntas(prova.getPerguntas());
		return save(provaAntigo);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
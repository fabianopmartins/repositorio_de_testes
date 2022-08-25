package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.avaliacao1.entity.Pergunta;
import br.com.senac.avaliacao1.repository.PerguntaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PerguntaServiceImpl implements PerguntaService {

	@Autowired
	private PerguntaRepository repository;

	public Pergunta search(Integer id) throws ObjectNotFoundException {
		Optional<Pergunta> pergunta = repository.findById(id);

		return pergunta.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Pergunta.class.getName()));
	}

	public List<Pergunta> searchAll() {
		return repository.findAll();
	}
	
	public Pergunta save(Pergunta pergunta) {
		return repository.save(pergunta);
	}

	public Pergunta edit(Pergunta pergunta) throws ObjectNotFoundException {
		Pergunta perguntaAntigo = search(pergunta.getId());
		perguntaAntigo.setDescricao(pergunta.getDescricao());
		perguntaAntigo.setProva(pergunta.getProva());
		return save(perguntaAntigo);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
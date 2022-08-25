package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.avaliacao1.entity.Avaliacao;
import br.com.senac.avaliacao1.repository.AvaliacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;

	public Avaliacao search(Integer id) throws ObjectNotFoundException {
		Optional<Avaliacao> avaliacao = repository.findById(id);

		return avaliacao.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Avaliacao.class.getName()));
	}

	public List<Avaliacao> searchAll() {
		return repository.findAll();
	}

	public Avaliacao save(Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}

	public Avaliacao edit(Avaliacao avaliacao) throws ObjectNotFoundException {
		Avaliacao avaliacaoAntigo = search(avaliacao.getId());
		avaliacaoAntigo.setNota(avaliacao.getNota());
		avaliacaoAntigo.setUsuario(avaliacao.getUsuario());
		avaliacaoAntigo.setProva(avaliacao.getProva());
		return save(avaliacaoAntigo);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
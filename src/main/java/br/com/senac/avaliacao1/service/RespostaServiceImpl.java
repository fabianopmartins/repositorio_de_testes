package br.com.senac.avaliacao1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.avaliacao1.entity.Resposta;
import br.com.senac.avaliacao1.repository.RespostaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class RespostaServiceImpl implements RespostaService {

	@Autowired
	private RespostaRepository repository;

	public Resposta search(Integer id) throws ObjectNotFoundException {
		Optional<Resposta> resposta = repository.findById(id);

		return resposta.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Resposta.class.getName()));
	}

	public List<Resposta> searchAll() {
		return repository.findAll();
	}

	public Resposta save(Resposta resposta) {
		return repository.save(resposta);
	}

	public Resposta edit(Resposta resposta) throws ObjectNotFoundException {
		Resposta respostaAntigo = search(resposta.getId());
		respostaAntigo.setDescricao(resposta.getDescricao());
		return save(respostaAntigo);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
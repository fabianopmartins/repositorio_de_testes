package br.com.senac.avaliacao1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.avaliacao1.entity.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

	void deleteByNomePermissao(String nomePermissao);
	
	Permissao findByNomePermissao(String nomeRole);
}
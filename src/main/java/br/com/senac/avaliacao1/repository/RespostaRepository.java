package br.com.senac.avaliacao1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.avaliacao1.entity.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Integer> {

}
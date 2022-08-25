package br.com.senac.avaliacao1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.avaliacao1.entity.Prova;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Integer> {

}
package br.com.senac.avaliacao1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "prova")
public class Prova implements Serializable {

	private static final long serialVersionUID = -1246443037599365027L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prova_id")
	private Integer id;

	@Column(name = "prova_nome")
	private String nome;

	@OneToMany(mappedBy = "prova")
	@Cascade(CascadeType.ALL)
	private List<Avaliacao> avaliacoes;

	@OneToMany(mappedBy = "prova")
	@Cascade(CascadeType.ALL)
	private List<Pergunta> perguntas;

	public Prova() {

	}

	public Prova(Integer id, String nome, List<Avaliacao> avaliacoes, List<Pergunta> perguntas) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacoes = avaliacoes;
		this.perguntas = perguntas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
package br.com.senac.avaliacao1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 6032619900325542576L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pergunta_id")
	private Integer id;

	@Column(name = "pergunta_descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "prova_id", nullable = false)
	private Prova prova;
	
	public Pergunta() {

	}

	public Pergunta(Integer id, String descricao, Prova prova) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.prova = prova;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
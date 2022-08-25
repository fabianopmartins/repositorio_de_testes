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
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 8243593896981944923L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "avaliacao_id")
	private Integer id;
	
	@Column(name = "avaliacao_nota")
	private double nota;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "prova_id")
	private Prova prova;

	public Avaliacao() {

	}

	public Avaliacao(Integer id, double nota, Usuario usuario, Prova prova) {
		super();
		this.id = id;
		this.nota = nota;
		this.usuario = usuario;
		this.prova = prova;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
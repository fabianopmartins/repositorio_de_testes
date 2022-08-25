package br.com.senac.avaliacao1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable {

	private static final long serialVersionUID = -599045659274566848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resposta_id")
	private Integer id;

	@Column(name = "resposta_descricao")
	private String descricao;

	@OneToOne
	@JoinColumn(name = "pergunta_id", nullable = false)
	private Pergunta pergunta;
	
	public Resposta() {

	}

	public Resposta(Integer id, String descricao, Pergunta pergunta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pergunta = pergunta;
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

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
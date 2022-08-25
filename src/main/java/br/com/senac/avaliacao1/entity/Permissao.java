package br.com.senac.avaliacao1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = -6513184330627444989L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_permissao")
	private String nomePermissao;

	@ManyToMany(mappedBy = "permissoes")
	@JsonProperty(access = Access.READ_ONLY)
	private List<Usuario> usuarios;

	public Permissao() {

	}

	public Permissao(Integer id, String nomePermissao, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nomePermissao = nomePermissao;
		this.usuarios = usuarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getAuthority() {
		return this.nomePermissao;
	}
}
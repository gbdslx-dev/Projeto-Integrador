package com.generation.projetointegrador.example.ProjetoIntegrador.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_vendedor")
public class VendedorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 4, max = 100)
	private String nome_vendedor;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 100)
	private String email_contato;
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 25)
	private String senha;	
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 15)
	private String tel_contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_vendedor() {
		return nome_vendedor;
	}

	public void setNome_vendedor(String nome_vendedor) {
		this.nome_vendedor = nome_vendedor;
	}

	public String getEmail_contato() {
		return email_contato;
	}

	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTel_contato() {
		return tel_contato;
	}

	public void setTel_contato(String tel_contato) {
		this.tel_contato = tel_contato;
	}
}

package com.generation.projetointegrador.example.ProjetoIntegrador.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_Produto")

public class ProdutoModel {
				
			@Id
			@GeneratedValue (strategy = GenerationType.IDENTITY)
			private Long idProduto;
			
			@NotNull
			@Size (min = 3, max = 50) 
			private String nomeProduto;
			
			@NotNull
			private Float valor;
			
			@NotNull
			@Size (min = 5, max = 255)
			private String descricao;
			
			@Size (min = 5, max = 2000)
			private String urlImagem;

			public Long getIdProduto() {
				return idProduto;
			}

			public void setIdProduto(Long idProduto) {
				this.idProduto = idProduto;
			}

			public String getNomeProduto() {
				return nomeProduto;
			}

			public void setNomeProduto(String nomeProduto) {
				this.nomeProduto = nomeProduto;
			}

			public Float getValor() {
				return valor;
			}

			public void setValor(Float valor) {
				this.valor = valor;
			}

			public String getDescricao() {
				return descricao;
			}

			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}

			public String getUrlImagem() {
				return urlImagem;
			}

			public void setUrlImagem(String urlImagem) {
				this.urlImagem = urlImagem;
			}

			

	}

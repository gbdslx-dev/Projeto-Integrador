package com.generation.projetointegrador.example.ProjetoIntegrador.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.PrioridadeEnum;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.RegiaoEnum;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.TipoEnum;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produtos;

	
	
	public PrioridadeEnum prioridade;
	public RegiaoEnum regiao;
	public TipoEnum tipo;
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public List<ProdutoModel> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}
	public RegiaoEnum getRegiao() {
		return regiao;
	}
	public void setRegiao(RegiaoEnum regiao) {
		this.regiao = regiao;
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	
	
	
}



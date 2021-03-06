package com.generation.projetointegrador.example.ProjetoIntegrador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	
	public List<ProdutoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
}

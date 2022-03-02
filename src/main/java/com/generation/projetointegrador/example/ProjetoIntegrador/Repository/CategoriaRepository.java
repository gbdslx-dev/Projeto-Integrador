package com.generation.projetointegrador.example.ProjetoIntegrador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	public List<CategoriaModel> findAllByPrioridade (String prioridade);
	public List<CategoriaModel> findAllByRegiao (String regiao);
	public List<CategoriaModel> findAllByTipo (String tipo);

}
package com.generation.projetointegrador.example.ProjetoIntegrador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.CategoriaModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.PrioridadeEnum;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.RegiaoEnum;
import com.generation.projetointegrador.example.ProjetoIntegrador.Util.TipoEnum;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	public List<CategoriaModel> findAllByPrioridade (PrioridadeEnum prioridade);
	public List<CategoriaModel> findAllByRegiao (RegiaoEnum regiao);
	public List<CategoriaModel> findAllByTipo (TipoEnum tipo);

}
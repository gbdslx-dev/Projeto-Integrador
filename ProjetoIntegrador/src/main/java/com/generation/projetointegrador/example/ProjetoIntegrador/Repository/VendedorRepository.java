package com.generation.projetointegrador.example.ProjetoIntegrador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.VendedorModel;

public interface VendedorRepository extends JpaRepository<VendedorModel, Long>{

	public List<VendedorModel> findAllByNomeVendedorContainingIgnoreCase(String nomeVendedor);
}

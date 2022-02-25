package com.generation.projetointegrador.example.ProjetoIntegrador.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<UsuarioModel> findByEmailContato(String username);
}

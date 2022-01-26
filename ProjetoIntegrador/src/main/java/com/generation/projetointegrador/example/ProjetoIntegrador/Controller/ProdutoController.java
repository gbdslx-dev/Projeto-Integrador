package com.generation.projetointegrador.example.ProjetoIntegrador.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.ProdutoModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.ProdutoRepository;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping ("/nome/{nomeproduto}")
	public ResponseEntity<List<ProdutoModel>> FindByNome (@PathVariable String nomeproduto) {
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeproduto));
		
	}
}

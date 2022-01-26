package com.generation.projetointegrador.example.ProjetoIntegrador.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll() {
		List<ProdutoModel> list = repository.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findByIDProduto(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nomeproduto}")
	public ResponseEntity<List<ProdutoModel>> FindByNome (@PathVariable String nomeproduto) {
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeproduto));
		
	}
	@PostMapping
	public ResponseEntity<ProdutoModel> putProdutoModel(@RequestBody ProdutoModel nomeProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeProduto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel nomeProduto){
		return ResponseEntity.ok(repository.save(nomeProduto));
	}
	
	@DeleteMapping("{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}


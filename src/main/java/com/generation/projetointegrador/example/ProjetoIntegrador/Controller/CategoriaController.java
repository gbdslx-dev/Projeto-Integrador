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

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.CategoriaModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@SuppressWarnings("hiding")
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAll() {
		List<CategoriaModel> list = repository.findAll();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}	
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriaModel> findByIDCategoria(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CategoriaModel>> findByTipo(@PathVariable String tipo){
		List<CategoriaModel> list = repository.findAllByTipo(tipo);
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}	
	}
	
	@GetMapping("/regiao/{regiao}")
	public ResponseEntity<List<CategoriaModel>> findByRegiao(@PathVariable String regiao){
		List<CategoriaModel> list = repository.findAllByRegiao(regiao);
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}	
	}
	@GetMapping("/prioridade/{prioridade}")
	public ResponseEntity<List<CategoriaModel>> findByPrioridade(@PathVariable String prioridade){
		List<CategoriaModel> list = repository.findAllByPrioridade(prioridade);
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}	
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
}

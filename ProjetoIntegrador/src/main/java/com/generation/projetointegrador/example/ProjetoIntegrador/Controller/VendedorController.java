package com.generation.projetointegrador.example.ProjetoIntegrador.Controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.UserLogin;
import com.generation.projetointegrador.example.ProjetoIntegrador.Model.VendedorModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.VendedorRepository;
import com.generation.projetointegrador.example.ProjetoIntegrador.Service.VendedorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorRepository repository;
	
	@Autowired
	private VendedorService service;
		
	@GetMapping("/email/{email}")
	public ResponseEntity<VendedorModel> GetByEmail(@PathVariable String email){
		return repository.findByEmailContato(email)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/nome/{nomevendedor}")
	public ResponseEntity<List<VendedorModel>> findByNome(@PathVariable String nomevendedor){
		List<VendedorModel> list = repository.findAllByNomeVendedorContainingIgnoreCase(nomevendedor);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}
	
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
		return service.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());	
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<VendedorModel> Post(@RequestBody VendedorModel user){
		return service.CadastrarVendedor(user)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElseGet(() -> { 
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor já cadastrado!");
				});
	}
	
	
	@PutMapping
	public ResponseEntity<VendedorModel> putVendedor(@RequestBody VendedorModel nomeVendedor) {
		return ResponseEntity.ok(repository.save(nomeVendedor));
	}

	@DeleteMapping("{id}")
	public void deleteVendedor(@PathVariable long id) {
		repository.deleteById(id);
	}

}

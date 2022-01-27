package com.generation.projetointegrador.example.ProjetoIntegrador.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.VendedorModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.VendedorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorRepository repository;
	
	@GetMapping("/nome/{nomevendedor}")
	public ResponseEntity<List<VendedorModel>> findByNome(@PathVariable String nomevendedor){
		List<VendedorModel> list = repository.findAllByNomeVendedorContainingIgnoreCase(nomevendedor);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}
}

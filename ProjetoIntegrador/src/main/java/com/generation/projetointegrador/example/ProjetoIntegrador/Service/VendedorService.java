package com.generation.projetointegrador.example.ProjetoIntegrador.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.VendedorModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	
	public Optional<VendedorModel> CadastrarVendedor(VendedorModel vendedor){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		Optional<VendedorModel> retorno;
		Optional<VendedorModel> vendedorUsuario = repository.findByEmailContato(vendedor.getEmailContato());
		
		if (vendedorUsuario.isEmpty()) {
			String senhaEncoder = encoder.encode(vendedor.getSenha());
			vendedor.setSenha(senhaEncoder);
			repository.save(vendedor);
			retorno = Optional.of(vendedor);
		
		} else {retorno = Optional.empty();}

		return retorno;
		
	}
}


		
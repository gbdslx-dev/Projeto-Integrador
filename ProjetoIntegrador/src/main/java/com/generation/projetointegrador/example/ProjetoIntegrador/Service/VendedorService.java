package com.generation.projetointegrador.example.ProjetoIntegrador.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.UserLogin;
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
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<VendedorModel> vendedorEmail = repository.findByEmailContato(user.get().getEmail());
		
		if (vendedorEmail.isPresent()) {
			if(encoder.matches(user.get().getSenha(), vendedorEmail.get().getSenha())) {
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				
				user.get().setNome(vendedorEmail.get().getNomeVendedor());
				
				return user;
			}
		}
		
		return null;
	}
	
}


		
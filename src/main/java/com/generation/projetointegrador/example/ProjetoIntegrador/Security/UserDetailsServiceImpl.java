package com.generation.projetointegrador.example.ProjetoIntegrador.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.VendedorModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.VendedorRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private  VendedorRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<VendedorModel> user = repository.findByEmailContato(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
		
		return user.map(UserDetailsImpl :: new).get();	
	}

}

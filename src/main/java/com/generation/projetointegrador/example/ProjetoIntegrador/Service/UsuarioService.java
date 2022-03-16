package com.generation.projetointegrador.example.ProjetoIntegrador.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.projetointegrador.example.ProjetoIntegrador.Model.UserLogin;
import com.generation.projetointegrador.example.ProjetoIntegrador.Model.UsuarioModel;
import com.generation.projetointegrador.example.ProjetoIntegrador.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<UsuarioModel> CadastrarUsuario(UsuarioModel Usuario){
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		Optional<UsuarioModel> retorno;
		Optional<UsuarioModel> UsuarioVerifica = repository.findByEmailContato(Usuario.getEmailContato());
		
		if (UsuarioVerifica.isEmpty()) {
			String senhaEncoder = criptografarSenha(Usuario.getSenha());
			Usuario.setSenha(senhaEncoder);
			repository.save(Usuario);
			retorno = Optional.of(Usuario);
		
		} else {retorno = Optional.empty();}

		return retorno;		
	}
	
	public String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(senhaDigitada, senhaBanco);

	}
	
	public Optional<UsuarioModel> AtualizarUsuario(UsuarioModel Usuario){
		Optional<UsuarioModel> UsuarioVerifica = repository.findById(Usuario.getId());
		if(UsuarioVerifica.isPresent()) {
			if(compararSenhas(Usuario.getSenha(), UsuarioVerifica.get().getSenha())) {
				UsuarioVerifica.get().setEmailContato(Usuario.getEmailContato());
				UsuarioVerifica.get().setFoto(Usuario.getFoto());
				UsuarioVerifica.get().setNome(Usuario.getNome());
				UsuarioVerifica.get().setProdutos(Usuario.getProdutos());
				UsuarioVerifica.get().setTelContato(Usuario.getTelContato());
				UsuarioVerifica.get().setTipo(Usuario.getTipo());
				
				repository.save(UsuarioVerifica.get());
				return UsuarioVerifica;
			}
		}
		
		return Optional.empty();
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<UsuarioModel> usuarioemail = repository.findByEmailContato(user.get().getEmail());
		
		if (usuarioemail.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuarioemail.get().getSenha())) {
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				
				user.get().setId(usuarioemail.get().getId());				
				user.get().setNome(usuarioemail.get().getNome());
				user.get().setTipo(usuarioemail.get().getTipo());
				user.get().setFoto(usuarioemail.get().getFoto());
				
				
				return user;
			}
		}
		
		return null;
	}
	
}


		
package br.com.foursys.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.foursys.forum.model.Usuario;
import br.com.foursys.forum.repository.UsuarioRepository;

public class AtualizarUsuarioForm {

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String senha;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		return usuario;
	}
	
}

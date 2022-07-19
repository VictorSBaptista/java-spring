package br.com.foursys.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.foursys.forum.model.Resposta;


/**
 * Classe responsável por armazenar atributos devolvidos nas requisições
 * @author Victor Baptista
 * @since 18/05/2021
 * @version 1.0
 */

public class RespostaDto {

	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeUsuario;
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.dataCriacao = resposta.getDataCriacao();
		this.nomeUsuario = resposta.getUsuario().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	
	
}

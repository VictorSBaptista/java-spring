package br.com.foursys.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Classe Hello para dar sorte no SpringBoot
 * @author Victor Baptista
 * @since 117/05/2021
 * @version 1.0
 */

@Controller
public class HelloController {

	@RequestMapping("/")//anotação para mapeamento da requisição do navegador
	@ResponseBody//anotação que controla a exibição do conteúdo em vez de procurar uma página com o contexto retornado
	public String hello() {
		return "Hello World!";
	}
}

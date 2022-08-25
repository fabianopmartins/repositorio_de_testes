package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Avaliacao;
import br.com.senac.avaliacao1.entity.Pergunta;
import br.com.senac.avaliacao1.entity.Prova;
import br.com.senac.avaliacao1.entity.Resposta;
import br.com.senac.avaliacao1.entity.Usuario;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/paginaLogin");
		return mv;
	}
	
	@GetMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		return mv;
	}
	
	@GetMapping("/aside")
	public ModelAndView aside() {
		ModelAndView mv = new ModelAndView("fragments/aside");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		return mv;
	}
	
	@GetMapping("/cadastros")
	public ModelAndView formFuncionalidadess() {
		ModelAndView mv = new ModelAndView("/cadastros");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("avaliacao", new Avaliacao());
		mv.addObject("pergunta", new Pergunta());
		mv.addObject("pessoa", new Usuario());
		mv.addObject("prova", new Prova());
		mv.addObject("resposta", new Resposta());
		return mv;
	}
}
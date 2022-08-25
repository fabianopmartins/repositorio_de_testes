package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Prova;
import br.com.senac.avaliacao1.service.AvaliacaoServiceImpl;
import br.com.senac.avaliacao1.service.PerguntaServiceImpl;
import br.com.senac.avaliacao1.service.ProvaServiceImpl;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("prova")
public class ProvaController {

	@Autowired
	private ProvaServiceImpl provaServiceImpl;

	@Autowired
	private AvaliacaoServiceImpl avaliacaoServiceImpl;

	@Autowired
	private PerguntaServiceImpl perguntaServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("prova/tabelaProva");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("provas", provaServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastra")
	public ModelAndView cadastra() {
		ModelAndView mv = new ModelAndView("prova/formProvaModal");
		mv.addObject("avaliacoes", avaliacaoServiceImpl.searchAll());
		mv.addObject("perguntas", perguntaServiceImpl.searchAll());
		mv.addObject("prova", new Prova());
		return mv;
	}

	@GetMapping("/altera/{id}")
	public ModelAndView altera(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("prova/alteraProvaModal");
		mv.addObject("perguntas", perguntaServiceImpl.searchAll());
		mv.addObject("prova", provaServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/altera")
	public ModelAndView altera(Prova prova) throws ObjectNotFoundException {
		provaServiceImpl.edit(prova);
		return lista();
	}

	@PostMapping("/salvaProva")
	public String salva(Prova prova) {
		provaServiceImpl.save(prova);
		return "redirect:/cadastros";
	}
	
	@GetMapping("/deletaProva/{id}")
	public ModelAndView deleta(@PathVariable("id") Integer id) {
		provaServiceImpl.delete(id);
		return lista();
	}
}
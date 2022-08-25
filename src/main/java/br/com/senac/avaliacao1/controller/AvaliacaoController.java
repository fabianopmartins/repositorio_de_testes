package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Avaliacao;
import br.com.senac.avaliacao1.service.AvaliacaoServiceImpl;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;
import br.com.senac.avaliacao1.service.ProvaServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoServiceImpl avaliacaoServiceImpl;

	@Autowired
	private ProvaServiceImpl provaServiceImpl;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("avaliacao/tabelaAvaliacao");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("avaliacoes", avaliacaoServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastra")
	public ModelAndView cadastra() {
		ModelAndView mv = new ModelAndView("avaliacao/formAvaliacaoModal");
		mv.addObject("provas", provaServiceImpl.searchAll());
		mv.addObject("usuarios", usuarioServiceImpl.searchAll());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}

	@GetMapping("/altera/{id}")
	public ModelAndView altera(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("avaliacao/alteraAvaliacaoModal");
		mv.addObject("provas", provaServiceImpl.searchAll());
		mv.addObject("usuarios", usuarioServiceImpl.searchAll());
		mv.addObject("avaliacao", avaliacaoServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/altera")
	public ModelAndView altera(Avaliacao avaliacao) throws ObjectNotFoundException {
		avaliacaoServiceImpl.edit(avaliacao);
		return lista();
	}

	@PostMapping("/salva")
	public String salva(Avaliacao avaliacao) {
		avaliacaoServiceImpl.save(avaliacao);
		return "redirect:/cadastros";
	}
	
	@GetMapping("/deleta/{id}")
	public ModelAndView deleta(@PathVariable("id") Integer id) {
		avaliacaoServiceImpl.delete(id);
		return lista();
	}
}
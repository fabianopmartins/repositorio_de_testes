package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Pergunta;
import br.com.senac.avaliacao1.service.PerguntaServiceImpl;
import br.com.senac.avaliacao1.service.ProvaServiceImpl;
import br.com.senac.avaliacao1.service.RespostaServiceImpl;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("pergunta")
public class PerguntaController {

	@Autowired
	private PerguntaServiceImpl perguntaServiceImpl;

	@Autowired
	private ProvaServiceImpl provaServiceImpl;

	@Autowired
	private RespostaServiceImpl respostaServiceImpl;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("pergunta/tabelaPergunta");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("perguntas", perguntaServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastra")
	public ModelAndView cadastra() {
		ModelAndView mv = new ModelAndView("pergunta/formPerguntaModal");
		mv.addObject("provas", provaServiceImpl.searchAll());
		mv.addObject("respostas", respostaServiceImpl.searchAll());
		mv.addObject("pergunta", new Pergunta());
		return mv;
	}
	
	@GetMapping("/altera/{id}")
	public ModelAndView altera(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("pergunta/alteraPerguntaModal");
		mv.addObject("provas", provaServiceImpl.searchAll());
		mv.addObject("respostas", respostaServiceImpl.searchAll());
		mv.addObject("pergunta", perguntaServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/altera")
	public ModelAndView altera(Pergunta pergunta) throws ObjectNotFoundException {
		perguntaServiceImpl.edit(pergunta);
		return lista();
	}

	@PostMapping("/salva")
	public String salva(Pergunta pergunta) {
		perguntaServiceImpl.save(pergunta);
		return "redirect:/cadastros";
	}
	
	@GetMapping("/deleta/{id}")
	public ModelAndView deleta(@PathVariable("id") Integer id) {
		perguntaServiceImpl.delete(id);
		return lista();
	}
}
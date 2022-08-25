package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Resposta;
import br.com.senac.avaliacao1.service.PerguntaServiceImpl;
import br.com.senac.avaliacao1.service.RespostaServiceImpl;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("resposta")
public class RespostaController {

	@Autowired
	private RespostaServiceImpl respostaServiceImpl;

	@Autowired
	private PerguntaServiceImpl perguntaServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("resposta/tabelaResposta");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("respostas", respostaServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/cadastra")
	public ModelAndView cadastra() {
		ModelAndView mv = new ModelAndView("resposta/formRespostaModal");
		mv.addObject("perguntas", perguntaServiceImpl.searchAll());
		mv.addObject("resposta", new Resposta());
		return mv;
	}

	@GetMapping("/altera/{id}")
	public ModelAndView altera(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("resposta/alteraRespostaModal");
		mv.addObject("perguntas", perguntaServiceImpl.searchAll());
		mv.addObject("resposta", respostaServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/altera")
	public ModelAndView altera(Resposta resposta) throws ObjectNotFoundException {
		respostaServiceImpl.edit(resposta);
		return lista();
	}

	@PostMapping("/salva")
	public String salva(Resposta resposta) {
		respostaServiceImpl.save(resposta);
		return "redirect:/cadastros";
	}
	
	@GetMapping("/deleta/{id}")
	public ModelAndView deleta(@PathVariable("id") Integer id) {
		respostaServiceImpl.delete(id);
		return lista();
	}
}
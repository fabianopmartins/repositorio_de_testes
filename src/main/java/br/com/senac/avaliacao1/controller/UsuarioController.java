package br.com.senac.avaliacao1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.avaliacao1.entity.Permissao;
import br.com.senac.avaliacao1.entity.Role;
import br.com.senac.avaliacao1.entity.Usuario;
import br.com.senac.avaliacao1.service.PermissaoServiceImpl;
import br.com.senac.avaliacao1.service.RoleServiceImpl;
import br.com.senac.avaliacao1.service.UsuarioServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private PermissaoServiceImpl permissaoServiceImpl;

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	@GetMapping("/role")
	public ModelAndView role() {
		ModelAndView mv = new ModelAndView("usuario/formRoleModal");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("role", new Role());
		return mv;
	}

	@GetMapping("/permissao")
	public ModelAndView permissao() {
		ModelAndView mv = new ModelAndView("usuario/formPermissaoModal");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("permissao", new Permissao());
		return mv;
	}

	@GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("usuario/tabelaUsuario");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("roles", roleServiceImpl.searchAll());
		mv.addObject("usuarios", usuarioServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/listaRole")
	public ModelAndView listaRole() {
		ModelAndView mv = new ModelAndView("usuario/tabelaRole");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("roles", roleServiceImpl.searchAll());
		return mv;
	}

	@GetMapping("/listaPermissao")
	public ModelAndView listaPermissao() {
		ModelAndView mv = new ModelAndView("usuario/tabelaPermissao");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("permissoes", permissaoServiceImpl.searchAll());
		;
		return mv;
	}

	@GetMapping("/cadastra")
	public ModelAndView cadastra() {
		ModelAndView mv = new ModelAndView("usuario/formUsuarioModal");
		mv.addObject("usuarioLogado", usuarioServiceImpl.usuarioLogado());
		mv.addObject("roles", roleServiceImpl.searchAll());
		mv.addObject("permissoes", permissaoServiceImpl.searchAll());
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@GetMapping("/altera/{id}")
	public ModelAndView altera(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/alteraUsuarioModal");
		mv.addObject("permissoes", permissaoServiceImpl.searchAll());
		mv.addObject("roles", roleServiceImpl.searchAll());
		mv.addObject("usuario", usuarioServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraRole/{id}")
	public ModelAndView alteraRole(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/alteraRoleModal");
		mv.addObject("role", roleServiceImpl.search(id));
		return mv;
	}

	@GetMapping("/alteraPermissao/{id}")
	public ModelAndView alteraPermissao(@PathVariable("id") Integer id)
			throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("usuario/alteraPermissaoModal");
		mv.addObject("permissao", permissaoServiceImpl.search(id));
		return mv;
	}

	@PostMapping("/altera")
	public ModelAndView altera(Usuario usuario) throws ObjectNotFoundException {
		usuarioServiceImpl.edit(usuario);
		return lista();
	}

	@PostMapping("/alteraRole")
	public ModelAndView alteraRole(Role role) throws ObjectNotFoundException {
		roleServiceImpl.edit(role);
		return listaRole();
	}

	@PostMapping("/alteraPermissao")
	public ModelAndView alteraPermissao(Permissao permissao) throws ObjectNotFoundException {
		permissaoServiceImpl.edit(permissao);
		return listaPermissao();
	}

	@PostMapping("/salva")
	public String salva(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuarioServiceImpl.save(usuario);
		return "redirect:/cadastros";
	}
	
	@PostMapping("/salvaRole")
	public String salvaRole(Role role) {
		roleServiceImpl.save(role);
		return "redirect:/cadastros";
	}

	@PostMapping("/salvaPermissao")
	public String salvaPermissao(Permissao permissao) {
		permissaoServiceImpl.save(permissao);
		return "redirect:/cadastros";
	}
	
	@GetMapping("/deleta/{id}")
	public ModelAndView deleta(@PathVariable("id") Integer id) {
		usuarioServiceImpl.delete(id);
		return lista();
	}
	
	@GetMapping("/deletaRole/{id}")
	public ModelAndView deletaRole(@PathVariable("id") Integer id) {
		roleServiceImpl.delete(id);
		return listaRole();
	}
	
	@GetMapping("/deletaPermissao/{id}")
	public ModelAndView deletaPermissao(@PathVariable("id") Integer id) {
		permissaoServiceImpl.delete(id);
		return listaPermissao();
	}
}
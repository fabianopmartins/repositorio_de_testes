package br.com.senac.avaliacao1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CurrentUserDatailService currentUserDatailService;

	private static String[] PUBLIC_MATCHERS_GET = { "/inicio", "/avaliacoes", "/respostas" };
	private static String[] PRIVATE_MATCHERS_GET = { "/cadastros", "/avaliacao/cadastra", "/pergunta/lista",
			"/pergunta/cadastra", "/prova/cadastra", "/prova/lista", "/resposta/cadastra", "/usuario/cadastra",
			"/usuario/lista", "/usuario/alunos" };
	private static String[] PRIVATE_MATCHERS_POST = { "/avaliacao/salva", "/pergunta/salva", "/prova/salva",
			"/resposta/salva", "/usuario/salva" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
				.antMatchers(HttpMethod.GET, PRIVATE_MATCHERS_GET).hasAnyRole("ADMIN", "TEACHER")	
				.antMatchers(HttpMethod.POST, PRIVATE_MATCHERS_POST).hasAnyRole("ADMIN", "TEACHER")
				.antMatchers(HttpMethod.GET, PRIVATE_MATCHERS_GET).hasAnyAuthority("insert", "alter", "delete")
				.antMatchers(HttpMethod.POST, PRIVATE_MATCHERS_POST).hasAnyAuthority("insert", "alter", "delete")
				.anyRequest().authenticated().and()
				.formLogin().loginProcessingUrl("/signin").loginPage("/login").permitAll()
				.usernameParameter("txtUsername").passwordParameter("txtPassword").permitAll()
				.defaultSuccessUrl("/inicio", true).permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**", "/assets/**", "/templates/**", "/resources/**");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(currentUserDatailService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
package br.com.senac.avaliacao1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Avaliacao1Application {

	public static void main(String[] args) {
		SpringApplication.run(Avaliacao1Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
}
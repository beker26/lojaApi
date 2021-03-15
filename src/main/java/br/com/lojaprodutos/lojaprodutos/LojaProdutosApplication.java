package br.com.lojaprodutos.lojaprodutos;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LojaProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaProdutosApplication.class, args);
	}

}

package br.com.lojaprodutos.lojaprodutos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lojaprodutos.lojaprodutos.model.Loja;

public class LojaDto {

	private Long id;
	private String nome;

	public LojaDto(Loja loja) {
		this.id = loja.getId();
		this.nome = loja.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static List<LojaDto> listLojaDto(List<Loja> listLoja) {
		return listLoja.stream().map(LojaDto::new).collect(Collectors.toList());
	}

}

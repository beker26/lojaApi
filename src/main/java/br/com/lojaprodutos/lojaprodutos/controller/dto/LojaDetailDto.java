package br.com.lojaprodutos.lojaprodutos.controller.dto;

import java.util.List;

import java.util.stream.Collectors;


import br.com.lojaprodutos.lojaprodutos.model.Loja;

public class LojaDetailDto {

	private String nome;
	private List<ProdutoDto> produto;

	public LojaDetailDto(Loja findByNome) {
		this.nome = findByNome.getNome();
		this.produto = ProdutoDto.convert(findByNome.getProdutos());
	}

	public String getNome() {
		return nome;
	}

	public List<ProdutoDto> getProduto() {
		return produto;
	}

	public static List<LojaDetailDto> converter(List<Loja> lojaDetail) {
		
		return lojaDetail.stream().map(LojaDetailDto::new).collect(Collectors.toList());
	}


}

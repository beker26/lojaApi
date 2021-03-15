package br.com.lojaprodutos.lojaprodutos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lojaprodutos.lojaprodutos.model.Produto;

public class ProdutoDto {

	private Long id;
	private String marca;
	private String descricao;
	private int quantidade;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.marca = produto.getMarca();
		this.descricao = produto.getDescricao();
		this.quantidade = produto.getQuantidade();
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public static List<ProdutoDto> convert(List<Produto> produtos) {
		
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}

	public static List<ProdutoDto> listProdutoDto(List<Produto> listProduto) {
		return listProduto.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}



}

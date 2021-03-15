package br.com.lojaprodutos.lojaprodutos.controller.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lojaprodutos.lojaprodutos.model.Produto;

public class ProdutoForm {

	@NotNull @NotEmpty @Length(min = 2)
	private String marca;
	@NotNull @NotEmpty @Length(min = 3)
	private String descricao;
	@NotNull 
	private int quantidade;

	public ProdutoForm() {
	}

	public ProdutoForm(Produto produto) {
		this.marca = produto.getMarca();
		this.descricao = produto.getDescricao();
		this.quantidade = produto.getQuantidade();
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

	public Produto toProduto() {

		return new Produto(this.getMarca(), this.getDescricao(), this.getQuantidade());
	}

}

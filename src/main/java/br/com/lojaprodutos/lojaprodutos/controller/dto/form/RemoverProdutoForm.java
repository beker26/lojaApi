package br.com.lojaprodutos.lojaprodutos.controller.dto.form;

import javax.validation.constraints.NotNull;

public class RemoverProdutoForm {
	
	@NotNull
	private Long produtoId;

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

}

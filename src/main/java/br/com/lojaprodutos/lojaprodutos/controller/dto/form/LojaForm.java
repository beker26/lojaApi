package br.com.lojaprodutos.lojaprodutos.controller.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.lojaprodutos.lojaprodutos.model.Loja;

public class LojaForm {

	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	public LojaForm() {}
	public LojaForm(Loja loja) {

		this.nome = loja.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Loja toLoja() {
		return new Loja(this.getNome());
	}

}

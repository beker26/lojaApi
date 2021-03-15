package br.com.lojaprodutos.lojaprodutos.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



import br.com.lojaprodutos.lojaprodutos.controller.dto.ProdutoDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.ProdutoForm;
import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;

@RestController
@RequestMapping(value = "/v1/produto")
public interface ProdutoControllerApi {
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<List<ProdutoDto>> findAll();
	@GetMapping(value = "/{nomeProduto}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<List<ProdutoDto>> findByNome(@PathVariable String nomeProduto);
	@PostMapping
	@Transactional
	ResponseEntity<ProdutoDto> insert(@Validated @RequestBody ProdutoForm form, UriComponentsBuilder uriBuilder);
	@PutMapping("/{produtoId}")
	@Transactional
	ResponseEntity<ProdutoDto> update(@PathVariable Long produtoId, @RequestBody @Validated ProdutoForm form)throws BusinessException;
	@DeleteMapping("/{produtoId}")
	@Transactional
	ResponseEntity<Void> delete(@PathVariable Long produtoId) throws BusinessException;

}

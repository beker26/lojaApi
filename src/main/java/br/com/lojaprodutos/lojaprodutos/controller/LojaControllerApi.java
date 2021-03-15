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

import br.com.lojaprodutos.lojaprodutos.controller.dto.LojaDetailDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.LojaDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.CadastrarProdutoForm;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.LojaForm;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.RemoverProdutoForm;

import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;



@RestController
@RequestMapping(value = "/v1/loja")
public interface LojaControllerApi {
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<List<LojaDto>> findAll();
	@GetMapping(value = "/{nomeLoja}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<List<LojaDetailDto>> findByNome(@PathVariable String nomeLoja);
	@PostMapping
	@Transactional
	ResponseEntity<LojaDto> insert(@Validated @RequestBody LojaForm form, UriComponentsBuilder uriBuilder);
	@PutMapping("/{lojaId}")
	@Transactional
	ResponseEntity<LojaDto> update(@PathVariable Long lojaId, @RequestBody @Validated LojaForm form)throws BusinessException;
	@PostMapping("/{lojaId}/cadastrarProduto")
	@Transactional
	ResponseEntity<LojaDetailDto> cadastrarProduto(@PathVariable Long lojaId, @RequestBody @Validated CadastrarProdutoForm form) throws BusinessException;
	@DeleteMapping("/{lojaId}")
	@Transactional
	ResponseEntity<Void> delete(@PathVariable Long lojaId) throws BusinessException;
	@PutMapping("/{lojaId}/removerProduto")
	@Transactional
	ResponseEntity<LojaDetailDto> removerProduto(@PathVariable Long lojaId, @RequestBody @Validated RemoverProdutoForm form)throws BusinessException;
	
	
	
	
	

}

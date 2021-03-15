package br.com.lojaprodutos.lojaprodutos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lojaprodutos.lojaprodutos.controller.dto.LojaDetailDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.ProdutoDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.ProdutoForm;
import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;
import br.com.lojaprodutos.lojaprodutos.model.Produto;
import br.com.lojaprodutos.lojaprodutos.service.produto.ProdutoService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ProdutoController implements ProdutoControllerApi {
	
	private ProdutoService produtoService;
    
    public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
    @Override
	public ResponseEntity<List<ProdutoDto>> findAll() {
    	log.info("Starting Method FindAll in ProdutoController!");
		List<Produto> listProduto = this.produtoService.findAll();
		List<ProdutoDto> produtoDto = ProdutoDto.listProdutoDto(listProduto);
		log.info("Finishing Method FindAll in ProdutoController!");
		return ResponseEntity.ok().body(produtoDto);
	}

	@Override
	public ResponseEntity<List<ProdutoDto>> findByNome(String nomeProduto) {
		log.info("Starting Method findByNome in ProdutoController");
		log.info("Parameter nome = {}", nomeProduto);
		List<Produto> produto = produtoService.findByNome(nomeProduto);
		List<ProdutoDto> listProdutoDto = ProdutoDto.listProdutoDto(produto);
		log.info("Converting Produto to ProdutoDto");
		log.info("Finishing Method findByNome in ProdutoController!");
		return ResponseEntity.ok().body(listProdutoDto);
	}

	@Override
	public ResponseEntity<ProdutoDto> insert(ProdutoForm form, UriComponentsBuilder uriBuilder) {
		log.info("Starting Method insert in ProdutoController!");
		log.info("Form: {}", form);
		Produto produto = produtoService.insert(form.toProduto());
		log.info("Finishing Method insert in ProdutoController!");
		URI uri = uriBuilder.path("/produto/{produtoId}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	@Override
	public ResponseEntity<ProdutoDto> update(Long produtoId, ProdutoForm form) throws BusinessException {
		log.info("Starting Method Update in ProdutoController!");
		log.info("Form: {}", form);
		Produto produto = produtoService.update(produtoId, form.toProduto());
		log.info("Finishing Method Update in ProdutoController!");
		return ResponseEntity.ok().body(new ProdutoDto(produto));
	}

	@Override
	public ResponseEntity<Void> delete(Long produtoId) throws BusinessException {
		log.info("Starting Method Delete in ProdutoController!");
		log.info("Parameter nome = {}", produtoId);
		produtoService.delete(produtoId);
		log.info("Finishing Method Delete in ProdutoController!");
		return ResponseEntity.noContent().build();
	}

}

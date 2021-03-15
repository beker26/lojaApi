package br.com.lojaprodutos.lojaprodutos.controller;

import java.net.URI;
import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lojaprodutos.lojaprodutos.controller.dto.LojaDetailDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.LojaDto;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.CadastrarProdutoForm;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.LojaForm;
import br.com.lojaprodutos.lojaprodutos.controller.dto.form.RemoverProdutoForm;
import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;
import br.com.lojaprodutos.lojaprodutos.model.Loja;
import br.com.lojaprodutos.lojaprodutos.service.loja.LojaService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class LojaController implements LojaControllerApi {

	private LojaService lojaService;

	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}

	@Override
	public ResponseEntity<List<LojaDto>> findAll() {
		log.info("Starting Method FindAll in LojaController!");
		List<Loja> listLoja = this.lojaService.findAll();
		List<LojaDto> lojaDto = LojaDto.listLojaDto(listLoja);
		log.info("Finishing Method FindAll in LojaController!");
		return ResponseEntity.ok().body(lojaDto);
	}

	@Override
	public ResponseEntity<List<LojaDetailDto>> findByNome(String nomeLoja) {
		log.info("Starting Method findByNome in LojaController");
		log.info("Parameter nome = {}", nomeLoja);
        List<Loja> loja = lojaService.findByNome(nomeLoja);
        List<LojaDetailDto> lojaDetailDto = LojaDetailDto.converter(loja);
        log.info("Converting Loja to LojaDto");
		log.info("Finishing Method findByNome in LojaController!");
		return  ResponseEntity.ok().body(lojaDetailDto);
	}

	@Override
	public ResponseEntity<LojaDto> insert(LojaForm form, UriComponentsBuilder uriBuilder) {
		log.info("Starting Method insert in LojaController!");
		log.info("Form: {}", form);
		Loja loja = lojaService.insert(form.toLoja());
		log.info("Finishing Method insert in LojaController!");
		URI uri = uriBuilder.path("/loja/{lojaId}").buildAndExpand(loja.getId()).toUri();
		return ResponseEntity.created(uri).body(new LojaDto(loja));
	}

	@Override
	public ResponseEntity<LojaDto> update(Long lojaId, LojaForm form) throws BusinessException {
		log.info("Starting Method Update in LojaController!");
		log.info("Form: {}", form);
		Loja loja = lojaService.update(lojaId, form.toLoja());
		log.info("Finishing Method Update in LojaController!");
		return ResponseEntity.ok().body(new LojaDto(loja));
	}

	@Override
	public ResponseEntity<Void> delete(Long lojaId) throws BusinessException {
		log.info("Starting Method Delete in LojaController!");
		log.info("Parameter nome = {}", lojaId);
		lojaService.delete(lojaId);
		log.info("Finishing Method Delete in LojaController!");
		return ResponseEntity.noContent().build();
	}
	
	@Override
	public ResponseEntity<LojaDetailDto> cadastrarProduto(Long lojaId, CadastrarProdutoForm form) throws BusinessException {
		log.info("Starting Method cadastrarProduto in LojaController!");
		Loja loja = lojaService.cadastrarProduto(lojaId, form.getProdutoId());
		log.info("Finishing Method cadastrarProduto in LojaController!");
		return ResponseEntity.ok().body(new LojaDetailDto(loja));
	}

	@Override
	public ResponseEntity<LojaDetailDto> removerProduto(Long lojaId, RemoverProdutoForm form) throws BusinessException {
		log.info("Starting Method cadastrarProduto in removerProduto!");
		Loja loja = lojaService.removerProduto(lojaId, form.getProdutoId());
		log.info("Finishing Method removerProduto in LojaController!");
		return ResponseEntity.ok().body(new LojaDetailDto(loja));
	}

	



}

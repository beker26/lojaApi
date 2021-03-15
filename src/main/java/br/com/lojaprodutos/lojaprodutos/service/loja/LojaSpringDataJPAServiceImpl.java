package br.com.lojaprodutos.lojaprodutos.service.loja;

import java.util.List;

import org.springframework.stereotype.Service;


import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;

import br.com.lojaprodutos.lojaprodutos.model.Loja;
import br.com.lojaprodutos.lojaprodutos.model.Produto;
import br.com.lojaprodutos.lojaprodutos.repository.LojaRepository;
import br.com.lojaprodutos.lojaprodutos.repository.ProdutoRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LojaSpringDataJPAServiceImpl implements LojaService {

	private LojaRepository lojaRepository;
	private ProdutoRepository produtoRepository;

	public LojaSpringDataJPAServiceImpl(LojaRepository lojaRepository, ProdutoRepository produtoRepository) {
		this.lojaRepository = lojaRepository;
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Loja> findAll() {
		log.info("Starting Method findAll in LojaSpringDataJPAServiceImpl");
		log.info("finishing Method findAll in LojaSpringDataJPAServiceImpl");
		return lojaRepository.findAll();
	}

	@Override
	public List<Loja> findByNome(String nome) {
		log.info("Starting Method findByNome in LojaSpringDataJPAServiceImpl");
		log.info("Parameter:Loja nome = {},", nome);
		if(nome == null || nome.isEmpty()) {
			return null;
		}
		log.info("finishing Method findByNome in LojaSpringDataJPAServiceImpl");
		return lojaRepository.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public Loja insert(Loja lojaObj) {
		log.info("Starting Method insert in LojaSpringDataJPAServiceImpl");
		log.info("finishing Method insert in LojaSpringDataJPAServiceImpl");
		return lojaRepository.save(lojaObj);
	}

	@Override
	public Loja update(Long lojaId, Loja lojaObj) throws BusinessException {
		log.info("Starting Method update in LojaSpringDataJPAServiceImpl");
		log.info("Parameter:Loja id = {},", lojaId);
		Loja findByidLoja = lojaRepository.findById(lojaId)
				.orElseThrow(() -> new BusinessException("A Loja não existe"));
		findByidLoja.update(lojaObj);
		log.info("finishing Method update in LojaSpringDataJPAServiceImpl");
		return lojaRepository.save(findByidLoja);
	}

	@Override
	public void delete(Long lojaId) throws BusinessException {
		log.info("Starting Method delete in LojaSpringDataJPAServiceImpl");
		log.info("Parameter:Loja id = {},", lojaId);
		Loja findByIdLoja = lojaRepository.findById(lojaId)
				.orElseThrow(() -> new BusinessException("A Loja não existe"));
		log.info("finishing Method delete in LojaSpringDataJPAServiceImpl");
		lojaRepository.delete(findByIdLoja);
	}

	@Override
	public Loja cadastrarProduto(Long lojaId, Long produtoId) throws BusinessException {
		log.info("Starting Method cadastrarProduto in LojaSpringDataJPAServiceImpl");
		log.info("Parameter:Loja id = {},", lojaId);
		Loja findByIdLoja = lojaRepository.findById(lojaId)
				.orElseThrow(() -> new BusinessException("A Loja não existe"));
		log.info("Parameter:Produto id = {},", produtoId);
		Produto findByIdProduto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new BusinessException("O produto não existe"));
		findByIdLoja.cadastrarProduto(findByIdProduto);
		Loja loja = lojaRepository.save(findByIdLoja);
		log.info("finishing Method cadastrarProduto in LojaSpringDataJPAServiceImpl");
		return loja;
	}

	@Override
	public Loja removerProduto(Long lojaId, Long produtoId) throws BusinessException {
		log.info("Starting Method removerProduto in LojaSpringDataJPAServiceImpl");
		log.info("Parameter:Loja id = {},", lojaId);
		Loja findByIdLoja = lojaRepository.findById(lojaId)
				.orElseThrow(() -> new BusinessException("A Loja não existe"));
		log.info("Parameter:Produto id = {},", produtoId);
		Produto findByIdProduto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new BusinessException("O produto não existe"));
		findByIdLoja.removerProdutoNaLoja(findByIdProduto);
		Loja loja = lojaRepository.save(findByIdLoja);
		log.info("finishing Method removerProduto in LojaSpringDataJPAServiceImpl");
		return loja;
	}

	


}

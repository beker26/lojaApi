package br.com.lojaprodutos.lojaprodutos.service.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;
import br.com.lojaprodutos.lojaprodutos.model.Produto;
import br.com.lojaprodutos.lojaprodutos.repository.LojaRepository;
import br.com.lojaprodutos.lojaprodutos.repository.ProdutoRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProdutoSpringDataJPAServiceImpl implements ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoSpringDataJPAServiceImpl(ProdutoRepository produtoRepository) {

		this.produtoRepository = produtoRepository;

	}

	@Override
	public List<Produto> findAll() {
		log.info("Starting Method findAll in ProdutoSpringDataJPAService");
		log.info("finishing Method findAll in ProdutoSpringDataJPAService");
		return produtoRepository.findAll();
	}

	@Override
	public List<Produto> findByNome(String nomeProduto) {
		log.info("Starting Method findByNome in ProdutoSpringDataJPAService");
		log.info("Parameter:Produto nome = {},", nomeProduto);
		if (nomeProduto.isEmpty() || nomeProduto == null) {
			return null;
		}
		log.info("finishing Method findByNome in ProdutoSpringDataJPAService");
		return produtoRepository.findByMarcaContainingIgnoreCase(nomeProduto);
	}

	@Override
	public Produto insert(Produto produto) {
		log.info("Starting Method insert in ProdutoSpringDataJPAService");
		log.info("finishing Method insert in ProdutoSpringDataJPAService");
		return produtoRepository.save(produto);

	}

	@Override
	public Produto update(Long produtoId, Produto produto) throws BusinessException {
		log.info("Starting Method update in ProdutoSpringDataJPAService");
		log.info("Parameter:Produto id = {},", produtoId);
		Produto produtoById = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new BusinessException("O produto não existe"));
		log.info("finishing Method update in ProdutoSpringDataJPAService");
		return produtoRepository.save(produtoById);
	}

	@Override
	public void delete(Long produtoId) throws BusinessException {
		log.info("Starting Method delete in ProdutoSpringDataJPAService");
		log.info("Parameter:Produto id = {},", produtoId);
		Produto produtoById = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new BusinessException("O produto não existe"));
		log.info("finishing Method delete in ProdutoSpringDataJPAService");
		produtoRepository.delete(produtoById);
	}

}

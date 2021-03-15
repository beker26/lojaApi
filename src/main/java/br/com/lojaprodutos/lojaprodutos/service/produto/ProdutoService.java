package br.com.lojaprodutos.lojaprodutos.service.produto;

import java.util.List;

import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;
import br.com.lojaprodutos.lojaprodutos.model.Produto;

public interface ProdutoService {

	List<Produto> findAll();

	List<Produto> findByNome(String nomeProduto);

	Produto insert(Produto produto);

	Produto update(Long produtoId, Produto produto)throws BusinessException;

	void delete(Long produtoId)throws BusinessException;

	

}

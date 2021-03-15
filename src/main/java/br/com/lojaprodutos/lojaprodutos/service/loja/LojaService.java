package br.com.lojaprodutos.lojaprodutos.service.loja;

import java.util.List;



import br.com.lojaprodutos.lojaprodutos.exception.BusinessException;
import br.com.lojaprodutos.lojaprodutos.model.Loja;

public interface LojaService {
	
	List<Loja> findAll();
	List<Loja> findByNome(String nome);
	Loja insert(Loja lojaObj);
	Loja update(Long lojaId, Loja form) throws BusinessException;
	void delete(Long lojaId) throws BusinessException;
	Loja cadastrarProduto(Long lojaId, Long produtoId) throws BusinessException;
	Loja removerProduto(Long lojaId, Long produtoId) throws BusinessException;
	
	

}

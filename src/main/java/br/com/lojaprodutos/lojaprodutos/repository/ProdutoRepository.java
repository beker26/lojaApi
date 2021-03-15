package br.com.lojaprodutos.lojaprodutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import br.com.lojaprodutos.lojaprodutos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	List<Produto> findByMarcaContainingIgnoreCase(String nomeProduto);

	
	

}

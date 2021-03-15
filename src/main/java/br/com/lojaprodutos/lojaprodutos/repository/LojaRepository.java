package br.com.lojaprodutos.lojaprodutos.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import br.com.lojaprodutos.lojaprodutos.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

	List<Loja> findByNomeContainingIgnoreCase(String nome);

}

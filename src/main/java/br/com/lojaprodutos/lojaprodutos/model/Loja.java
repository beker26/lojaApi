package br.com.lojaprodutos.lojaprodutos.model;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loja",uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="LOJA_PRODUTO",
    		joinColumns=@JoinColumn(name="LOJA_ID"),
    		inverseJoinColumns=@JoinColumn(name="PRODUTO_ID"))
	private List<Produto> produtos;

	public Loja() {
	}

	public Loja(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void update(Loja lojaObj) {

		this.nome = lojaObj.getNome();
	}

	public void cadastrarProduto(Produto findByIdProduto) {
		this.produtos.add(findByIdProduto);

	}

	public void removerProdutoNaLoja(Produto findByIdProduto) {
		this.produtos.remove(findByIdProduto);
		
	}

}

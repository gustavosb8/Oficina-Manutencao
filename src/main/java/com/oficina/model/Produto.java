package com.oficina.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity 
@Table(name = "PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUTO")
	private Long idProduto;
	
	@NotEmpty (message="{descricao.obrigatorio}")
	@Size(min=2)
	@Column(name = "DS_PRODUTO")
	private String descProduto;
	
	/**** JPA ****/
	
	@ManyToOne
	private Fabricante fabricante;
	
	@OneToMany(mappedBy = "produto")
	private List<ManutencaoProduto> manutencaoProdutos;
	
	/**** JPA ****/
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<ManutencaoProduto> getManutencaoProdutos() {
		return manutencaoProdutos;
	}

	public void setManutencaoProdutos(List<ManutencaoProduto> manutencaoProdutos) {
		this.manutencaoProdutos = manutencaoProdutos;
	}

	@Override
	public String toString() {
		return getDescProduto();
	}
	
	public boolean ehNovo() {
		return ( this.idProduto == null );
	}

}

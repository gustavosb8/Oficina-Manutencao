package com.oficina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_PRODUTO")
	private Integer idProduto;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_PRODUTO")
	private String descProduto;
	
	/**** JPA ****/
	@NotEmpty
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FABRICANTE_PRODUTO", joinColumns = @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_PRODUTO"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_FABRICANTE"))
	private List<Fabricante> fabricantes;
	
	/**** JPA ****/
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	
	public String getFabricantes() {
		
		String fabricantes = "";
		for(int i = 0; i < fabricantes.length(); i++){
			fabricantes = fabricantes + this.fabricantes.get(i).getDescFabricante();
		}
		
		return fabricantes;
	}
	
	public List<Fabricante> getFabricante(){
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@Override
	public String toString() {
		return getDescProduto();
	}
	
	public boolean ehNovo() {
		return ( this.idProduto == null );
	}

}

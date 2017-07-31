package com.oficina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "FABRICANTE")
public class Fabricante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_FABRICANTE")
	private Integer idFabricante;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_FABRICANTE")
	private String descFabricante;
	
	/**** JPA ****/
	@NotEmpty
	@ManyToMany(mappedBy = "fabricantes")
	private List<Produto> produtos;
	
	@NotEmpty
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FABRICANTE_PECA", joinColumns = @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE"), inverseJoinColumns = @JoinColumn(name = "ID_PECA", referencedColumnName = "ID_PECA"))
	private List<Peca> pecas;

	/**** JPA ****/

	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getDescFabricante() {
		return descFabricante;
	}

	public void setDescFabricante(String descFabricante) {
		this.descFabricante = descFabricante;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	@Override
	public String toString() {
		return getDescFabricante();
	}
	
	public boolean ehNovo() {
		return ( this.idFabricante == null );
	}

}

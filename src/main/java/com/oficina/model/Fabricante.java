package com.oficina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@NotEmpty (message="{descricao.obrigatorio}")
	@Size(min=2, message="Descrição deve ser maior")
	@Column(name = "DS_FABRICANTE")
	private String descFabricante;
	
	/**** JPA ****/
	
	@OneToMany(mappedBy = "fabricante")
	private List<ManutencaoPeca> manutencaoPecas;
	
	@OneToMany(mappedBy = "fabricante")
	private List<Produto> produtos;
	
	@OneToMany(mappedBy = "fabricante")
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
	
	public List<ManutencaoPeca> getManutencaoPecas() {
		return manutencaoPecas;
	}

	public void setManutencaoPecas(List<ManutencaoPeca> manutencaoPecas) {
		this.manutencaoPecas = manutencaoPecas;
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

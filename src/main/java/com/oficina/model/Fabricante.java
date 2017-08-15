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
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_FABRICANTE")
	private String descFabricante;
	
	/**** JPA ****/
	
	@OneToMany(mappedBy = "fabricante")
	private List<ManutencaoPeca> manutencaoPecas;
	
	
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
	
	

	@Override
	public String toString() {
		return getDescFabricante();
	}
	
	public boolean ehNovo() {
		return ( this.idFabricante == null );
	}

}

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
@Table(name = "MONTADORA")
public class Montadora implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_MONTADORA")
	private Integer idMontadora;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_MONTADORA")
	private String descricaoMontadora;

	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_ORIGEM")
	private String descricaoOrigem;
	
	/******  JPA *******/
	
	
	@OneToMany(mappedBy = "montadoraLoja")
	private List<Loja> lojas;
	
	
	@OneToMany(mappedBy = "montadoraOficina")
	private List<Oficina> oficinas;
	
	
	@OneToMany(mappedBy = "montadoraModelo")
	private List<Modelo> modelos;
	
	/******  JPA *******/
	
	public Integer getIdMontadora() {
		return idMontadora;
	}

	public void setIdMontadora(Integer idMontadora) {
		this.idMontadora = idMontadora;
	}

	public String getDescricaoMontadora() {
		return descricaoMontadora;
	}

	public void setDescricaoMontadora(String descricaoMontadora) {
		this.descricaoMontadora = descricaoMontadora;
	}

	public String getDescricaoOrigem() {
		return descricaoOrigem;
	}

	public void setDescricaoOrigem(String descricaoOrigem) {
		this.descricaoOrigem = descricaoOrigem;
	}
	
	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public List<Oficina> getOficinas() {
		return oficinas;
	}

	public void setOficinas(List<Oficina> oficinas) {
		this.oficinas = oficinas;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	@Override
	public String toString() {
		return getDescricaoMontadora();
	}
	
	public boolean ehNovo() {
		return ( this.idMontadora == null );
	}

}

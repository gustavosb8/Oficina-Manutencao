package com.oficina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "MODELO")
public class Modelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_MODELO")
	private Integer idModelo;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_MODELO")
	private String descModelo;
	
	/**** JPA ****/
	@ManyToOne
	private Montadora montadoraModelo;

	@ManyToOne
	private TipoVeiculo tipoVeiculo;
	
	@OneToMany(mappedBy = "modelo")
	private List<Veiculo> veiculos;
	
	/**** JPA ****/

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public String getDescModelo() {
		return descModelo;
	}

	public void setDescModelo(String modelo) {
		this.descModelo = modelo;
	}
	
	public Montadora getMontadoraModelo() {
		return montadoraModelo;
	}

	public void setMontadoraModelo(Montadora montadoraModelo) {
		this.montadoraModelo = montadoraModelo;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return getDescModelo();
	}
	
	public boolean ehNovo() {
		return ( this.idModelo == null );
	}
}

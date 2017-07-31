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
@Table(name = "TIPO_VEICULO")
public class TipoVeiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_TIPO_VEICULO")
	private Integer idTipoVeiculo;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_TIPO_VEICULO")
	private String desc_tipoVeiculo;
	
	/******  JPA *******/

	@OneToMany(mappedBy = "tipoVeiculo")
	private List<Modelo> modelos;
	/******  JPA *******/
	

	public Integer getIdTipoVeiculo() {
		return idTipoVeiculo;
	}

	public void setIdTipoVeiculo(Integer idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}

	public String getDesc_tipoVeiculo() {
		return desc_tipoVeiculo;
	}

	public void setDesc_tipoVeiculo(String desc_tipoVeiculo) {
		this.desc_tipoVeiculo = desc_tipoVeiculo;
	}
	
	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	@Override
	public String toString() {
		return getDesc_tipoVeiculo();
	}
	
	public boolean ehNovo() {
		return ( this.idTipoVeiculo == null );
	}
	
	
}

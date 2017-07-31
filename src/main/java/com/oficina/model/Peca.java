package com.oficina.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity 
@Table(name = "PECA")
public class Peca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_PECA")
	private Integer idPeca;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_PECA")
	private String descPeca;
	
	/* Verificar necessidade
	@NotEmpty
	@Column(name = "FL_Original")
	private boolean original;
	*/
	
	/**** JPA ****/

	@ManyToMany(mappedBy = "pecas")
	private List<Fabricante> fabricantes;

	public Integer getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}

	public String getDescPeca() {
		return descPeca;
	}

	public void setDescPeca(String descPeca) {
		this.descPeca = descPeca;
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@Override
	public String toString() {
		return getDescPeca();
	}
	
	public boolean ehNovo() {
		return ( this.idPeca == null );
	}

}

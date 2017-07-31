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
@Table(name = "LOJA")
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_LOJA")
	private Integer idLoja;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_NOME")
	private String nomeLoja;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_ENDERECO")
	private String enderecoLoja;
	
	/*** JPA ***/
	@ManyToOne
	private Montadora montadoraLoja;
	
	@OneToMany(mappedBy = "loja")
	private List<Veiculo> veiculos;
	/*** JPA ***/

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getEnderecoLoja() {
		return enderecoLoja;
	}

	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}
	
	public Montadora getMontadoraLoja() {
		return montadoraLoja;
	}

	public void setMontadoraLoja(Montadora montadoraLoja) {
		this.montadoraLoja = montadoraLoja;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return getNomeLoja();
	}
	
	public boolean ehNovo() {
		return ( this.idLoja == null );
	}
}

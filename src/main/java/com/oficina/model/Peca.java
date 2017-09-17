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
@Table(name = "PECA")
public class Peca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_PECA")
	private Integer idPeca;
	
	@NotEmpty (message="{descricao.obrigatorio}")
	@Size(min=2)
	@Column(name = "DS_PECA")
	private String descPeca;
	
	/* Verificar necessidade
	@NotEmpty
	@Column(name = "FL_Original")
	private boolean original;
	*/
	
	/**** JPA ****/

	@ManyToOne
	private Fabricante fabricante;
	
	@OneToMany(mappedBy = "peca")
	private List<ManutencaoPeca> manutencaoPecas;
	
	/**** JPA ****/
	
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<ManutencaoPeca> getManutencaoPecas() {
		return manutencaoPecas;
	}

	public void setManutencaoPecas(List<ManutencaoPeca> manutencaoPecas) {
		this.manutencaoPecas = manutencaoPecas;
	}

	@Override
	public String toString() {
		return getDescPeca();
	}
	
	public boolean ehNovo() {
		return ( this.idPeca == null );
	}

}

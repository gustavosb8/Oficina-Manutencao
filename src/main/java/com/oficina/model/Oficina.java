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
@Table(name = "OFICINA")
public class Oficina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_OFICINA")
	private Integer idOficina;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_OFICINA")
	private String descricaoOficina;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_CONTATO")
	private String contato;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_ENDERECO")
	private String endereco;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_TELEFONE")
	private String telefone;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_OBS")
	private String observacao;
	
	/*** JPA ***/
	@ManyToOne
	private Montadora montadoraOficina;
	
	
	@OneToMany(mappedBy = "oficina")
	private List<Manutencao> manutencoes;
	/*** JPA ***/

	public Integer getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}

	public String getDescricaoOficina() {
		return descricaoOficina;
	}

	public void setDescricaoOficina(String descricaoOficina) {
		this.descricaoOficina = descricaoOficina;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Montadora getMontadoraOficina() {
		return montadoraOficina;
	}

	public void setMontadoraOficina(Montadora montadoraOficina) {
		this.montadoraOficina = montadoraOficina;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	@Override
	public String toString() {
		return getDescricaoOficina();
	}
	
	public boolean ehNovo() {
		return ( this.idOficina == null );
	}
}

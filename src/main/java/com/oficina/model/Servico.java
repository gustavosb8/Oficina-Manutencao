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
@Table(name = "SERVICO")
public class Servico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_SERVICO")
	private Integer idServico;
	
	@NotEmpty (message="{descricao.obrigatorio}")
	@Size(min=2)
	@Column(name = "DS_SERVICO")
	private String descServico;
	
	/**** JPA ****/
	
	@OneToMany(mappedBy = "servico")
	private List<ManutencaoServico> manutencaoServicos;
	
	/**** JPA ****/

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getDescServico() {
		return descServico;
	}

	public void setDescServico(String descServico) {
		this.descServico = descServico;
	}
	
	@Override
	public String toString() {
		return getDescServico();
	}
	
	public boolean ehNovo() {
		return ( this.idServico == null );
	}

}

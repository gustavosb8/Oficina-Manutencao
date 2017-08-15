package com.oficina.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Table(name = "MANUTENCAO")
public class Manutencao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_MANUTENCAO")
	private Integer idManutencao;
	
	@NotEmpty
	@Size(min=2)
	@Column(name = "DS_MANUTENCAO")
	private String descricaoManutencao;
	
	@NotNull
	@Column(name = "DT_MANUTENCAO")
	private Date dataManutencao;
	
	/**** JPA ****/
	@ManyToOne
	private Veiculo veiculo;
	
	@ManyToOne
	private Oficina oficina;
	
	@OneToMany(mappedBy = "manutencao")
	private List<ManutencaoServico> manutencaoServicos; 
	
	
	@OneToMany(mappedBy = "manutencao")
	private List<ManutencaoProduto> manutencaoProdutos;
	
	
	@OneToMany(mappedBy = "manutencao")
	private List<ManutencaoPeca> manutencaoPecas;
	
	/**** JPA ****/
	
	public Integer getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}

	public String getDescricaoManutencao() {
		return descricaoManutencao;
	}

	public void setDescricaoManutencao(String descricaoManutencao) {
		this.descricaoManutencao = descricaoManutencao;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	
	@JoinColumn(name = "idRenavam")
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculos) {
		this.veiculo = veiculos;
	}
	
	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public List<ManutencaoServico> getManutencaoServicos() {
		return manutencaoServicos;
	}

	public void setManutencaoServicos(List<ManutencaoServico> manutencaoServicos) {
		this.manutencaoServicos = manutencaoServicos;
	}

	public List<ManutencaoPeca> getManutencaoPecas() {
		return manutencaoPecas;
	}

	public void setManutencaoPecas(List<ManutencaoPeca> manutencaoPecas) {
		this.manutencaoPecas = manutencaoPecas;
	}

	@Override
	public String toString() {
		return getDescricaoManutencao();
	}
	
	public boolean ehNovo() {
		return ( this.idManutencao == null );
	}
}

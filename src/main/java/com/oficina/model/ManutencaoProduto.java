package com.oficina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name = "MANUTECAO_PRODUTO")
public class ManutencaoProduto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_MP")
	private Integer idMp;

	@NotNull
    @Min(0)
	@Column(name = "VL_COBRADO")
	private double valorCobrado;
	
	/**** JPA ****/
	
	@ManyToOne
	private Manutencao manutencao;
	
	@ManyToOne
	private Fabricante fabricante;
	
	@ManyToOne
	private Produto produto;
	
	/**** JPA ****/

	public Integer getIdMp() {
		return idMp;
	}

	public void setIdMp(Integer idMp) {
		this.idMp = idMp;
	}

	public double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return ""+getValorCobrado();
	}
	
	public boolean ehNovo() {
		return (this.idMp == null);
	}
}

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
@Table(name = "MANUTECAO_PECA")
public class ManutencaoPeca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID_MPE")
	private Integer idMpe;

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
	private Peca peca;
	
	/**** JPA ****/

	public Integer getIdMpe() {
		return idMpe;
	}

	public void setIdMpe(Integer idMpe) {
		this.idMpe = idMpe;
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

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	@Override
	public String toString() {
		return ""+getValorCobrado();
	}
	
	public boolean ehNovo() {
		return (this.idMpe == null);
	}
}

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
@Table(name = "MANUTECAO_SERVICO")
public class ManutencaoServico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_MS")
	private Integer idMs;

	@NotNull
    @Min(0)
	@Column(name = "VL_COBRADO")
	private double valorCobrado;
	
	/**** JPA ****/
	
	@ManyToOne
	private Manutencao manutencao;
	
	@ManyToOne
	private Servico servico;
	
	/**** JPA ****/

	public Integer getIdMs() {
		return idMs;
	}

	public void setIdMs(Integer idMs) {
		this.idMs = idMs;
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

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	@Override
	public String toString() {
		return ""+getValorCobrado();
	}
	
	public boolean ehNovo() {
		return (this.idMs == null);
	}
}

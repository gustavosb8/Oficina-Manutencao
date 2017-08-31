package com.oficina.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity 
@Table(name = "VEICULO")
public class Veiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID_RENAVAM")
	private Integer idRenavam;
	
	@NotEmpty
	@Column(name = "DS_COR")
	private String descricaoCor;
	
	@NotNull
	@Column(name = "VL_ANO_MODELO")
	private Integer anoModelo;
	
	@NotNull
	@Column(name = "VL_ANO_FABRICACAO")
	private Integer anoFabricacao;
	
	@NotEmpty
	@Column(name = "DS_OBS")
	private String observacao;
	
	@NotNull
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "DT_COMPRA")
	private Date dataCompra;
	
	@NotNull
	@Column(name = "VL_COMPRA")
	private Integer valorCompra;
	
	@NotNull
	@Column(name = "VL_KM_COMPRA")
	private int kilometragemCompra;
	
	@NotNull
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "DT_VENDA")
	private Date dataVenda;
	
	/**** JPA ****/

	@OneToMany(mappedBy = "veiculo")
	private List<Manutencao> manutencoes;
	
	@ManyToOne
	private Loja loja;

	@ManyToOne
	private Modelo modelo;
	/**** JPA ****/

	public Integer getIdRenavam() {
		return idRenavam;
	}

	public void setIdRenavam(Integer id_renavam) {
		this.idRenavam = id_renavam;
	}

	public String getDescricaoCor() {
		return descricaoCor;
	}

	public void setDescricaoCor(String dc_cor) {
		this.descricaoCor = dc_cor;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer vl_ano_modelo) {
		this.anoModelo = vl_ano_modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer vl_ano_fabricacao) {
		this.anoFabricacao = vl_ano_fabricacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String ds_obs) {
		this.observacao = ds_obs;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dt_compra) {
		this.dataCompra = dt_compra;
	}

	public Integer getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Integer vl_compra) {
		this.valorCompra = vl_compra;
	}

	public int getKilometragemCompra() {
		return kilometragemCompra;
	}

	public void setKilometragemCompra(int vl_km_compra) {
		this.kilometragemCompra = vl_km_compra;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dt_venda) {
		this.dataVenda = dt_venda;
	}
	
	public boolean isNew() {
		return ( this == null);
	}

	
	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencao) {
		this.manutencoes = manutencao;
	}
	
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return getDescricaoCor();
	}
	
	public boolean ehNovo() {
		return ( this.idRenavam == null );
	}
}
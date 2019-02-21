package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * T_IMOVEL
 * 		*cd_imovel (NUMBER)(PK)
 * 		*ds_tipo () (Enum...)
 * 		ds_area (NUMBER)
 * 		dt_construcao (DATE)	
 *		*ds_logradouro	(VARCHAR(100)) 
 */

@Entity
@Table(name="T_IMOVEL")
@SequenceGenerator(name="imovel", sequenceName="SQ_T_IMOVEL", allocationSize=1)
public class Imovel {

	@Id
	@Column(name="cd_imovel")
	@GeneratedValue(generator="imovel", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="vl_area")
	private int area;
	@Column(name="ds_logradouro", nullable = false, length=100)
	private String logradouro;
	@Column(name="ds_tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Temporal(TemporalType.DATE)
	@Column(name="dt_construcao")
	private Calendar dtConstrucao;
	
	
	public Imovel() {
		super();
	}
	
	
	
	public Imovel(int codigo, int area, String logradouro, Tipo tipo, Calendar dtConstrucao) {
		super();
		this.codigo = codigo;
		this.area = area;
		this.logradouro = logradouro;
		this.tipo = tipo;
		this.dtConstrucao = dtConstrucao;
	}



	public Imovel(int area, String logradouro, Tipo tipo, Calendar dtConstrucao) {
		super();		
		this.area = area;
		this.logradouro = logradouro;
		this.tipo = tipo;
		this.dtConstrucao = dtConstrucao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Calendar getDtConstrucao() {
		return dtConstrucao;
	}
	public void setDtConstrucao(Calendar dtConstrucao) {
		this.dtConstrucao = dtConstrucao;
	}
	
	
}

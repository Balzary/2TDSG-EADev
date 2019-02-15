package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_ZOOLOGICO")
@SequenceGenerator(name="zoologico", sequenceName="SQ_T_ZOOLGICO", allocationSize=1)
public class Zoologico {

	@Id
	@Column(name="cd_zoologico")
	@GeneratedValue(generator = "zoologico", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_zoologico", nullable=false, length= 20)
	private String nome;
	
	@Column(name="qt_animais")
	private int qtAnimais;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Alimentacao tipo;
	
	@Column(name="hr_abertura")
	@Temporal(value=TemporalType.TIME)
	private Date abertura;
	
	@Column(name="hr_fechamento")
	@Temporal(value=TemporalType.TIME)
	private Date fechamento;
	
	@Column(name="dt_inaugaracao")
	@Temporal(value=TemporalType.DATE)
	private Date inauguracao;
	
	@Column(name="st_emergencia")
	private boolean emergencia;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Transient
	private boolean aberto;	

	public Zoologico() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtAnimais() {
		return qtAnimais;
	}

	public void setQtAnimais(int qtAnimais) {
		this.qtAnimais = qtAnimais;
	}

	public Alimentacao getTipo() {
		return tipo;
	}

	public void setTipo(Alimentacao tipo) {
		this.tipo = tipo;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	public Date getInauguracao() {
		return inauguracao;
	}

	public void setInauguracao(Date inauguracao) {
		this.inauguracao = inauguracao;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	
}

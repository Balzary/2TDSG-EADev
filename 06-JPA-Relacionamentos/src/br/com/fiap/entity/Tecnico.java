package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(name="tecnico", sequenceName="SQ_T_TECNICO", allocationSize=1)
public class Tecnico {
	
	@Id
	@Column(name="cd_tecnico")
	@GeneratedValue(generator="tecnico", strategy=GenerationType.SEQUENCE)	
	private int codigo;
	@Column(name="nm_tecnico", nullable=false, length=30)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name="dt_birthday")
	private Calendar dataNascimento;  
	
	@OneToOne
	@JoinColumn(name="cd_time")
	private Time time;
	
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}

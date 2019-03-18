package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CAMPEONATO")
@SequenceGenerator(name="campeonato", sequenceName="SQ_T_CAMPEONATO", allocationSize=1)
public class Campeonato {

	@Id
	@Column(name="cd_campeonato")
	@GeneratedValue(generator="campeonato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="nm_campeonato", nullable=false, length=100)
	private String nome;
	@Column(name="vl_premiacao")
	private double premiacao;
	@Column(name="nm_local", nullable=false, length=100)
	private String local;
	@ManyToMany	
	private List<Time> time;	
	
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
	public double getPremiacao() {
		return premiacao;
	}
	public void setPremiacao(double premiacao) {
		this.premiacao = premiacao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
}

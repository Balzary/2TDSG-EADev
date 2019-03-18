package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="time", sequenceName="SQ_T_TIME", allocationSize=1)
public class Time {
	
	@Id
	@Column(name="cd_time")
	@GeneratedValue(generator="time", strategy=GenerationType.SEQUENCE)	
	private int codigo;
	@Column(name="nm_time", nullable=false, length=30)
	private String nome;
	@Column(name="nr_titulos", length=30)
	private int titulos;
	
	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	@OneToMany(mappedBy="time")
	private List<Jogador> jogadores;
	@ManyToMany(mappedBy="time")
	private List<Campeonato> campeonatos;
	
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
	public int getTitulos() {
		return titulos;
	}
	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}
	
	
	
	
}

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_JOGADOR")
@SequenceGenerator(name="jogador", sequenceName="SQ_T_JOGADOR", allocationSize=1)

public class Jogador {
	
	@Id
	@Column(name="cd_jogador")
	@GeneratedValue(generator="jogador", strategy=GenerationType.SEQUENCE)	
	private int codigo;
	@Column(name="nm_jogador", nullable=false, length=30)
	private String nome;
	@Column(name="ds_posicao",nullable=false)
	@Enumerated(EnumType.STRING)
	private Posicao posicao;
	@ManyToOne
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
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	
	

}

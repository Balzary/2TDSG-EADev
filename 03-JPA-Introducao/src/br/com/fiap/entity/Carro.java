package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class Carro {

	private int codigo, ano;
	
	private String nome, marca, placa; 
	
	private Transmissao cambio;
	
	private Calendar dataFabricacao;
	
	
	
}

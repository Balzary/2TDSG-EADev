package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO", allocationSize=1)
public class Usuario {
	
	@Id
	@Column(name="COD_USUARIO")
	@GeneratedValue(generator="usuario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="NOM_USUARIO", nullable=false, length=50)
	private String nome;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TAB_ITEM_TESTE_USUARIO", joinColumns=@JoinColumn(name="COD_USUARIO"),
	inverseJoinColumns=@JoinColumn(name="COD_ITEM_TESTE"))
	private List<ItemTeste> itemTeste;
	
		
	public Usuario() {
		super();
	}
	
	public Usuario(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	public List<ItemTeste> getItemTeste() {
		return itemTeste;
	}

	public void setItemTeste(List<ItemTeste> itemTeste) {
		this.itemTeste = itemTeste;
	}

	
	
	
}

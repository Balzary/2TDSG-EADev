package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="casoTeste", sequenceName="SQ_T_CASO_TESTE", allocationSize=1)
public class CasoTeste {

	@Id
	@Column(name="COD_CASO_TESTE")
	@GeneratedValue(generator="casoTeste", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="NOM_CASO_TESTE", nullable=false, length=50)
	private String nome;
	@Column(name="DES_CASO_TESTE", nullable=false, length=50)
	private String description;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="COD_SISTEMA")
	private Sistema sistema;

	@OneToMany(mappedBy="casoTeste")
	private List<ItemTeste> itemTeste;	
	
	
	public CasoTeste() {
		super();
	}
	
	public CasoTeste(int codigo, String nome, String description) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<ItemTeste> getItemTeste() {
		return itemTeste;
	}

	public void setItemTeste(List<ItemTeste> itemTeste) {
		this.itemTeste = itemTeste;
	}
	
	
}

package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_T_SISTEMA", allocationSize=1)
public class Sistema {

	@Id
	@Column(name="COD_SISTEMA")
	@GeneratedValue(generator="sistema", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="NOM_SISTEMA", nullable=false, length=50)
	private String nome;
	@OneToMany(mappedBy="sistema")
	private List<CasoTeste> casoTeste;
	
	
	public Sistema() {
		super();
	}
	public Sistema(int codigo, String nome) {
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
	public List<CasoTeste> getCasoTeste() {
		return casoTeste;
	}
	public void setCasoTeste(List<CasoTeste> casoTeste) {
		this.casoTeste = casoTeste;
	}
	
	
}

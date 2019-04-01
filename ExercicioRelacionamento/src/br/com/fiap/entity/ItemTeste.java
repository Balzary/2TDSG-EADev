package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(name="itemTeste", sequenceName="SQ_T_ITEM_TESTE", allocationSize=1)
public class ItemTeste {

	@Id
	@Column(name="COD_ITEM_TESTE")
	@GeneratedValue(generator="itemTeste", strategy=GenerationType.SEQUENCE )
	private int codigo;
	@Column(name="DES_ITEM_TESTE", nullable=false, length=100)
	private String description;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="COD_CASO_TESTE")
	private CasoTeste casoTeste;
	@ManyToMany(mappedBy="itemTeste")
	private List<Usuario> usuario;
	
	
	public ItemTeste() {
		super();
	}
	
	public ItemTeste(int codigo, String description) {
		super();
		this.codigo = codigo;
		this.description = description;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
}

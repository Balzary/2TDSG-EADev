package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="medico", sequenceName="SQ_T_MEDICO", allocationSize=1)
public class Medico {

	@Id
	@Column(name="nr_crm")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medico")
	private int crm;
	
	@Column(name="nm_medico")
	private String medico;
	
	@Column(name="ds_especial")
	private String especialidade;

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	
}

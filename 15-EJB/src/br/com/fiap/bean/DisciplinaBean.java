package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.DisciplinaBO;

@ManagedBean	
public class DisciplinaBean {

	private double am, ps, nac, media;

	@EJB
	private DisciplinaBO bo;

	public void calcular() {
		media = bo.calcularMedia(nac, am, ps);
	}
	
	
	public double getAm() {
		return am;
	}

	public void setAm(double am) {
		this.am = am;
	}

	public double getPs() {
		return ps;
	}

	public void setPs(double ps) {
		this.ps = ps;
	}

	public double getNac() {
		return nac;
	}

	public void setNac(double nac) {
		this.nac = nac;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public DisciplinaBO getBo() {
		return bo;
	}

	public void setBo(DisciplinaBO bo) {
		this.bo = bo;
	}
	
	
}

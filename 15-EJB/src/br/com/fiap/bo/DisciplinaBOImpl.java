package br.com.fiap.bo;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class DisciplinaBOImpl implements DisciplinaBO{

	@Override
	public double calcularMedia(double nac, double am, double ps) {
		double media = (nac*0.2) + (am*0.3) + (ps*0.5);
		return media;
	}

	@Override
	public double calcuarPS(double nac, double am) {
		return (6 - (nac*0.2 + am*0.3))*2 ;
	}

	@Override
	public double calcularMediaNAC(List<Double> nacs) {
		Collections.sort(nacs);
		int descartes = nacs.size()>=4?2:1;
		int somaNacs = 0;
		for(int i = descartes; i<nacs.size(); i++) {
			somaNacs+= nacs.get(i);			
		}
		return somaNacs/(nacs.size() - descartes);
	}
}
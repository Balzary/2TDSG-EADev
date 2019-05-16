package br.com.fiap.bo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DisciplinaBO {

	double calcularMedia(double nac, double am, double ps);
	double calcuarPS(double nac, double am);
	double calcularMediaNAC(List<Double> nacs);
	
}

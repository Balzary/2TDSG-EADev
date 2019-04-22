package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{
	
	List<Pacote> buscarPorPrecoMaximo(double preco);

	List<Pacote> listarPorTransporte(Transporte transporte);
	
	List<Pacote> listarPacotesData(Calendar inicial, Calendar termino);
	
	double priceSum(Transporte transporte);
}

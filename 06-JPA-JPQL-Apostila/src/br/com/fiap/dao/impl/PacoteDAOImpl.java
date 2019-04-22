package br.com.fiap.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listarPorTransporte(Transporte t) {
		TypedQuery<Pacote> q = em.createQuery("from Pacote p where p.transporte = :P", Pacote.class);
		q.setParameter("P", t);
		return q.getResultList();
	}

	@Override
	public List<Pacote> listarPacotesData(Calendar init, Calendar fim) {
		TypedQuery<Pacote> p = em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class);
		p.setParameter("i",init);
		p.setParameter("f", fim);
		return p.getResultList();
	}

	@Override
	public double priceSum(Transporte transporte) {
		return em.createQuery("Select sum(p.preco) from Pacote p where p.transporte = :t", Double.class)
				.setParameter("t", transporte).getSingleResult();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorPrecoMaximo(double preco) {
		return em.createNativeQuery("SELECT * FROM PACOTE WHERE PRECO < :P",Pacote.class)
				.setParameter("P", preco).getResultList();
	}

}

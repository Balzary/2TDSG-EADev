package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Campeonato;

public class CampeonatoDAOImpl extends GenericDAOImpl<Campeonato, Integer> {

	public CampeonatoDAOImpl(EntityManager em) {
		super(em);
	}

}

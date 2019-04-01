package br.com.fiap.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemTesteDAO;
import br.com.fiap.entity.ItemTeste;

public class ItemTesteDAOImpl extends GenericDAOImpl<ItemTeste, Integer> implements ItemTesteDAO{

	public ItemTesteDAOImpl(EntityManager em) {
		super(em);
	}

	
}

package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.Exception.CommitException;
import br.com.fiap.Exception.SearchNotFoundException;
import br.com.fiap.dao.GenericDAO;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T,K> {

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T table) {
		em.persist(table);		
	}

	@Override
	public T read(K key) throws SearchNotFoundException {		
		T entity = em.find(clazz, key);
		if(entity == null) {
			throw new SearchNotFoundException();
		}
		return entity;
	}

	@Override
	public void update(T table) {
		em.merge(table);
		
	}

	@Override
	public void delete(K key) throws SearchNotFoundException {		
		T entity = read(key);		
		em.remove(entity);	
	}

	@Override
	public void commit() throws CommitException {
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();	
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}		
	}
}

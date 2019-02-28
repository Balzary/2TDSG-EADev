package br.com.fiap.dao;

import br.com.fiap.Exception.CommitException;
import br.com.fiap.Exception.SearchNotFoundException;

public interface GenericDAO<T,K> {

	void create(T table);
	
	T read(K key) throws SearchNotFoundException;
	
	void update(T table);
	
	void delete(K key) throws SearchNotFoundException;
	
	void commit() throws CommitException;	
	
}

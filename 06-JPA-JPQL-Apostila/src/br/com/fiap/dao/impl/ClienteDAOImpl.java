package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> q = em.createQuery("from Cliente", Cliente.class);		
		return q.getResultList();	
	}
	
	@Override	
	public List<Cliente> listaNomeCliente(String n) {
		TypedQuery<Cliente> q = em.createQuery("from Cliente c where c.nome like :name", Cliente.class);
		q.setParameter("name", "%"+n+"%");
		return q.getResultList();
	}

	@Override
	public List<Cliente> getAllByEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e",Cliente.class)
				.setParameter("e", estado)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		TypedQuery<Cliente> q = em.createQuery("from Cliente c where c.nome like :name and c.endereco.cidade.nome like :cidade", Cliente.class);
		q.setParameter("name", "%"+nome+"%");
		q.setParameter("cidade", "%"+cidade+"%");
		return q.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		TypedQuery<Cliente> q = em.createQuery("from Cliente c where c.uf in :estados",Cliente.class);
		q.setParameter("estados", estados);
		return q.getResultList();
	}

}

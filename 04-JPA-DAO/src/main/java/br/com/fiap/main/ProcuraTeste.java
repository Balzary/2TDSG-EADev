package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;

public class ProcuraTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		ImovelDAO dao = new ImovelDAOImpl(em);		
		
		Imovel imovel = dao.consultar(1);
		
		System.out.println(imovel.getLogradouro());
		System.out.println(imovel.getArea());
		System.out.println(imovel.getTipo());		
				
		em.close();
		fabrica.close();
	}

}

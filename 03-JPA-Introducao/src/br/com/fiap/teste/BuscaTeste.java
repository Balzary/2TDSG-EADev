package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Zoologico;

public class BuscaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//pesquisar um zoologico de id = 1 
		
		Zoologico zoo = em.find(Zoologico.class, 2);
		
		System.out.println(zoo.getNome());

		//alterar o nome do zoo
		zoo.setNome("Zoo Bauru");
		//fazer commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	
	}

}

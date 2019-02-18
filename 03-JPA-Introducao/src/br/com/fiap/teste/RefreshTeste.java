package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Zoologico;

public class RefreshTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//pesquisar um zoo
		Zoologico zoo = em.find(Zoologico.class, 1);
		
		//Exibir o nome
		System.out.println(zoo.getNome());		
		
		//Trocar o nome no java e exibir
		zoo.setNome("Teste");
		System.out.println(zoo.getNome());	
		
		//Fazer o refresh
		em.refresh(zoo);
		
		//Exibir o nome
		System.out.println(zoo.getNome());
		em.close();
		fabrica.close();

	}

}

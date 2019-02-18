package br.com.fiap.teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Alimentacao;
import br.com.fiap.entity.Zoologico;

public class AtualizaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		// criar um objeto zoologico com um id existente no banco
		Zoologico zoo = new Zoologico("Zoo de Santos", 100, Alimentacao.HERBIVORO, new Date(), new Date(), new Date(), false,  true);
		
		
		// atualiza os dados no banco de dados
		zoo.setCodigo(1);
		em.merge(zoo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
				
		em.close();
		fabrica.close();
	}

}

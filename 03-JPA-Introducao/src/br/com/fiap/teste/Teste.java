package br.com.fiap.teste;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Alimentacao;
import br.com.fiap.entity.Zoologico;

public class Teste {

	public static void main(String[] args) {
		// Criar um gerenciador de entidades(Entity Manager)
		//Primeiro criar a fabrica de entity manager
		EntityManagerFactory fabrica = 					//persistance.xml
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria o entity manager
		EntityManager em = fabrica.createEntityManager();		

		//cadastrar um zoo
		Zoologico zoo = new Zoologico("Zoo de SP", 60, Alimentacao.ONIVORO, new Date(), new Date(), new Date(), false,  true);
		em.persist(zoo);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();		
	}

}

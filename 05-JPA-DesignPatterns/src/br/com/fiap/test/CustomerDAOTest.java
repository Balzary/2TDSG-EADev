package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import br.com.fiap.Exception.CommitException;
import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.dao.impl.CustomerDAOImpl;
import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Gender;

class CustomerDAOTest {

	@Test
	void createTest() {
		//Arrange
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager em = factory.createEntityManager();
		CustomerDAO dao = new CustomerDAOImpl(em);
		
		Customer c = new Customer("Teste", new GregorianCalendar(1999, Calendar.MARCH, 15), Gender.OTHERS, null);
		
		//ACT cadastrar o cliente
		try {			
			dao.create(c);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		//Assert: validar o resultado
		assertNotEquals(c.getId(), 0);
	}

}

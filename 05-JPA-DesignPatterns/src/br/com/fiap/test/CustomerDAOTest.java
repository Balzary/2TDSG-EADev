package br.com.fiap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.Exception.CommitException;
import br.com.fiap.Exception.SearchNotFoundException;
import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.dao.impl.CustomerDAOImpl;
import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Gender;

class CustomerDAOTest {
	
	private static CustomerDAO dao;
	
	//Método executado antes de todos os testes 
	@BeforeAll
	public static void init() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager em = factory.createEntityManager();
		dao = new CustomerDAOImpl(em);
	}
	
	@BeforeEach //metodo executado antes de cada teste
	void beforeTest() {
		
	}
	
	@Test
	@DisplayName("Teste de cadastro com sucesso")
	void createTest() {
		//Arrange
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
	
	@Test
	@DisplayName("Teste de busca com sucesso")
	void readTest() {
		//Arrange - instanciar os objetos e o cadastro
		Customer c = new Customer("Teste Leitura", new GregorianCalendar(1997, Calendar.FEBRUARY, 20), Gender.MALE, null);
		try {				
			dao.create(c);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		//Act - pesquisar customer que foi cadastrado		
		try {
			Customer search = dao.read(c.getId());
			//Assert - valida se pesquisou corretamente
			assertNotNull(search);
			assertEquals(search.getId(), c.getId());
		} catch (SearchNotFoundException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	@DisplayName("Teste de atualizao com sucesso")
	void update() {
		//Cadastrar um customer
		Customer c = new Customer("Teste atualização", new GregorianCalendar(1994, Calendar.NOVEMBER, 9), Gender.FEMALE, null);
		try {				
			dao.create(c);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		//Atualizar o customer cadastrado
		c.setName("Teste Update");
		c.setGender(Gender.OTHERS);
		try {			
			dao.update(c);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		//Pesquisar o customer
		try {
			Customer search = dao.read(c.getId());
			//Validar se as alterações foram realizadas
			assertEquals("Teste Update", search.getName());
			assertEquals(Gender.OTHERS, search.getGender());
		} catch (SearchNotFoundException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}		
		
	}
	
	@Test
	@DisplayName("Teste de delete com sucesso")
	void remove() {
		//Cadastrar um customer
		Customer c = new Customer("Test delete", new GregorianCalendar(1995, Calendar.NOVEMBER, 26), Gender.FEMALE, null);
		try {				
			dao.create(c);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
		
		//remover o customer
		try {
			dao.delete(c.getId());
			dao.commit();
		} catch (SearchNotFoundException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}		

		//Pesquisar o customer
		Customer search = null;
		try {
			search = dao.read(c.getId());		
		} catch (SearchNotFoundException e) {
			//sucesso
			assertNull(search);
		}	
		
	}

}

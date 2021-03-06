import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

class PacoteDAOTest {
	private static PacoteDAOImpl dao;
	private static EntityManager em;
	
	@BeforeAll
	public static void instanciar() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacoteDAOImpl(em);
	}
	
	@Test
	void testTransporte() {
		Transporte t1 = em.find(Transporte.class, 1);
		List<Pacote> lista = dao.listarPorTransporte(t1);
		assertEquals(2,lista.size());
	}
	
	@Test
	void testBuscaData() {
		Calendar init = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);		
		
		List<Pacote> lista = dao.listarPacotesData(init, fim);
		for(Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(init) && pacote.getDataSaida().before(fim));
		}
	}
	
	@Test
	void testSum() {
		Transporte t = em.find(Transporte.class, 1);
		double price = dao.priceSum(t);
		assertEquals(4300,price);
	}
	
	@Test
	void precoMaxTeste() {
		List<Pacote> p = dao.buscarPorPrecoMaximo(3000d);
		for (Pacote pacote : p) {
			assertTrue(pacote.getPreco()< 3000);
		}
	}
}

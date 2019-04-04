import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTest {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void buscarClientes() {
		List<Cliente> lista = dao.listar();
		assertNotEquals(0,lista.size());
	}
	
	@Test
	void buscarPorNome() {
		List<Cliente> lista = dao.listaNomeCliente("T");
		assertEquals(1 , lista.size());
	}

	@Test
	void getAllByEstadoTest() {
		List<Cliente> lista = dao.getAllByEstado("SP");
		assertNotEquals(0,lista.size());
		
		for(Cliente cliente : lista) {
			assertEquals("SP", cliente.getEndereco().getCidade().getUf());
		}
	}
	
	@Test
	void buscarNomeCidade() {	
		
		List<Cliente> lista = dao.buscar("Leandro", "Lon");
		for(Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Leandro") && cliente.getEndereco().getCidade().getNome().contains("Lon"));
		}
	}
	/*
	@Test 
	void buscarPorEstado() {
		
	}
	*/
}

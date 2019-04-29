package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ManutencaoDAO;
import br.com.fiap.dao.impl.ManutencaoDAOImpl;
import br.com.fiap.entity.Cargo;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Jaula;
import br.com.fiap.entity.Manutencao;
import br.com.fiap.entity.TipoManutencao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	private static ManutencaoDAO dao;
	
	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ManutencaoDAOImpl(em);
	}
	
	@Test
	void cadastrarTudoTeste() {
		//cadastrar uma jaula, funcionario e a manutenção
		Funcionario f = new Funcionario("Maria", 10000, Cargo.GUIA);
		Jaula j = new Jaula("Jaula dos leões", 50);
		Manutencao m = new Manutencao(j, f, Calendar.getInstance(), 
					TipoManutencao.ALIMENTACAO, "100kg de carnes");
		
		try {
			dao.create(m);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}


}

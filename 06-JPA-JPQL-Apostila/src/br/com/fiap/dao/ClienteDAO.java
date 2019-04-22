package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> listar();
	
	List<Cliente> listaNomeCliente(String n);
	
	List<Cliente> getAllByEstado(String estado);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	long clientCount(String estado);
	
	Cliente getByCpf(String cpf);
}

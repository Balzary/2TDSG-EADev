package br.com.fiap.dao;

import br.com.fiap.entity.Imovel;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public interface ImovelDAO {

	void cadastrar(Imovel imovel);
	
	public Imovel consultar(int codigo);
	
	void atualizar(Imovel imovel);	
	
	void commit()throws CommitException;
	
	void remover(int codigo) throws SearchNotFoundException;
	
}

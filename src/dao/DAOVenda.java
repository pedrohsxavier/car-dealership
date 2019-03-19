package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Venda;

public class DAOVenda extends DAO<Venda> {

	//M�todo que busca Venda pelo ID
	public Venda readById(int id) {
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("id").constrain(id);
		List<Venda> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

	//M�todo que busca Vendas feitas por um Vendedor
	public List<Venda> vendaPorVendedor(String nome) {
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("vendedor").constrain(nome);
		List<Venda> resultados = q.execute();
		if(resultados.size() > 0)
			return resultados;
		else
			return null;
	}

}

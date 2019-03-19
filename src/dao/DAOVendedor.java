package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Vendedor;

public class DAOVendedor extends DAO<Vendedor> {
	
	//M�todo que busca Vendedor pelo nome
	public Vendedor readByNome (String nome){	
		Query q = manager.query();
		q.constrain(Vendedor.class);
		q.descend("nome").constrain(nome);
		List<Vendedor> resultados = q.execute();
		if (resultados.size()>0)
			return (Vendedor) resultados.get(0);
		else
			return null;
	}
	
	//M�todo que busca Vendedor pelo c�digo
	public Vendedor readByCodigo (String nome){	
		Query q = manager.query();
		q.constrain(Vendedor.class);
		q.descend("nome").constrain(nome);
		List<Vendedor> resultados = q.execute();
		if (resultados.size()>0)
			return (Vendedor) resultados.get(0);
		else
			return null;
	}
	
	
}

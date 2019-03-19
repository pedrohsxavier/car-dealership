package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Carro;

public class DAOCarro extends DAO<Carro> {
	
	//Método que busca carro por nome
	public Carro readByNome (String nome){	
		Query q = manager.query();
		q.constrain(Carro.class);
		q.descend("nome").constrain(nome);
		List<Carro> resultados = q.execute();
		if (resultados.size()>0)
			return (Carro) resultados.get(0);
		else
			return null;
	}
	
	//Método que retorna todos os carros de uma fabricante
	public List<Carro> consultarCarrosDaFabricante (String nome){	
		Query q = manager.query();
		q.constrain(Carro.class);
		q.descend("fabricante").constrain(nome);
		q.descend("nome").orderAscending();
		List<Carro> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	//Método que retorna todos os carros de uma categoria
	public List<Carro> consultarCarrosPorCategoria (String nome){	
		Query q = manager.query();
		q.constrain(Carro.class);
		q.descend("categoria").constrain(nome);
		q.descend("nome").orderAscending();
		List<Carro> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	//Método que retorna número total de carros
	public int consultarTotalCarros() {
		Query q = manager.query();
		q.constrain(Carro.class);
		int total = q.execute().size();
		return total;
	}
	
}

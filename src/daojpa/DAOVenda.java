package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Venda;

public class DAOVenda extends DAO<Venda> {
	
	//Método que busca Venda pelo ID
	@SuppressWarnings("unchecked")
	public Venda readById (int id) {
		
		try {
			Query q = manager.createQuery("select v from Venda v where v.id = ?1");
			q.setParameter(1, id);
			return (Venda) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Venda> pesquisarVendaPorCarro (int idCarro) {
		try {
			Query q = manager.createQuery("select v from Venda v where v.carro.id = :idCarro");
			q.setParameter("idCarro", idCarro);
			return (List<Venda>) q.getResultList();
		}
		catch(NoResultException e) {
			return null;
		}
	}

	public List<Venda> pesquisarVendaPorCliente (int idCliente) {
		try {
			Query q = manager.createQuery("select v from Venda v where v.cliente.id = :idCliente");
			q.setParameter("idCliente", idCliente);
			return (List<Venda>) q.getResultList();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Venda> pesquisarVendaPorVendedor (int idVendedor) {
		try {
			Query q = manager.createQuery("select v from Venda v where v.vendedor.id = :idVendedor");
			q.setParameter("idVendedor", idVendedor);
			return (List<Venda>) q.getResultList();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
//	//Método que busca Vendas feitas por um Vendedor
//	public List<Venda> vendaPorVendedor(String nome) {
//		Query q = manager.query();
//		q.constrain(Venda.class);
//		q.descend("vendedor").constrain(nome);
//		List<Venda> resultados = q.execute();
//		if(resultados.size() > 0)
//			return resultados;
//		else
//			return null;
//	}

}

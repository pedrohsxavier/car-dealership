package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Vendedor;

public class DAOVendedor extends DAO<Vendedor> {
	
	//Método que busca Vendedor pelo nome
		@SuppressWarnings("unchecked")
		public Vendedor readByNome (String nome) {
			
			try {
				Query q = manager.createQuery("select v from Vendedor v where v.nome= '" + nome +"'");
				return (Vendedor) q.getSingleResult();
			}
			catch(NoResultException e) {
				return null;
			}
		}
	
	/* Método busca pelo código int */	
		
	//Método que busca Vendedor pelo código
	@SuppressWarnings("unchecked")
	public Vendedor readByCodigo (String nome){
		Query q = manager.createQuery("select c from Vendedor v where v.nome = ?1");
		q.setParameter(1, nome);
		return (Vendedor) q.getSingleResult();
	}
	
	//Método que retorna Vendedores que venderam um carro específico
	public List<Vendedor> listarVendedoresPorCarro(String carro){
		try {
			Query q = manager.createQuery("select distinct v from Vendedor v join v.vendas ve join ve.carro c where c.nome='" + carro + "'");
			@SuppressWarnings("unchecked")
			List<Vendedor> resultados = q.getResultList();
			//if(resultados.size()>0)
				return resultados;
		}catch(NoResultException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

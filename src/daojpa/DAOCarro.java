package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Carro;

public class DAOCarro extends DAO<Carro> {
	
	//Método que busca carro por nome
	//@SuppressWarnings("unchecked")
	public Carro readByNome (String nome){
		
		try {
			//Query q = manager.createQuery("select c from Carro c where c.nome= '" + nome +"'");
			Query q = manager.createQuery("select c from Carro c where c.nome = ?1");
			q.setParameter(1, nome);
			return (Carro) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	//Método que retorna todos os carros de uma fabricante
	@SuppressWarnings("unchecked")
	public List<Carro> consultarCarrosDaFabricante (String nome){
		Query q = manager.createQuery("select c from Carro c where c.fabricante = ?1");
		q.setParameter(1, nome);
		if (q.getResultList().size() > 0) {
			return q.getResultList();
		}else
			return null;
	}
	
	//Método que retorna todos os carros de uma categoria
	@SuppressWarnings("unchecked")
	public List<Carro> consultarCarrosPorCategoria (String nome){
		Query q = manager.createQuery("select c from Carro c where c.categoria = ?1");
		q.setParameter(1, nome);
		if (q.getResultList().size() > 0) {
			return q.getResultList();
		}else
			return null;
	}
	
	//Método que retorna número total de carros
	@SuppressWarnings("unchecked")
	public int consultarTotalCarros() {
		Query q = manager.createQuery("select c from Carro c");
		return q.getResultList().size();
	}
	
}

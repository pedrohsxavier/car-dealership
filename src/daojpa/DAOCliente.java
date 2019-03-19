package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente> {
	
	//Método que busca Cliente pelo nome
	@SuppressWarnings("unchecked")
	public Cliente readByNome (String nome) {
		
		try {
			Query q = manager.createQuery("select c from Cliente c where c.nome= '" + nome +"'");
			return (Cliente) q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	//Método que busca Cliente pelo cpf
	@SuppressWarnings("unchecked")
	public Cliente readByCpf (String cpf) {
		Query q = manager.createQuery("select c from Cliente c where c.cpf = ?1");
		q.setParameter(1, cpf);
		return (Cliente) q.getSingleResult();
	}
	
	//Método que retorna Clientes que compraram um carro específico
	public List<Cliente> listarClientesPorCarro(String carro){
		try {
			Query q = manager.createQuery("select distinct cl from Cliente cl join cl.vendas ve join ve.carro c where c.nome='" + carro + "'");
			@SuppressWarnings("unchecked")
			List<Cliente> resultados = q.getResultList();
			//if(resultados.size()>0)
				return resultados;
		}catch(NoResultException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

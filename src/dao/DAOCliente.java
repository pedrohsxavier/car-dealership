package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente> {
	
	//M�todo que busca Cliente pelo nome
	public Cliente readByNome (String nome) {	
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(nome);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	//M�todo que busca Cliente pelo cpf
	public Cliente readByCpf (String cpf) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("cpf").constrain(cpf);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
}

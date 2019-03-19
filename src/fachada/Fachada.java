package fachada;

import java.util.ArrayList;
import java.util.List;

import daojpa.*;
//import daojpa.DAO;
//import daojpa.DAOCarro;
//import daojpa.DAOCliente;
//import daojpa.DAOVenda;
//import daojpa.DAOVendedor;

//import dao.*;

import modelo.Carro;
import modelo.Cliente;
import modelo.Venda;
import modelo.Vendedor;

public class Fachada {

	private static DAOCarro daocarro = new DAOCarro();
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOVenda daovenda = new DAOVenda();
	private static DAOVendedor daovendedor = new DAOVendedor();

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	//Métodos da Fachada para cadastros [CREATE]

	//Cadastrar Carro
	public static Carro cadastrarCarro(String nome, double preco, String fabricante, String categoria) throws Exception {

		DAO.begin();			
		Carro c = daocarro.readByNome(nome);
		
		if(c != null) {
			DAO.rollback();
			throw new Exception("Carro ja cadastrado: " + nome);
		}
		
		if(preco <= 0) {
			throw new Exception("Preço inválido");
		}
		
		if(nome.isEmpty()) {
			throw new Exception("Campo Nome não preenchido.");
		}

		c = new Carro(nome, preco, fabricante, categoria);
		daocarro.create(c);		
		DAO.commit();
		return c;
	}

	//Cadastrar Cliente
	public static Cliente cadastrarCliente(String nome, String en, String dt, String cpf, String em, ArrayList<String> te) throws Exception {

		DAO.begin();
		Cliente c = daocliente.readByNome(nome);

		if(c != null) {
			DAO.rollback();
			throw new Exception("Cliente ja cadastrado: " + nome);
		}
		//te.add(e)
		
		if(nome.isEmpty() || en.isEmpty() || dt.isEmpty() || cpf.isEmpty() || em.isEmpty() || te.isEmpty()) {
			throw new Exception("Campo(s) não preenchido(s).");
		}
		
		c = new Cliente(nome, en, dt, cpf, em, te);
		daocliente.create(c);
		DAO.commit();
		return c;
	}

	//Cadastrar Vendedor
	public static Vendedor cadastrarVendedor(String nome, String en, String dt, int cod, double sal) throws Exception {

		DAO.begin();
		Vendedor v = daovendedor.readByNome(nome);

		if(v != null) {
			DAO.rollback();
			throw new Exception ("Vendedor ja cadastrado: " + nome);
		}
		
		if(nome.isEmpty() || en.isEmpty() || dt.isEmpty()) {
			throw new Exception("Campo(s) não preenchido(s).");
		}
		
		if(sal <= 0) {
			throw new Exception("Salário inválido.");
		}
		
		v = new Vendedor(nome, en, dt, cod, sal);
		daovendedor.create(v);
		DAO.commit();
		return v;

	}
	
	//// Adicionar venda na lista do vendedor
	
	//Cadastrar Venda
	public static Venda cadastrarVenda(String nomec, String nomev, String nomeca, String dt, String pa) throws Exception {

		DAO.begin();
		Venda v;
		Cliente cl = daocliente.readByNome(nomec);
		Vendedor ve = daovendedor.readByNome(nomev);
		Carro c = daocarro.readByNome(nomeca);
		
		if(cl == null) {
			DAO.rollback();
			throw new Exception ("Venda nao pode ser cadastrada: Cliente " + nomec + " nao encontrado");
		}
		
		if(ve == null) {
			DAO.rollback();
			throw new Exception ("Venda nao pode ser cadastrada: Vendedor " + nomev + " nao encontrado");
		}
		
		if(c == null) {
			DAO.rollback();
			throw new Exception ("Venda nao pode ser cadastrada: Carro " + nomeca + " nao encontrado");
		}
		
		v = new Venda(cl, ve, c, dt, pa);
		c.adicionar(v);
		cl.adicionar(v);
		ve.adicionar(v);
		
		
		daovenda.create(v);
		daovendedor.update(ve);
		daocliente.update(cl);
		
		DAO.commit();
		
		return v;
	}


	//Métodos da Fachada para Listagens [READ]

	//Listagem dos carros por String
	public static String listarCarrosString() {
		List<Carro> aux = daocarro.readAll();
		String texto = "\nListagem dos carros: ";
		if (aux.isEmpty())
			texto += "não tem carro cadastrado";
		else {	
			for(Carro c: aux) {
				texto += "\n" + c;
			}
		}
		return texto;		
	}
	
	//Listagem dos carros
	public static List<Carro> listarCarros(){
		return daocarro.readAll();
	}

	//Listagem dos clientes por String
	public static String listarClientesString() {
		List<Cliente> aux = daocliente.readAll();
		String texto = "\nListagem dos clientes: ";
		if (aux.isEmpty())
			texto += "não tem cliente cadastrado";
		else {	
			for(Cliente c: aux) {
				texto += "\n" + c; 
			}
		}
		return texto;		
	}
	
	//
	//Listagem dos clientes
		public static List<Cliente> listarClientes(){
			return daocliente.readAll();
		}

	//Listagem das vendas por String
	public static String listarVendasString() {
		List<Venda> aux = daovenda.readAll();
		String texto = "\nListagem das vendas: ";
		if (aux.isEmpty())
			texto += "não tem venda cadastrada";
		else {	
			for(Venda v: aux) {
				texto += "\n" + v; 
			}
		}
		return texto;		
	}
	
	//
	//Listagem das vendas
		public static List<Venda> listarVendas(){
			return daovenda.readAll();
		}

	//Listagem dos vendedores por String
	public static String listarVendedoresString() {
		List<Vendedor> aux = daovendedor.readAll();
		String texto = "\nListagem dos vendedores: ";
		if (aux.isEmpty())
			texto += "não tem vendedor cadastrado";
		else {	
			for(Vendedor v: aux) {
				texto += "\n" + v; 
			}
		}
		return texto;		
	}
	
	//
	//Listagem dos vendedores
		public static List<Vendedor> listarVendedores(){
			return daovendedor.readAll();
		}


	//Métodos da Fachada para Atualizações [UPDATE]

	//Atualizar Carro
	public static void atualizarCarro(String nome, String novo) throws Exception{

		DAO.begin();
		Carro c = (Carro) daocarro.readByNome(nome);

		if (c == null) {
			DAO.rollback();
			throw new Exception ("Carro " + nome + " não cadastrado");
		}
		
		c.setNome(novo);
		c = (Carro) daocarro.update(c);
		DAO.commit();
	}

	//Atualizar Cliente
	public static void atualizarCliente(String nome, String novo) throws Exception{

		DAO.begin();
		Cliente c = (Cliente) daocliente.readByNome(nome);

		if (c == null) {
			DAO.rollback();
			throw new Exception ("Cliente " + nome + " não cadastrado");
		}
			
		c.setNome(novo);
		c = (Cliente) daocliente.update(c);
		DAO.commit();
	}

	//Atualizar Vendedor
	public static void atualizarVendedor(String nome, String novo) throws Exception{

		DAO.begin();
		Vendedor v = daovendedor.readByNome(nome);

		if (v == null) {
			DAO.rollback();
			throw new Exception ("Vendedor " + nome + " não cadastrado");
		}
		
		v.setNome(novo);
		v = daovendedor.update(v);
		DAO.commit();
	}

	//Atualizar Venda
	public static void atualizarVenda(int n, int novo) throws Exception{

		DAO.begin();
		Venda v = daovenda.readById(novo);

		if (v == null) {
			DAO.rollback();
			throw new Exception ("Venda " + n + " não cadastrada");
		}
		
		v.setId(novo);
		v = daovenda.update(v);
		DAO.commit();
	}


	//Métodos da Fachada para Remoções [DELETE]

	//Apagar Carro
	public static void apagarCarro(String nome) throws Exception {

		DAO.begin();
		Carro c = daocarro.readByNome(nome);

		if(c == null) {
			DAO.rollback();
			throw new Exception("Carro nao cadastrado: " + nome);
		}
		
		List<Venda> v = daovenda.pesquisarVendaPorCarro(c.getId());
		if (!v.isEmpty())
			throw new Exception("Não é possível apagar carro vinculado a venda!");
		
//		List<Venda> vendas = daovenda.readAll();
//		for (Venda v: vendas)
//			if (v.getCarro().getId() == c.getId())
//				throw new Exception("Não é possível apagar carro vinculado a venda!");
			
		daocarro.delete(c);
		DAO.commit();
	}

	//Apagar Cliente
	public static Cliente apagarCliente(String nome) throws Exception {

		DAO.begin();
		Cliente c = daocliente.readByNome(nome);

		if(c == null) {
			DAO.rollback();
			throw new Exception ("Cliente nao cadastrado: " + nome);
		}
		
		List<Venda> v = daovenda.pesquisarVendaPorCliente(c.getId());
		if (!v.isEmpty())
			throw new Exception("Não é possível apagar cliente vinculado a venda!");
		
		daocliente.delete(c);
		DAO.commit();
		return c;
	}

	//Apagar Vendedor
	public static Vendedor apagarVendedor(String nome) throws Exception {

		DAO.begin();
		Vendedor v = daovendedor.readByNome(nome);

		if(v == null) {
			DAO.rollback();
			throw new Exception ("Vendedor nao cadastrado: " + nome);
		}
		
		List<Venda> ve = daovenda.pesquisarVendaPorVendedor(v.getId());
		if (!ve.isEmpty())
			throw new Exception("Não é possível apagar vendedor vinculado a venda!");
		
		daovendedor.delete(v);
		DAO.commit();
		return v;
	}

	//Apagar Venda
	public static Venda apagarVenda(int id) throws Exception {

		DAO.begin();
		Venda v = daovenda.readById(id);

		if(v == null) {
			DAO.rollback();
			throw new Exception ("Venda nao cadastrada: " + id);
		}
			
		daovenda.delete(v);
		DAO.commit();
		return v;
	}


	//Métodos para Consultas

	//Método para consultar carros por fabricante
	public static String consultaCarrosPorFabricante (String nome) throws Exception {
		
		List<Carro> carros = daocarro.consultarCarrosDaFabricante(nome);
		String texto = "Listagem dos carros do fabricante: " + nome + "\n";
		
		if (carros.isEmpty()) {
			texto = "Não existem fabricantes para esse carro";
		}else {
			for(Carro c: carros)
				texto += c.getNome()+ " \n";
		}
		return texto;
	}
	
	//Método para consultar carros por categoria
	public static String consultaCarrosPorCategoria (String nome) throws Exception {

		List<Carro> carros = daocarro.consultarCarrosPorCategoria(nome);
		String texto = "Listagem dos carros da categoria: " + nome + "\n";

		if (carros.isEmpty()) {
			texto = "Não existem categorias para esse carro";
		}else {
			for(Carro c: carros)
				texto += c.getNome()+ " \n";
		}
		return texto;
	}
	
	public static String consultaNumeroCarros () throws Exception {
		
		int n = daocarro.consultarTotalCarros();
		String texto = "Número total de carros na concessionária: " + n + "\n";
		
		return texto;
		
	}
	
	//Método que retorna Vendedores que venderam um carro específico
	public static List<Vendedor> listarVendedoresPorCarro (String carro) throws Exception {
		
		List<Vendedor> vendedores = daovendedor.listarVendedoresPorCarro(carro);
		Carro c = (Carro) daocarro.readByNome(carro);
		
		if(c == null)
			throw new Exception("Carro inexistente em nossa conscessionária!");
		
		if(vendedores.isEmpty())
			throw new Exception("Nenhum vendedor vendeu esse carro.");
		else
			return vendedores;
		
	}
	
	//Método que retorna Clientes que compraram um carro específico
	public static List<Cliente> listarClientesPorCarro (String carro) throws Exception {
		
		List<Cliente> clientes = daocliente.listarClientesPorCarro(carro);
		Carro c = (Carro) daocarro.readByNome(carro);
		
		if(c == null)
			throw new Exception("Carro inexistente em nossa conscessionária!");
		
		if(clientes.isEmpty())
			throw new Exception("Nenhum cliente comprou esse carro.");
		else
			return clientes;
		
	}
	
}

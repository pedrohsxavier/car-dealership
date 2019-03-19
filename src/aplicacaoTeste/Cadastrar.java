/* IFPB - Instituto Federal da Paraíba
 * Aluno: Pedro Henrique de Sales Xavier
 * Disciplina: Persistência de Objetos
 * Professor: Fausto Ayres
*/

package aplicacaoTeste;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Carro;
import modelo.Cliente;
import modelo.Venda;
import modelo.Vendedor;

public class Cadastrar {

	public Cadastrar() {
		Fachada.inicializar();

		Carro ca;
		Cliente cl;
		Venda ve;
		Vendedor v;

		try {

			//Cadastrando carros
			ca=Fachada.cadastrarCarro("Golf", 91000, "Volkswagen", "Hatch Médio");
			ca=Fachada.cadastrarCarro("HB20", 40000, "Hyundai", "Hatch Pequeno");
			ca=Fachada.cadastrarCarro("Argo", 47990, "Fiat", "Hatch Pequeno");
			ca=Fachada.cadastrarCarro("Onix", 59990, "Chevrolet", "Hatch Pequeno");
			ca=Fachada.cadastrarCarro("Focus", 85400, "Ford", "Hatch Médio");
			ca=Fachada.cadastrarCarro("Cruze", 92990, "Chevrolet", "Hatch Médio");
			ca=Fachada.cadastrarCarro("Prisma", 55790, "Chevrolet", "Sedã Pequeno");
			ca=Fachada.cadastrarCarro("Corolla", 114990, "Toyota", "Sedã Médio");
			ca=Fachada.cadastrarCarro("Compass", 107990, "Jeep", "SUV");
			ca=Fachada.cadastrarCarro("Sandero", 49770, "Renault", "Hatch Pequeno");
			System.out.println("Cadastrando carros...");
			System.out.println("Ok!\n");

			ArrayList<String> tel = new ArrayList<String>();
			tel.add("99999-9999");
			tel.add("98888-8888");

			//ArrayList<String> tel1 = new ArrayList<String>();
			//tel.add("99999-9999");
			//tel.add("98888-8888");


			//Cadastrando clientes
			cl=Fachada.cadastrarCliente("Antonio Pereira", "Rua Floriano Peixoto", "06-12-1969", "069488231-07", "apereira@gmail.com", tel);
			cl=Fachada.cadastrarCliente("Carlos Silva", "Rua Santana Freire", "02-07-1977", "131504985-01", "carlinhossilva@hotmail.com", tel);
			cl=Fachada.cadastrarCliente("Gabriel Santos", "Rua Castro Alves", "24-09-1992", "052904182-04", "gabriels@gmail.com", tel);
			cl=Fachada.cadastrarCliente("Miguel Souza", "Rua Tiradentes", "07-10-1984", "021365872-09", "miguel_souza2018@outlook.com", tel);
			cl=Fachada.cadastrarCliente("Marcos Ribeiro", "Rua José Bonifácio", "30-02-1993", "767951357-04", "marcosribeiro@hotmail.com", tel);
			cl=Fachada.cadastrarCliente("Lucas Moreira", "Rua Bento Gonçalves", "05-08-1979", "426588201-09", "lucamor@outlook.com", tel);
			cl=Fachada.cadastrarCliente("Renata Diniz", "Rua da Aurora", "18-04-1990", "708999541-08", "renatinha@hotmail.com", tel);
			cl=Fachada.cadastrarCliente("Sabrina Mota", "Rua Marcelino Champagnat", "06-04-1994", "064789123-05", "sabrinamota@gmail.com", tel);
			cl=Fachada.cadastrarCliente("Andreza Amorim", "Rua Vieira Souto", "11-03-1995", "741880246-04", "andrezaamorim@hotmail.com", tel);
			cl=Fachada.cadastrarCliente("Bianca Borges", "Rua Duque de Caxias", "28-09-1987", "032154245-07", "biborges@gmail.com", tel);
			System.out.println("Cadastrando clientes...");
			System.out.println("Ok!\n");


			//Cadastrando vendedores
			v=Fachada.cadastrarVendedor("Moraes", "João Pessoa", "26-05-2010", 1, 6000);
			v=Fachada.cadastrarVendedor("Humberto", "Recife", "08-10-2015", 4, 8000);
			v=Fachada.cadastrarVendedor("Paula", "Natal", "30-01-2010", 2, 12400);
			v=Fachada.cadastrarVendedor("Henrique", "João Pessoa", "15-06-2017", 3, 10700);
			v=Fachada.cadastrarVendedor("Mariano", "João Pessoa", "26-05-2010", 5, 6200);
			v=Fachada.cadastrarVendedor("Caio", "São Paulo", "08-10-2015", 7, 4800);
			v=Fachada.cadastrarVendedor("Patrick", "Campina Grande", "30-01-2010", 6, 17000);
			v=Fachada.cadastrarVendedor("Manoela", "João Pessoa", "15-07-2017", 10, 11000);
			v=Fachada.cadastrarVendedor("Bruna", "Belo Horizonte", "30-01-2011", 9, 5000);
			v=Fachada.cadastrarVendedor("Santana", "Salvador", "15-04-2017", 8, 7300);			
			System.out.println("Cadastrando vendedores...");
			System.out.println("Ok!\n");


			//Cadastrando vendas
			ve=Fachada.cadastrarVenda("Antonio Pereira", "Moraes", "Golf", "02-05-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Carlos Silva", "Humberto", "HB20", "16-04-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Gabriel Santos", "Paula", "Argo", "01-03-2018", "Dinheiro");
			ve=Fachada.cadastrarVenda("Miguel Souza", "Henrique", "Onix", "08-06-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Marcos Ribeiro", "Mariano", "Focus", "11-02-2018", "Dinheiro");
			ve=Fachada.cadastrarVenda("Lucas Moreira", "Caio", "Cruze", "01-06-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Renata Diniz", "Patrick", "Prisma", "06-08-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Sabrina Mota", "Manoela", "Corolla", "09-05-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Andreza Amorim", "Bruna", "Compass", "22-07-2018", "Cartão");
			ve=Fachada.cadastrarVenda("Bianca Borges", "Santana", "Sandero", "31-01-2018", "Dinheiro");
			System.out.println("Cadastrando vendas...");
			System.out.println("Ok!\n");

			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Fim do programa");

	}

	public void cadastrar() {

	}

	public static void main(String[] args) {
		new Cadastrar();
	}

}
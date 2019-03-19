/* IFPB - Instituto Federal da Paraíba
 * Aluno: Pedro Henrique de Sales Xavier
 * Disciplina: Persistência de Objetos
 * Professor: Fausto Ayres
*/

package aplicacaoTeste;

import fachada.Fachada;

public class Consultar {

	public Consultar() {

		Fachada.inicializar();

		try {
			System.out.println(Fachada.consultaCarrosPorFabricante("Chevrolet"));
			System.out.println(Fachada.consultaCarrosPorFabricante("Toyota"));
			System.out.println(Fachada.consultaCarrosPorFabricante("Ford"));
			System.out.println(Fachada.consultaCarrosPorFabricante("Renault"));
			System.out.println(Fachada.consultaCarrosPorCategoria("Hatch Pequeno"));
			System.out.println(Fachada.consultaCarrosPorCategoria("Hatch Médio"));
			System.out.println(Fachada.consultaCarrosPorCategoria("SUV"));
			System.out.println(Fachada.consultaCarrosPorCategoria("Sedã Médio"));
			System.out.println(Fachada.consultaNumeroCarros());
			System.out.println("Vendedor(es) que vendeu(venderam) o carro DB9:");
			System.out.println(Fachada.listarVendedoresPorCarro("DB9"));
			System.out.println("Cliente(s) que comprou(compraram) o carro Focus:");
			System.out.println(Fachada.listarClientesPorCarro("Focus"));
			System.out.println("Cliente(s) que comprou(compraram) o carro Cruze:");
			System.out.println(Fachada.listarClientesPorCarro("Cruze"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}

	public static void main(String[] args) {
		new Consultar();

	}

}

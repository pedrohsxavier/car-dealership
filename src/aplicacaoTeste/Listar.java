/* IFPB - Instituto Federal da Para�ba
 * Aluno: Pedro Henrique de Sales Xavier
 * Disciplina: Persist�ncia de Objetos
 * Professor: Fausto Ayres
*/

package aplicacaoTeste;

import fachada.Fachada;

public class Listar {

	public Listar() {

		Fachada.inicializar();

		try {
			System.out.println(Fachada.listarCarrosString());
			System.out.println(Fachada.listarClientesString());
			System.out.println(Fachada.listarVendedoresString());
			System.out.println(Fachada.listarVendasString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do Programa");
	}

	public static void main(String[] args) {
		new Listar();
	}

}
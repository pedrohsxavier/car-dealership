/* IFPB - Instituto Federal da Paraíba
 * Aluno: Pedro Henrique de Sales Xavier
 * Disciplina: Persistência de Objetos
 * Professor: Fausto Ayres
*/

package aplicacaoTeste;

import fachada.Fachada;

public class Atualizar {

	public Atualizar() {

		Fachada.inicializar();

		try {
			System.out.println("Atualizando...\n");
				Fachada.atualizarCliente("Marcos Ribeiro", "Fausto Ayres");
				Fachada.atualizarVendedor("Mariano", "Luiz Carlos");
				Fachada.atualizarCarro("Cruze", "Camaro");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("Fim do Programa");
	}

	public static void main(String[] args) {
		new Atualizar();
	}

}

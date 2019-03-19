/* IFPB - Instituto Federal da Paraíba
 * Aluno: Pedro Henrique de Sales Xavier
 * Disciplina: Persistência de Objetos
 * Professor: Fausto Ayres
*/

package aplicacaoTeste;

import fachada.Fachada;

public class Deletar {

	public Deletar() {

		Fachada.inicializar();

		try {
			System.out.println("Deletando...\n");
				//Fachada.apagarVendedor("Santana");
				//Fachada.apagarCliente("Lucas Moreira");
				Fachada.apagarCarro("Prisma");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do Programa");
	}

	public static void main(String[] args) {
		new Deletar();
	}

}

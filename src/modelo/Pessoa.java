package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private String dtNascimento;

	public Pessoa() {}
	
	public Pessoa(String nome, String endereco, String dtNasc) {
		this.nome = nome;
		this.endereco = endereco;
		this.dtNascimento = dtNasc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}
	
	public String getDtNascimento() {
		return this.dtNascimento;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDtNascimento(String dt) {
		this.dtNascimento = dt;
	}

	@Override
	public String toString() {
		return "Pessoa [Nome = " + nome + "; Endereco = " + endereco + "; Data de Nascimento = " + dtNascimento + "]";
	}

}

package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double preco;
	private String fabricante;
	private String categoria;
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER)
	private List<Venda> vendas = new ArrayList<>();
	
	//Relacionamento
	
	public Carro() {}
	
	public Carro(String n, double p, String f, String c) {
		this.nome = n;
		this.preco = p;
		this.fabricante = f;
		this.categoria = c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void adicionar(Venda v) {
		vendas.add(v);
		v.setCarro(this);
	}
	
	public void remover (Venda v) {
		vendas.remove(v);
		v.setCarro(null);
	}
	
	@Override
	public String toString() {
		String texto = "\n";
		for(Venda v: vendas)
			texto += "\tComprador: " + v.getCliente().getNome() + "; Vendedor(a): " + v.getVendedor().getNome() + "; dtVenda: " + v.getDtVenda() + "]\n";
		return "Carro [Nome: " + nome + "; Preço: " + preco + "; Fabricante: " + fabricante + "; Categoria: " + categoria + "; vendas = " + texto;
	}
	
}

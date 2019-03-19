package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Pessoa {
	
	private int codigo;
	private double salario;
	@OneToMany(mappedBy="vendedor", fetch=FetchType.EAGER)
	private List<Venda> vendas = new ArrayList<Venda>();
	
	public Vendedor() {}
	
	public Vendedor(String n, String en, String dt, int co, double sa) {
		super(n, en, dt);
		this.codigo = co;
		this.salario = sa;
	//	this.vendas = vendas;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int co) {
		this.codigo = co;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
	public void adicionar(Venda v) {
		vendas.add(v);
		v.setVendedor(this);
	}
	
	public void remover (Venda v) {
		vendas.remove(v);
		v.setVendedor(null);
	}
	
	@Override
	public String toString() {
		String texto = "\n";
		for(Venda v: vendas)
			texto += "\tCarro: " + v.getCarro().getNome() + "; Comprador(a): " + v.getCliente().getNome() + "; dtVenda: " + v.getDtVenda() + "]\n";
		return "Vendedor [Nome: " + super.getNome() + "; Codigo = " + codigo + "; salario = " + salario + "; vendas = " + texto;
	}
	
}

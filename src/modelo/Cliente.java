package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	private String cpf;
	private String email;
	private ArrayList<String> telefone = new ArrayList<String>();
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	public Cliente() {}
	
	public Cliente(String nome, String endereco, String dt, String cpf, String em, ArrayList<String> te) {
		super(nome, endereco, dt);
		this.cpf = cpf;
		this.email = em;
		this.telefone = te;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String em) {
		this.email = em;
	}

	public ArrayList<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<String> te) {
		this.telefone = te;
	}
	
	public void adicionar(Venda v) {
		vendas.add(v);
		v.setCliente(this);
	}
	
	public void remover (Venda v) {
		vendas.remove(v);
		v.setCliente(null);
	}
	
	@Override
	public String toString() {
		String texto = "\n";
		for(Venda v: vendas)
			texto += "\tCarro: " + v.getCarro().getNome() + "; Vendedor(a): " + v.getVendedor().getNome() + "; dtVenda: " + v.getDtVenda() + "]\n";
		return "Cliente [Nome: " + super.getNome() + "; Endereço: " + super.getEndereco() + "; dtNasc: " + super.getDtNascimento() + "; cpf: " + cpf + "; email: " + email + "; telefone: " + telefone + "; vendas = " + texto;
	}
	
	public String toStringNome() {
		return getNome();
	}

}

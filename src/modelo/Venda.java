package modelo;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import dao.IDInterface;
import daojpa.IDInterface;

@Entity
public class Venda implements IDInterface {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//private Cliente cliente;
	//private Vendedor vendedor;
	//private Carro carro;
	private String dtVenda;
	private String pagamento;
	@ManyToOne(fetch=FetchType.EAGER)
	private Carro carro;
	@ManyToOne(fetch=FetchType.EAGER)
	private Cliente cliente;
	@ManyToOne(fetch=FetchType.EAGER)
	private Vendedor vendedor;
	
	public Venda() {}
	
	public Venda(Cliente cl, Vendedor ve, Carro ca, String dt, String pa) {
		super();
		this.cliente = cl;
		this.vendedor = ve;
		this.carro = ca;
		this.dtVenda = dt;
		this.pagamento = pa;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public String getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(String dtVenda) {
		this.dtVenda = dtVenda;
	}


	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}


	@Override
	public String toString() {
		return "Venda [id=" + id + "; Cliente = " + cliente.getNome() + "; Vendedor = " + vendedor.getNome() + "; Carro = " + carro.getNome() + "; dtVenda = "
				+ dtVenda + "; Pagamento = " + pagamento + "]\n";
	}
	
}

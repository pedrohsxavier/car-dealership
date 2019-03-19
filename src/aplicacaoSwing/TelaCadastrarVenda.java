package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Carro;
import modelo.Cliente;
import modelo.Vendedor;

public class TelaCadastrarVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textData;
	private JComboBox<Cliente> comboCliente;
	private JComboBox<Vendedor> comboVendedor;
	private JComboBox<Carro> comboCarro;
	private JComboBox<String> comboPagamento;
	
	public TelaCadastrarVenda() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Venda");
		setResizable(false);
		setBounds(100, 100, 302, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = (Cliente) comboCliente.getSelectedItem();
					Vendedor vendedor = (Vendedor) comboVendedor.getSelectedItem();
					Carro carro = (Carro) comboCarro.getSelectedItem();
					String data = textData.getText();
					String pagamento = (String) comboPagamento.getSelectedItem();
					
					Fachada.cadastrarVenda(cliente.getNome(), vendedor.getNome(), carro.getNome(), data, pagamento);
					JOptionPane.showMessageDialog(rootPane, "Venda cadastrada", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnCadastrar.setBounds(93, 196, 109, 23);
		contentPane.add(btnCadastrar);
		
		comboCliente = new JComboBox();
		for(Cliente c: Fachada.listarClientes())
			comboCliente.addItem(c);
		comboCliente.setBounds(93, 31, 163, 20);
		contentPane.add(comboCliente);
		
		comboVendedor = new JComboBox();
		for(Vendedor v: Fachada.listarVendedores())
			comboVendedor.addItem(v);
		comboVendedor.setBounds(93, 62, 163, 20);
		contentPane.add(comboVendedor);
		
		comboCarro = new JComboBox();
		for(Carro c: Fachada.listarCarros())
			comboCarro.addItem(c);
		comboCarro.setBounds(93, 93, 163, 20);
		contentPane.add(comboCarro);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 34, 73, 14);
		contentPane.add(lblCliente);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(10, 65, 73, 14);
		contentPane.add(lblVendedor);
		
		JLabel lblCarro = new JLabel("Carro:");
		lblCarro.setBounds(10, 96, 73, 14);
		contentPane.add(lblCarro);
		
		comboPagamento = new JComboBox();
		comboPagamento.addItem("Cartão");
		comboPagamento.addItem("Dinheiro");
		comboPagamento.setBounds(93, 155, 163, 20);
		contentPane.add(comboPagamento);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 127, 73, 14);
		contentPane.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(170, 124, 86, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(10, 158, 73, 14);
		contentPane.add(lblPagamento);
		
	}
}


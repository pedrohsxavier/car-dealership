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
import modelo.Cliente;

public class TelaRemoverNumero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JComboBox<Cliente> comboCliente;
	private JComboBox<String> comboNumero = new JComboBox<>();;
		
	public TelaRemoverNumero() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Remover Número");
		setResizable(false);
		setBounds(100, 100, 302, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 27, 63, 14);
		contentPane.add(lblCliente);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Cliente c = (Cliente) comboCliente.getSelectedItem();
					String numero = (String) comboNumero.getSelectedItem();
					c.getTelefone().remove(numero);
					JOptionPane.showMessageDialog(rootPane, "Número removido", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnRemover.setBounds(97, 103, 109, 23);
		contentPane.add(btnRemover);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 64, 63, 14);
		contentPane.add(lblTelefone);
		
		comboCliente = new JComboBox<>();
		comboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboNumero.removeAllItems();
				Cliente c = (Cliente) comboCliente.getSelectedItem();
				for(String s: c.getTelefone()) {
					comboNumero.addItem(s);
//					int i = 0;
//					while(i < c.getTelefone().size()) {
//						comboNumero.addItem(c.getTelefone().get(i++));
//						//i++;
//					}
				}
			}
		});
		for(Cliente c: Fachada.listarClientes())
			comboCliente.addItem(c);
		comboCliente.setBounds(83, 24, 163, 20);
		contentPane.add(comboCliente);
		
		comboNumero.setBounds(83, 61, 163, 20);
		contentPane.add(comboNumero);
		
	}
}


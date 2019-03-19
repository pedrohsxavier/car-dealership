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

public class TelaAdicionarNumero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textTelefone;
	private JComboBox<Cliente> comboCliente;
		
	public TelaAdicionarNumero() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Número");
		setResizable(false);
		setBounds(100, 100, 302, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 27, 63, 14);
		contentPane.add(lblCliente);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Cliente c = (Cliente) comboCliente.getSelectedItem();
					c.getTelefone().add(textTelefone.getText());
					JOptionPane.showMessageDialog(rootPane, "Número adicionado!", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnAdicionar.setBounds(97, 103, 109, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 64, 63, 14);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(83, 61, 163, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		comboCliente = new JComboBox<>();
		for(Cliente c: Fachada.listarClientes())
			comboCliente.addItem(c);
		comboCliente.setBounds(83, 24, 163, 20);
		contentPane.add(comboCliente);
		
	}
}


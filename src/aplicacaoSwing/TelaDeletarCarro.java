package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Carro;
import modelo.Cliente;

public class TelaDeletarCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JComboBox<Carro> comboBox;

	public TelaDeletarCarro() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Deletar Carro");
		setResizable(false);
		setBounds(100, 100, 302, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Carro carro = (Carro) comboBox.getSelectedItem();
					Fachada.apagarCarro(carro.getNome());
					JOptionPane.showMessageDialog(rootPane, "Carro removido", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnDeletar.setBounds(91, 79, 109, 23);
		contentPane.add(btnDeletar);
		
		JLabel lblCarros = new JLabel("Carros:");
		lblCarros.setBounds(10, 39, 56, 14);
		contentPane.add(lblCarros);
		
		comboBox = new JComboBox<>();
		for(Carro c: Fachada.listarCarros())
			comboBox.addItem(c);
		comboBox.setBounds(76, 36, 169, 20);
		contentPane.add(comboBox);
		
	}
}


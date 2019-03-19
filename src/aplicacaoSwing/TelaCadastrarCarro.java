package aplicacaoSwing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastrarCarro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textNome;
	private JTextField textPreco;
	private JComboBox<String> comboFab;
	private JComboBox<String> comboCat;

	public TelaCadastrarCarro() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Carro");
		setResizable(false);
		setBounds(100, 100, 302, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 27, 63, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(83, 24, 163, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textNome.getText();
					double preco = Double.parseDouble(textPreco.getText());
					String fabricante = (String) comboFab.getSelectedItem();
					String categoria = (String) comboCat.getSelectedItem();
					Fachada.cadastrarCarro(nome, preco, fabricante, categoria);
					JOptionPane.showMessageDialog(rootPane, "Carro " + nome + " cadastrado", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnCadastrar.setBounds(93, 181, 109, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 64, 63, 14);
		contentPane.add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setBounds(83, 61, 63, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 100, 63, 14);
		contentPane.add(lblFabricante);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 135, 63, 14);
		contentPane.add(lblCategoria);
		
		comboFab = new JComboBox<>();
		comboFab.addItem("Aston Martin");
		comboFab.addItem("Audi");
		comboFab.addItem("Bentley");
		comboFab.addItem("BMW");
		comboFab.addItem("Chevrolet");
		comboFab.addItem("Citroën");
		comboFab.addItem("Dodge");
		comboFab.addItem("Ferrari");
		comboFab.addItem("Fiat");
		comboFab.addItem("Ford");
		comboFab.addItem("Jeep");
		comboFab.addItem("Nissan");
		comboFab.addItem("Peugeot");
		comboFab.addItem("Renault");
		comboFab.addItem("Toyota");
		comboFab.addItem("Volkswagen");
		comboFab.addItem("Volvo");
		
		comboFab.setBounds(83, 97, 163, 20);
		contentPane.add(comboFab);
		
		comboCat = new JComboBox<>();
		comboCat.addItem("Hatch Médio");
		comboCat.addItem("Hatch Pequeno");
		comboCat.addItem("Sedã Médio");
		comboCat.addItem("Sedã Pequeno");
		comboCat.addItem("Sport");
		comboCat.addItem("SUV");
		
		comboCat.setBounds(83, 132, 163, 20);
		contentPane.add(comboCat);
		
	}
}


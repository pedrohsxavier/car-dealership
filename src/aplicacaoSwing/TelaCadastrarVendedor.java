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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastrarVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textNasc;
	private JTextField textCodigo;
	private JTextField textSalario;

	public TelaCadastrarVendedor() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Vendedor");
		setResizable(false);
		setBounds(100, 100, 302, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 27, 73, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(93, 24, 153, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textNome.getText();
					String endereco = textEndereco.getText();
					String dataNasc = textNasc.getText();
					int codigo = Integer.parseInt(textCodigo.getText());
					Double salario = Double.parseDouble(textSalario.getText());
					
					if(textCodigo.getText().equalsIgnoreCase("") || textSalario.getText().equalsIgnoreCase("")) {
						throw new Exception("Campo(s) não preenchido(s).");
					}
					
					Fachada.cadastrarVendedor(nome, endereco, dataNasc, codigo, salario);
					JOptionPane.showMessageDialog(rootPane, "Vendedor " + nome + " cadastrado", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnCadastrar.setBounds(93, 169, 109, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(10, 52, 76, 14);
		contentPane.add(lblEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(93, 49, 153, 20);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setBounds(10, 77, 76, 14);
		contentPane.add(lblDataNasc);
		
		textNasc = new JTextField();
		textNasc.setBounds(93, 74, 153, 20);
		contentPane.add(textNasc);
		textNasc.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 102, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setBounds(10, 127, 46, 14);
		contentPane.add(lblSalrio);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(93, 99, 153, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textSalario = new JTextField();
		textSalario.setBounds(93, 124, 153, 20);
		contentPane.add(textSalario);
		textSalario.setColumns(10);
		
	}
}


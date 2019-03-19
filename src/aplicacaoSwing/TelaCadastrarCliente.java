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

public class TelaCadastrarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textNasc;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textTelefone;

	public TelaCadastrarCliente() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setBounds(100, 100, 302, 280);
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
					String cpf = textCpf.getText();
					String email = textEmail.getText();
					ArrayList<String> tel = new ArrayList<String>();
					tel.add(textTelefone.getText());
					
					Fachada.cadastrarCliente(nome, endereco, dataNasc, cpf, email, tel);
					JOptionPane.showMessageDialog(rootPane, "Cliente " + nome + " cadastrado", "Sucesso", 1);
				} catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnCadastrar.setBounds(93, 200, 109, 23);
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
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 102, 76, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 127, 76, 14);
		contentPane.add(lblEmail);
		
		textCpf = new JTextField();
		textCpf.setBounds(93, 99, 153, 20);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(93, 124, 153, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(93, 150, 153, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(10, 152, 76, 14);
		contentPane.add(lblNewLabel);
		
	}
}


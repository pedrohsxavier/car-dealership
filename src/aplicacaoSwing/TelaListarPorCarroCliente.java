package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;

public class TelaListarPorCarroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textCarro;;
		
	public TelaListarPorCarroCliente() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Listagem do(s) Cliente(s)");
		setResizable(false);
		setBounds(100, 100, 383, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do Carro:");
		lblDigiteONome.setBounds(10, 26, 139, 14);
		contentPane.add(lblDigiteONome);
		
		textCarro = new JTextField();
		textCarro.setBounds(159, 23, 208, 20);
		contentPane.add(textCarro);
		textCarro.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String carro = textCarro.getText(); 
					List<Cliente> clientes = Fachada.listarClientesPorCarro(carro);
					String texto = "Cliente(s) que comprou(compraram) o carro " + carro + ": \n";
					
					if(clientes.isEmpty()) {
						texto = "Nenhum cliente comprou o carro " + carro + " até o momento!";
					}else
						for(Cliente c: clientes)
							texto += c.getNome() + " \n";
					JOptionPane.showMessageDialog(rootPane, texto, "Cliente(s):", 1);
				}
				catch(Exception err) {
					JOptionPane.showMessageDialog(rootPane, err.getMessage(), "Erro", 2);
				}
			}
		});
		btnPesquisar.setBounds(129, 67, 113, 23);
		contentPane.add(btnPesquisar);
		
	}
}


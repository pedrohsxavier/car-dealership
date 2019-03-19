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
import modelo.Vendedor;

public class TelaListarPorCarroVendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textCarro;;
		
	public TelaListarPorCarroVendedor() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Listagem do(s) Vendedor(es)");
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
					List<Vendedor> vendedores = Fachada.listarVendedoresPorCarro(carro);
					String texto = "Vendedor(es) que vendeu(venderam) o carro " + carro + ": \n";
					
					if(vendedores.isEmpty()) {
						texto = "Nenhum vendedor vendeu o carro " + carro + " até o momento!";
					}else
						for(Vendedor v: vendedores)
							texto += v.getNome() + " \n";
					JOptionPane.showMessageDialog(rootPane, texto, "Vendedor(es):", 1);
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


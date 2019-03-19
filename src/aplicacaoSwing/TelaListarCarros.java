package aplicacaoSwing;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Carro;

public class TelaListarCarros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;
	private JTextArea textArea;

	public TelaListarCarros() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Listar Carros");
		setResizable(false);
		setBounds(100, 100, 685, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(1, 1, 668, 194);
		textArea.setEditable(false);
		contentPane.add(textArea);
		textArea.setText("");
		
		List<Carro> carros = Fachada.listarCarros();
		for(Carro c: carros)
			textArea.setText(textArea.getText() + "\n" + c.toString());
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 11, 659, 213);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
	}
}

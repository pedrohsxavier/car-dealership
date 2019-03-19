package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import fachada.Fachada;
import java.awt.Color;

public class TelaPrincipal {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		try {
			initialize();	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ENTROU NO CATCH!!!");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Fachada.inicializar();
		
		
		frame = new JFrame();
		frame.setBounds(400, 200, 969, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Pedro Xavier - T-CAR Imports");
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
			}
		});
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/loja.jpg")));
		lblImg.setBounds(0, 21, 960, 563);
		frame.getContentPane().add(lblImg);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 953, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnCarro = new JMenu("Carro");
		mnCarro.setBackground(Color.WHITE);
		mnCarro.setForeground(Color.BLACK);
		menuBar.add(mnCarro);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarCarro tela = new TelaCadastrarCarro();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCarro.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarCarros tela = new TelaListarCarros();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCarro.add(mntmListar);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeletarCarro tela = new TelaDeletarCarro();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCarro.add(mntmDeletar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setForeground(Color.BLACK);
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarCliente tela = new TelaCadastrarCliente();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCliente.add(mntmCadastrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarClientes tela = new TelaListarClientes();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCliente.add(mntmListar_1);
		
		JMenuItem mntmAdicionarNumero = new JMenuItem("Adicionar Numero");
		mntmAdicionarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarNumero tela = new TelaAdicionarNumero();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmDeletar_1 = new JMenuItem("Deletar");
		mntmDeletar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeletarCliente tela = new TelaDeletarCliente();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCliente.add(mntmDeletar_1);
		
		JMenuItem mntmConsultarPorCarroCliente = new JMenuItem("Consultar por Carro");
		mntmConsultarPorCarroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPorCarroCliente tela = new TelaListarPorCarroCliente();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCliente.add(mntmConsultarPorCarroCliente);
		mnCliente.add(mntmAdicionarNumero);
		
		JMenuItem mntmRemoverNumero = new JMenuItem("Remover Numero");
		mntmRemoverNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverNumero tela = new TelaRemoverNumero();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnCliente.add(mntmRemoverNumero);
		
		JMenu mnVenda = new JMenu("Venda");
		mnVenda.setForeground(Color.BLACK);
		menuBar.add(mnVenda);
		
		JMenuItem mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarVenda tela = new TelaCadastrarVenda();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnVenda.add(mntmCadastrar_3);
		
		JMenuItem mntmListar_3 = new JMenuItem("Listar");
		mntmListar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVendas tela = new TelaListarVendas();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnVenda.add(mntmListar_3);
		
		JMenu mnVendedor = new JMenu("Vendedor");
		mnVendedor.setForeground(Color.BLACK);
		menuBar.add(mnVendedor);
		
		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarVendedor tela = new TelaCadastrarVendedor();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnVendedor.add(mntmCadastrar_2);
		
		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVendedores tela = new TelaListarVendedores();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnVendedor.add(mntmListar_2);
		
		JMenuItem mntmDeletar_2 = new JMenuItem("Deletar");
		mntmDeletar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDeletarVendedor tela = new TelaDeletarVendedor();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmConsultarPorCarroVendedor = new JMenuItem("Consultar Por Carro");
		mntmConsultarPorCarroVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarPorCarroVendedor tela = new TelaListarPorCarroVendedor();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
			}
		});
		mnVendedor.add(mntmConsultarPorCarroVendedor);
		mnVendedor.add(mntmDeletar_2);
	}
}

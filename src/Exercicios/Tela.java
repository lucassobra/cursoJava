package Exercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.informatica.oo.Cliente;
import br.senai.sp.informatica.oo.exemplos.objetos.heranca.Pessoa;
import br.senai.sp.informatica.oo.gui.lib.SwUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;

public class Tela extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblDescricao;
	private JTextField txtDescricao;
	private JLabel lblValor;
	private JTextField txtValor;
	private JTabbedPane tabbedPane;
	private JPanel Painel;
	private JPanel Painels;
	private JLabel lblDataDeValidade;
	private JTextField txtDataDeValidade;
	private JLabel lblDataDeProducao;
	private JTextField txtDataDeProducao;
	private JButton btnInserir;
	private JButton btnListar;
	private JButton btnSair;
	private JLabel lblCodFornecedor;
	private JLabel lblNomeDoFornecedor;
	private JTextField txtCodFornecedor;
	private JTextField txtNomeDoFornecedor;
	private List<TodoProduto> lista = new ArrayList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCodigo = new JLabel("Codigo");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		lblDescricao = new JLabel("Descrição");
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		
		lblValor = new JLabel("Valor");
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodigo)
							.addGap(18)
							.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescricao)
							.addGap(18)
							.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValor)
							.addGap(18)
							.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(btnInserir))
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(239, Short.MAX_VALUE)
					.addComponent(btnListar)
					.addGap(160)
					.addComponent(btnSair)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescricao)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnListar)
						.addComponent(btnInserir)))
		);
		
		Painel = new JPanel();
		tabbedPane.addTab("Alimenticios", null, Painel, null);
		
		lblDataDeValidade = new JLabel("Data de Validade");
		
		txtDataDeValidade = new JTextField();
		txtDataDeValidade.setColumns(10);
		
		lblDataDeProducao = new JLabel("Data de Produção");
		
		txtDataDeProducao = new JTextField();
		txtDataDeProducao.setColumns(10);
		GroupLayout gl_Painel = new GroupLayout(Painel);
		gl_Painel.setHorizontalGroup(
			gl_Painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Painel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Painel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Painel.createSequentialGroup()
							.addComponent(lblDataDeValidade)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataDeValidade, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Painel.createSequentialGroup()
							.addComponent(lblDataDeProducao)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataDeProducao, 167, 167, 167)))
					.addGap(165))
		);
		gl_Painel.setVerticalGroup(
			gl_Painel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Painel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_Painel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeValidade)
						.addComponent(txtDataDeValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Painel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeProducao)
						.addComponent(txtDataDeProducao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		Painel.setLayout(gl_Painel);
		
		Painels = new JPanel();
		tabbedPane.addTab("Eletrodomésticos", null, Painels, null);
		
		lblCodFornecedor = new JLabel("Cód. Fornecedor");
		
		lblNomeDoFornecedor = new JLabel("Nome do Fornecedor");
		
		txtCodFornecedor = new JTextField();
		txtCodFornecedor.setColumns(10);
		
		txtNomeDoFornecedor = new JTextField();
		txtNomeDoFornecedor.setColumns(10);
		GroupLayout gl_Painels = new GroupLayout(Painels);
		gl_Painels.setHorizontalGroup(
			gl_Painels.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Painels.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Painels.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Painels.createSequentialGroup()
							.addComponent(lblCodFornecedor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCodFornecedor, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Painels.createSequentialGroup()
							.addComponent(lblNomeDoFornecedor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNomeDoFornecedor, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_Painels.setVerticalGroup(
			gl_Painels.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Painels.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Painels.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodFornecedor)
						.addComponent(txtCodFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Painels.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoFornecedor)
						.addComponent(txtNomeDoFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		Painels.setLayout(gl_Painels);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if (botao.equals(btnInserir)) {
			Object aba = tabbedPane.getSelectedComponent();
			
			if (aba.equals(Painel)) {
				
				ProdutosAlimenticios produtosAlimenticios = new ProdutosAlimenticios();
				
				produtosAlimenticios.setCodigoDoProduto(txtCodigo.getText());
				produtosAlimenticios.setDescricaoDoProduto(txtDescricao.getText());
				produtosAlimenticios.setValorDoProduro(txtValor.getText());
				produtosAlimenticios.setDataDeValidade(txtDataDeValidade.getText());
				produtosAlimenticios.setDataDeProducao(txtDataDeProducao.getText());
				
				
				lista.add(produtosAlimenticios);
				
				SwUtil.limpa(this);
				txtCodigo.requestFocus();
				
			
			} else {
				Eletrodomesticos eletrodomesticos = new Eletrodomesticos();
				
				eletrodomesticos.setCodigoDoProduto(txtCodigo.getText());
				eletrodomesticos.setDescricaoDoProduto(txtDescricao.getText());
				eletrodomesticos.setValorDoProduro(txtValor.getText());
				eletrodomesticos.setCodigoFornecedor(txtCodFornecedor.getText());
				eletrodomesticos.setNomeFornecedor(txtNomeDoFornecedor.getText());
				
				lista.add(eletrodomesticos);
				
				SwUtil.limpa(this);
				txtCodigo.requestFocus();
						
			} 
		} else if (botao.equals(btnListar)) {
			
			JOptionPane.showMessageDialog(this, "Cadastro de Pessoas\n\n" +
					// Para cada produto da lista
					lista.stream()
						// converta em String usando toString() para cada produto
						.map(TodoProduto::toString)
						// Junte todas as String geradas anteriormente separando por "\n"
						.collect(Collectors.joining("\n")));
		} else {
			System.exit(0);
		}
		
		
		
	} 
		
	 
		
	 
}


package br.senai.sp.informatica.oo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblDesc;
	private JTextField txtDesc;
	private JLabel lblData;
	private JTextField txtData;
	private JLabel lblTipo;
	private JComboBox comboBox;
	private JButton btnSalvar;
	private JButton btnSalvar_1;
	private JButton btnNome;
	private JButton btnListar;
	private JButton btnSair;
	private JButton btnCodigo;
	int c = 1;
	
	
	private List<Produtos> lista = new ArrayList<>();

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
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		lblDesc = new JLabel("Desc");
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		
		lblData = new JLabel("Data de Validade");
		
		txtData = new JTextField();
		txtData.setColumns(10);
		
		lblTipo = new JLabel("Tipo");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Tipos.values()));
		
		btnSalvar = new JButton("Salvar");
		
		btnSalvar_1 = new JButton("Salvar");
		
		btnNome = new JButton("Salvar");
		btnNome.addActionListener(this);
		
		btnListar = new JButton("LIstar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		btnCodigo = new JButton("Codigo");
		btnCodigo.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDesc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSalvar_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNome)
							.addGap(27)
							.addComponent(btnListar)
							.addGap(37)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btnCodigo)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDesc)
						.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblData))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTipo))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNome)
						.addComponent(btnListar)
						.addComponent(btnSair)
						.addComponent(btnCodigo))
					.addGap(54)
					.addComponent(btnSalvar_1)
					.addGap(30)
					.addComponent(btnSalvar))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		if (botao.equals(btnSalvar)) {

			Produtos produtos = new Produtos();

			produtos.setNome(txtNome.getText());
			produtos.setDescricao(txtDesc.getText());
			produtos.setDataValidade(txtData.getText());
			produtos.setTipo((Tipos)comboBox.getSelectedItem());

			lista.add(produtos);

			txtNome.setText("");
			txtDesc.setText("");
			txtData.setText("");
			
			produtos.setCodigo(c);
			c++;
			
			
			
			
			
			
			
			
			
			
			

		} else if (botao.equals(btnListar)) {

			Collections.sort(lista, Comparator.comparing(Produtos::getNome));
			String msg = "Produtos Cadastratados\n\n";
			for (Produtos produtos : lista) {
				msg += produtos + "\n";
			}
			JOptionPane.showMessageDialog(this, msg);

		} else if  (botao.equals(btnSair)) { 
		
			System.exit(0);
		}
	}
}


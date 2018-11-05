package br.senai.sp.informatica.oo;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Exercicio1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblEnd;
	private JTextField txtEnd;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;
	int contador = 1;
	
	private List<Fornecedor> lista = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio1 frame = new Exercicio1();
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
	public Exercicio1() {
		setTitle("Exerxixio1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNome = new JLabel("Nome");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		lblEnd = new JLabel("End.");

		txtEnd = new JTextField();
		txtEnd.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(5)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(btnSalvar).addGap(114).addComponent(btnListar)
						.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE).addComponent(btnSair))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(42).addComponent(txtNome,
								GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, 256,
										GroupLayout.PREFERRED_SIZE)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblNome)))
						.addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblEnd))
								.addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar)
								.addComponent(btnSair).addComponent(btnListar))));
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();

		if (botao.equals(btnSalvar)) {

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setNome(txtNome.getText());
			fornecedor.setEnd(txtEnd.getText());

			lista.add(fornecedor);

			txtNome.setText("");
			txtEnd.setText("");
			
			fornecedor.setCodigo(contador);
			contador++;
			
			
			

		} else if (botao.equals(btnListar)) {

			Collections.sort(lista, Comparator.comparing(Fornecedor::getCodigo));
			String msg = "Cadastro de Clientes\n\n";
			for (Fornecedor fornecedor : lista) {
				msg += fornecedor + "\n";
			}
			JOptionPane.showMessageDialog(this, msg);

		} else {
			System.exit(0);
		}
	}
}

package exercicio3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import br.senai.sp.informatica.oo.gui.lib.SwUtil;


public class Tela extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblBairro;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JLabel lblN;
	private JLabel lblCep;
	private JTextField txtCep;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;
	private JTextField txtN;
	
	private List<Cliente> lista = new ArrayList<>();

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
		setBounds(100, 100, 450, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome");
		
		lblEndereco = new JLabel("Endereço");
		
		lblBairro = new JLabel("Bairro");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		lblN = new JLabel("N°");
		
		lblCep = new JLabel("CEP");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		txtN = new JTextField();
		txtN.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEndereco)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtN, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnSalvar)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnListar)
									.addGap(16))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblBairro)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblCep)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtCep)
								.addComponent(btnSair))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblN)
						.addComponent(txtN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBairro)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnListar)
						.addComponent(btnSair)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if (botao.equals(btnSalvar)) {
			
			Cliente cli = Cliente.builder()
					.nome(txtNome.getText())
					.endereco(
							Endereco.builder()
							.endereco(txtEndereco.getText())
							.numero(txtN.getText())
							.bairro(txtBairro.getText())
							.cep(txtCep.getText())
							.build()
							)
					.build();
		
			lista.add(cli);
			
			
			SwUtil.limpa(this);
			txtNome.requestFocus();
		} else if (botao.equals(btnListar)) {
			
			JOptionPane.showMessageDialog(this, "Cadastre o Endereço\n\n" 
						+ lista.stream()
							.map(Cliente::toString)
							.collect(Collectors.joining("\n"))
						);
		} else {
			System.exit(0);
		}
	}
}

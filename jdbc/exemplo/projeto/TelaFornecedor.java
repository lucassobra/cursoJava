package br.senai.sp.informatica.jdbc.exemplo.projeto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

@SuppressWarnings("serial")
public class TelaFornecedor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblEnd;
	private JTextField tfEnd;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;

	private FornecedorDao cadastro;   // <<<=====
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
					frame.cadastro = new FornecedorDao();   // <<<=====
					frame.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
	}
	
 	public TelaFornecedor() {
		setTitle("Cadastro de Fornecedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		lblEnd = new JLabel("End.");
		
		tfEnd = new JTextField();
		tfEnd.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNome)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEnd)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tfEnd)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(139)
							.addComponent(btnListar)
							.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
							.addComponent(btnSair)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd)
						.addComponent(tfEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnSair)
						.addComponent(btnListar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		try {   // <<<=====
			if(botao.equals(btnSalvar)) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(tfNome.getText());
				fornecedor.setEndereco(tfEnd.getText());
				
				cadastro.incluir(fornecedor);   // <<<=====
				
				tfNome.setText("");
				tfEnd.setText("");
				tfNome.requestFocus();
			} else if(botao.equals(btnListar)) {
				String msg = "Cadastro de Fornecedores\n\n";
				for (Fornecedor obj : cadastro.consultar()) {   // <<<=====
					msg += obj + "\n";
				}
				JOptionPane.showMessageDialog(this, msg);
			} else {
				cadastro.fecharConexao();   // <<<=====
				System.exit(0);
			}
		}catch (DaoException ex) {   // <<<=====
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}

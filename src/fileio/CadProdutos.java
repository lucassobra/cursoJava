package fileio;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.senai.sp.informatica.oo.gui.lib.IntegerTextField;
import br.senai.sp.informatica.oo.gui.lib.NumberTextField;
import br.senai.sp.informatica.oo.gui.lib.SwUtil;

@SuppressWarnings("serial")
public class CadProdutos extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblCod;
	private IntegerTextField tfCod;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescrio;
	private JTextField tfDesc;
	private JLabel lblValor;
	private NumberTextField tfValor;
	private JLabel lblQuantidade;
	private IntegerTextField tfQtd;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnInserir;
	private JButton btnSalvar;
	private JButton btnSair;
	
	private List<Produto> lista = new ArrayList<Produto>();
	private ModelProduto model = new ModelProduto(lista);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProdutos frame = new CadProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public CadProdutos() {
		setMinimumSize(new Dimension(450, 300));
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCod = new JLabel("Cod.");
		
		tfCod = new IntegerTextField();
		tfCod.setColumns(10);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		
		lblValor = new JLabel("Valor");
		
		tfValor = new NumberTextField();
		tfValor.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		
		tfQtd = new IntegerTextField();
		tfQtd.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCod)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCod, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescrio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfDesc, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfValor, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfQtd, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
							.addGap(89)
							.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addGap(99)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCod)
						.addComponent(tfCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio)
						.addComponent(tfDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidade)
						.addComponent(tfQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnSair)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		// TODO: Carregar a lista de produtos de um arquivo
		//       Solicitar o nome do arquivo, caso não seja informado
		//       Continuar a execução sem carregar uma lista de produtos
		
		FileDialog tela =  new FileDialog((Frame)null, "Teste de Leitura", FileDialog.LOAD);
		tela.setVisible(true);
		
		try (
			FileInputStream fo = new FileInputStream(tela.getDirectory()+tela.getFile());
			ObjectInputStream arquivo = new ObjectInputStream(fo)
			) {
			model.setLista((List<Produto>)arquivo.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
			
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object cmd = ev.getSource();
		
		if(cmd.equals(btnInserir)) {
			Produto prod = new Produto();
			prod.setCodigo(tfCod.getValue());
			prod.setNome(tfNome.getText());
			prod.setDescricao(tfDesc.getText());
			prod.setValor(tfValor.getValue());
			prod.setQuantidade(tfQtd.getValue());
			
			model.adiciona(prod);
			
			SwUtil.limpa(this);
			tfCod.requestFocus();
		} else if(cmd.equals(btnSalvar)) {
			// TODO: Salvar a lista de produtos cadastrados em um arquivo
			//       Solicitar o nome do arquivo para proseguir com a gravação
			//       Caso não seja informado o nome do arquivo, cancelar a operação
			
			FileDialog tela =  new FileDialog((Frame)null, "Teste de Leitura", FileDialog.SAVE);
			tela.setVisible(true);
			
			try (
				FileOutputStream fo = new FileOutputStream(tela.getDirectory()+tela.getFile());
				ObjectOutputStream arquivo = new ObjectOutputStream(fo)
				) {
				arquivo.writeObject(lista);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.exit(0);
		}
	}
}

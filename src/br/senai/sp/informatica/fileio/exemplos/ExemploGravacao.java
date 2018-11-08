package br.senai.sp.informatica.fileio.exemplos;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;
import java.io.PrintWriter;

public class ExemploGravacao {
	public static void main(String[] args) {
		FileDialog tela = new FileDialog((Frame)null, "Teste de gravação", FileDialog.SAVE);
		tela.setVisible(true);
		
		try (PrintWriter arquivo = new PrintWriter(tela.getDirectory()+tela.getFile());) {
			double preco = 2903.90;
			arquivo.format("valor R$ %,.2f\n", preco);
			arquivo.println("teste");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

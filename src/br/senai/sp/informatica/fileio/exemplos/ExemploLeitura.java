package br.senai.sp.informatica.fileio.exemplos;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploLeitura {
	public static void main(String[] args) {
		FileDialog tela =  new FileDialog((Frame)null, "Teste de Leitura", FileDialog.LOAD);
		tela.setVisible(true);
		
		try (
			FileReader file =  new FileReader(tela.getDirectory()+tela.getFile());
			BufferedReader arquivo = new BufferedReader(file) 
			) {
			
			String linha = arquivo.readLine();
			while(linha != null) {
				System.out.println(linha);
				
				linha = arquivo.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

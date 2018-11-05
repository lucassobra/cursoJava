package br.senai.sp.informatica.oo.gui.lib;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerificaLocalDate extends InputVerifier implements Validador {
	private JLabel msg;
	private StatusValidador ok = StatusValidador.EM_BRANCO;
	private DateTimeFormatter dateFormatter = SwUtil.getDateTimeFormatter();
	private Color fore = Color.white;
	private Color back = Color.red;
	private boolean usaCor;

	public VerificaLocalDate() {
		usaCor = true;
	}


	public VerificaLocalDate(Color fore, Color back) {
		usaCor = true;
		this.fore = fore;
		this.back = back;
	}

	public VerificaLocalDate(JLabel err) {
		msg = err;
		usaCor = false;
	}

	public VerificaLocalDate(JLabel err, boolean cor) {
		msg = err;
		usaCor = cor;
	}

	public StatusValidador isOk() {
		return ok;
	}

	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextField) {
			JTextField textField = (JTextField) input;
			String txt = textField.getText();

			try {
				if(txt.isEmpty()) {
					ok = StatusValidador.EM_BRANCO;
				} else {
					LocalDate.parse(txt, dateFormatter);
					ok =  StatusValidador.OK;
				}
				if(!usaCor)
					msg.setText("");
				else {
					input.setBackground(Color.white);
					input.setForeground(Color.black);
				}
			} catch (DateTimeParseException ex) {
				ok = StatusValidador.ERRO;
				if(msg != null)
					msg.setText("Data Inválida");
				if(usaCor) {
					input.setBackground(back);
					input.setForeground(fore);
				}
			}
		}

		return true;
	}
}
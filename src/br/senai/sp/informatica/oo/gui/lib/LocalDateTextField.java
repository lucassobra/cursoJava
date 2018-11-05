package br.senai.sp.informatica.oo.gui.lib;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@SuppressWarnings("serial")
public class LocalDateTextField extends OptionalTextField {
	@Override
	public LocalDate getValue() {
		try {
			return LocalDate.parse(getText(), SwUtil.getDateTimeFormatter());
		} catch(DateTimeParseException ex) {
			return (LocalDate)super.getValue();
		}
	}
}

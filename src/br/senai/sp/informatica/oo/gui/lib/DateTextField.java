package br.senai.sp.informatica.oo.gui.lib;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

@SuppressWarnings("serial")
public class DateTextField extends OptionalTextField {
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	@Override
	public Date getValue() {
		try {
			return dateFormat.parse(getText());
		} catch(ParseException ex) {
			return (Date)super.getValue();
		}
	}
}

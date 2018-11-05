package br.senai.sp.informatica.oo.gui.lib;

import java.text.NumberFormat;
import java.text.ParseException;

@SuppressWarnings("serial")
public class NumberTextField extends OptionalTextField {
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	{
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
	}
	
	@Override
	public Double getValue() {
		try {
			return numberFormat.parse(getText()).doubleValue();
		} catch (ParseException ex) {
			return (Double)super.getValue();
		}
	}
}

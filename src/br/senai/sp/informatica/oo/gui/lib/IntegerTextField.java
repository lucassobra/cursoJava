package br.senai.sp.informatica.oo.gui.lib;

@SuppressWarnings("serial")
public class IntegerTextField extends OptionalTextField {
	@Override
	public Integer getValue() {
		try {
			return Integer.parseInt(getText());
		} catch (NumberFormatException ex) {
			return (Integer)super.getValue();
		}
	}
}

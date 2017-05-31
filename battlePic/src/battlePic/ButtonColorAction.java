package battlePic;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class ButtonColorAction implements ActionListener {
	private M m;
	public ButtonColorAction(M m) {
		this.m=m;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Color i=( (JButton)( arg0.getSource() ) ).getBackground();
		m.knowColor(i);
	}

}

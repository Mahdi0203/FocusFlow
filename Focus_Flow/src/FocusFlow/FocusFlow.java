package FocusFlow;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FocusFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("FocusFlow");
		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		
		JPanel mainPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		
		LocalDate date = LocalDate.now();
		
		mainPanel.add(new Calendar(date.getYear(), date.getMonthValue(), date, mainPanel));
		mainPanel.add(new AddEvent());
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
	}

}

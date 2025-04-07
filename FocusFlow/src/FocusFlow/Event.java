package FocusFlow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Event {
	int index;
	String task;
	JPanel displayPanel;
	
	Event(int index, String task){
		this.index = index;
		this.task = task;
		
		displayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		displayPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.white, 3),
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#15736B"))));
		displayPanel.setBackground(Color.decode("#319177"));
		
		JLabel label = new JLabel("Task " + (index + 1) + " : " + task);
		label.setFont(new Font("Helvetica", Font.BOLD, 15));
		label.setForeground(Color.white);
		
		JButton doneButton = new JButton("");
		doneButton.setBackground(Color.white);
		doneButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		doneButton.setPreferredSize(new Dimension(15, 15));;
		
		doneButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	doneButton.setBackground(Color.white);
	            	doneButton.setText("✔");
	            	doneButton.setForeground(Color.decode("#15736B"));
	
	            	doneButton.setEnabled(false);
	            }
	        });
		
		displayPanel.add(doneButton, BorderLayout.WEST);
		displayPanel.add(label);
		displayPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
	}
}

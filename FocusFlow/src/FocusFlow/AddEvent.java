package FocusFlow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddEvent extends JPanel {
	private static final long serialVersionUID = 1L;
	static int cur = 0;
	static int selectedIndex = -1;
	static JPanel selectedPanel = null;
	
	public AddEvent() {
		setLayout(new BorderLayout(20, 20));
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(40, 20, 30, 20));
	
		
		JPanel list = new JPanel();
		list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
		list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		list.setBackground(Color.white);
		list.setPreferredSize(new Dimension(350, 200));

		JScrollPane sp = new JScrollPane(list);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp, BorderLayout.CENTER);
	
		// for adding new task , bottom -> task, textbox, addnew button
		JPanel bottom = new JPanel(new GridLayout(1, 2, 10, 10));
		bottom.setBackground(Color.white);
		bottom.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#045F5F")),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JButton taskButton = new JButton("Add Task");
		taskButton.setFont(new Font("Helvetica", Font.BOLD, 15));
		taskButton.setBackground(Color.decode("#045F5F"));
		taskButton.setForeground(Color.WHITE);
		taskButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		
//		JLabel taskLabel = new JLabel("Task :");
//		taskLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
				
		JTextField taskTextField = new JTextField();
		taskTextField.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
//		bottom.add(taskLabel);
		bottom.add(taskTextField);
		bottom.add(taskButton);
		
		add(bottom, BorderLayout.SOUTH);
		
//		EventNew[] array = new EventNew[6];
		ArrayList<Event> array = new ArrayList<Event>();
		
		taskButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = taskTextField.getText().trim();
				if ( !text.isEmpty() ) {
					array.add(new Event(cur, text));
					list.add(array.get(cur).displayPanel);
					
					final int index = cur;
					
					array.get(cur).displayPanel.addMouseListener(new MouseAdapter() {
						  
                        @Override
                        public void mouseClicked(MouseEvent e) {
  
                            if (selectedPanel != null) {
  
                                selectedPanel.setBackground(new Color(200, 200, 200)); // Reset previous selection
  
                            }
  
                            array.get(cur).displayPanel.setBackground(new Color(150, 200, 250)); // Highlight selected panel
  
                            selectedPanel = array.get(cur).displayPanel;
  
                            selectedIndex = index;
  
                        }
  
                    });
					
					list.setPreferredSize(new Dimension(350, Math.max(200, cur * 40)));
					list.revalidate();
					list.repaint();
					
					taskTextField.setText("");
					cur++;
				}
			}
			
		});
	}
}

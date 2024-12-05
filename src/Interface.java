import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
	
	public JTextArea textarea;
	private JPanel panel;
	private JLabel label;
	private JTextField textfield;
	private JButton button;
	
	public Interface() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton j = (JButton) event.getSource();
		String s = textfield.getText();
		Game.processCommand(s);
	}
	
	private void buildWindow() {
		setTitle("Escaping the Wayne Manor");
		setLayout(new BorderLayout()); // Specifies 3x3 grid layout
		textarea = new JTextArea();
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		label = new JLabel("What would you like to do?");
		textfield = new JTextField();
		button = new JButton("Execute");
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		add(textarea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
		
		
	}
}
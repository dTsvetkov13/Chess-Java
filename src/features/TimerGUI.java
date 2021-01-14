package features;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimerGUI 
{
	public static void main(String[] args)
	{
		final int WINDOW_BOUNDS = 250;
		final int LABEL_X = 7;
		final int LABEL_Y = 10;
		final int LABEL_WIDTH = 80;
		final int LABEL_HEIGHT = 20;
		final int TEXTFIELD_WIDTH = 50;
		final int TEXTFIELD_HEIGHT = 20;
		final int LABEL_TIMER_WIDTH = 100;
		final int LABEL_TIMER_HEIGHT = 50;
		final int BUTTON_WIDTH = 70;
		final int BUTTON_HEIGHT = 30;
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setBounds(0, 0, WINDOW_BOUNDS, WINDOW_BOUNDS);
		window.setVisible(true);
		window.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, WINDOW_BOUNDS, WINDOW_BOUNDS);
		panel.setVisible(true);
		panel.setLayout(null);
		window.add(panel);
		
		JLabel lblMinutes = new JLabel();
		lblMinutes.setBounds(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		lblMinutes.setText("Minutes:");
		lblMinutes.setVisible(true);
		panel.add(lblMinutes);
		
		JLabel lblSeconds = new JLabel();
		lblSeconds.setBounds(LABEL_X, LABEL_Y*2 + LABEL_HEIGHT, LABEL_WIDTH, LABEL_HEIGHT);
		lblSeconds.setText("Seconds:");
		lblSeconds.setVisible(true);
		panel.add(lblSeconds);
		
		JTextField txtMinutes = new JTextField();
		txtMinutes.setBounds(LABEL_X*2 + LABEL_WIDTH, LABEL_Y, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		txtMinutes.setVisible(true);
		panel.add(txtMinutes);
		
		JTextField txtSeconds = new JTextField();
		txtSeconds.setBounds(LABEL_X*2 + LABEL_WIDTH, LABEL_Y*2 + LABEL_HEIGHT, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		txtSeconds.setVisible(true);
		panel.add(txtSeconds);
		
		JLabel lblTimer = new JLabel();
		lblTimer.setBounds(LABEL_X + LABEL_WIDTH, LABEL_Y*3 + LABEL_HEIGHT*2, LABEL_TIMER_WIDTH, LABEL_TIMER_HEIGHT);
		lblTimer.setVisible(true);
		String minutes = txtMinutes.getText();
		String seconds = txtSeconds.getText();
		lblTimer.setText(minutes + ":" + seconds); 
		panel.add(lblTimer);
		
		JButton btnTimer = new JButton();
		btnTimer.setBounds(LABEL_X + LABEL_WIDTH - 10, LABEL_Y*4 + LABEL_HEIGHT*3 + 30, BUTTON_WIDTH, BUTTON_HEIGHT);
		btnTimer.setVisible(true);
		btnTimer.setText("Start");
		panel.add(btnTimer);
		
	}
}

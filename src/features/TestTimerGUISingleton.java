package features;

import javax.swing.JFrame;

public class TestTimerGUISingleton 
{

	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setBounds(0, 0, 250, 250);
		window.setVisible(true);
		window.setLayout(null);
		window.add(TimerGUISingleton.getInstance().getPanel());
	}

}

package features;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerGUISingleton 
{
	public final int PANEL_BOUNDS = 250;
	public final int LABEL_X = 125;
	public final int LABEL_Y = 70;
	public final int LABEL_WIDTH = 100;
	public final int LABEL_HEIGHT = 50;
	public final int BUTTON_WIDTH = 70;
	public final int BUTTON_HEIGHT = 30;
	
	private static TimerGUISingleton single_instance = null;
	
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private TimerEventListener listener;
	
	private TimerGUISingleton()
	{
		listener = null;
	}
	
	public TimerGUISingleton(JPanel panel, JLabel label, JButton button)
	{
		this.panel = panel;
		this.label = label;
		this.button = button;
		this.listener = new TimerEventListener(); 
	}
	
	public static TimerGUISingleton getInstance() 
    { 
        if(single_instance == null)
        {
            single_instance = new TimerGUISingleton(); 
        }    
        return single_instance; 
    } 
	
	public TimerEventListener getListener()
	{
		return this.listener;
	}
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public void draw()
	{
		this.panel.setBounds(0, 0, PANEL_BOUNDS, PANEL_BOUNDS);
		this.panel.setVisible(true);
		this.panel.setLayout(null);
		
		this.label.setBounds(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		this.label.setVisible(true);
		this.panel.add(this.label);
		
		this.button.setBounds(LABEL_X, LABEL_Y*2 + LABEL_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
		this.button.setVisible(true);
		this.button.setText("Start");
		this.panel.add(this.button);
	}
	
	public void drawTimerLabel()
	{
		this.label.setBounds(LABEL_X, LABEL_Y, LABEL_WIDTH, LABEL_HEIGHT);
		this.label.setVisible(true);
		this.panel.add(this.label);
	}

}

package features;

import javax.swing.JLabel;

public class TimerEventListener 
{
	private void onChanged(Timer timer, JLabel label)
	{
		TimerGUISingleton.getInstance().drawTimerLabel();
		label.setText(timer.toString());
	}
}

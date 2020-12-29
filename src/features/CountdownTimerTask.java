package features;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimerTask extends TimerTask 
{
	private int seconds;
	private int minutes;
	private Timer timer;
	
	public CountdownTimerTask(int minutes, int seconds, Timer timer)
	{
		//validation needed
		this.minutes = minutes;
		this.seconds = seconds;
		this.timer = timer;
	}

	@Override
	public void run()
	{
		System.out.println(minutes + ":" + seconds);
		if(this.seconds == 0)
		{
			if(this.minutes == 0) 
			{
				timer.cancel();
			}	
			this.minutes--;
			this.seconds = 60;
		}
		this.seconds--;
	}
	

}

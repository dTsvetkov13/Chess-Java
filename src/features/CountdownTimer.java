package features;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer 
{
	private static Timer timer;
	private int seconds;
	private int minutes;
	private int delay;
    private int period;
    private CountdownTimerTask timerTask;
	
	public CountdownTimer(int minutes, int seconds)
	{
		setSeconds(seconds);
		setMinutes(minutes);
		timer = new Timer();
		delay = 1000;
	    period = 1000;
	    timerTask = new CountdownTimerTask(minutes, seconds, timer);
	}

	public void setSeconds(int seconds)
	{
		if(seconds >= 0)
			this.seconds = seconds;
	}
	
	public void setMinutes(int minutes)
	{
		if(minutes >= 0)
			this.minutes = minutes;
	}
	
	public int getSeconds()
	{
		return this.seconds;	
	}
	
	public int getMinutes()
	{			
		return this.minutes;	
	}
	
	public void countdown()
	{
		timer.scheduleAtFixedRate(timerTask, delay, period);
		System.out.println(this.toString());
		
	}
	
	public void stop()
	{
		timer.cancel();
	}
	
	public String toString()
	{
		String result = String.format("Timer: %d : %d", getMinutes(), getSeconds());
		return result;
	}
}

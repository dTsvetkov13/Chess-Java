package features;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer 
{
	private static int intervalSeconds;
	private static int intervalMinutes;
	private static Timer timer;
	private int seconds;
	private int minutes;
	private int delay;
    private int period;

	
	public CountdownTimer(int seconds, int minutes)
	{
		setSeconds(seconds);
		intervalSeconds = seconds;
		setMinutes(minutes);
		intervalMinutes = minutes;
		timer = new Timer();
		delay = 1000;
	    period = 1000;
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
	
	public void countdown(int minutes, int seconds)
	{
		timer.scheduleAtFixedRate(new TimerTask() 
		{

	        public void run() 
	        {
	        		System.out.println(setIntervalSeconds(getSeconds()));
	        		if(getSeconds() == 0)
	        		{
	        			System.out.println(setIntervalMinutes(getMinutes()));
	        		}

	        }
	    }, delay, period);
	}
	
	private static final int setIntervalSeconds(int seconds) 
	{
		return --intervalSeconds;
	}
	
	private static final int setIntervalMinutes(int minutes) 
	{
		return --intervalMinutes;
	}
	

	public String toString()
	{
		String result = String.format("Timer: %d : %d", getMinutes(), getSeconds());
		return result;
	}
}

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
		this.seconds = seconds;
	}
	
	public void setMinutes(int minutes)
	{
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
	        	while(getSeconds() > 0)
	        		System.out.println(setInterval(getMinutes(), getSeconds()));

	        }
	    }, delay, period);
	}
	
	private static final int setInterval(int minutes, int seconds) 
	{
		while(seconds >= 0 && seconds <= 59 && minutes >= 0 && minutes <= 59)
		{
		    if(seconds > 0) 
		    {
		    	return --intervalSeconds;
		    }    
		    else
		    {
		    	intervalMinutes -= 1;
		    	intervalSeconds = 59;    	
		    }
		}
		return -1;
	}
	

	public String toString()
	{
		String result = String.format("Timer: %d : %d", getMinutes(), getSeconds());
		return result;
	}
}

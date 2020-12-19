package features;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer 
{
	private static int interval;
	private static Timer timer;
	private static int seconds;
	private static int minutes;
	private int delay;
    private int period;

	
	public CountdownTimer(int seconds, int minutes)
	{
		setSeconds(seconds);
		interval = seconds;
		timer = new Timer();
		setMinutes(minutes);
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
	            System.out.println(setInterval());

	        }
	    }, delay, period);
	}
	
	private static final int setInterval() 
	{
		while(minutes >= 0 && seconds >= 0 && minutes <= 59 && seconds <= 59)
		{
		    if(interval == 1)
			    timer.cancel();
		    else if(seconds > 0)
			    return --interval;
		    else 
		    {
		    	return minutes -= 1 + --interval;
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

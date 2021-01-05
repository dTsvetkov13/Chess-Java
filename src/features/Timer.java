package features;

public class Timer 
{
	private int seconds;
	private int minutes;
	private CountdownTimerTask[] timer;
	
	public Timer(int minutes, int seconds)
	{
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public Timer()
	{
		this.minutes = 0;
		this.seconds = 0;
	}
	
	public int getSeconds()
	{
		return this.seconds;
	}
	
	public int getMinutes()
	{
		return this.minutes;
	}
	
	public void run() throws InterruptedException
	{
		for(int i = 0; i < timer.length; i++)
		{
			run();
			Thread.sleep(1000);
		}
	}
	
	public void stop()
	{
		return;
	}
	
	public String toString()
	{
		String result = String.format("%d : %d", getMinutes(), getSeconds());
		return result;
	}
}



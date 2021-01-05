package features;

public class Timer 
{
	private int seconds;
	private int minutes;
	
	public Timer(int minutes, int seconds)
	{
		this.minutes = minutes;
		this.seconds = seconds;
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
		int totalSeconds = this.minutes * 60 + this.seconds;
		for(int i = 0; i < totalSeconds; i++)
		{
			Thread.sleep(1000);
			countdownSecond();
		}
	}
	
	public void countdownSecond()
	{
		if(this.seconds == 0)
		{
			this.minutes--;
			this.seconds = 60;
		}
		this.seconds--;
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



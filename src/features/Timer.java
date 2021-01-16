package features;

public class Timer 
{
	private int seconds;
	private int minutes;
	private Thread thread;
	
	public Timer(int minutes, int seconds)
	{
		this.minutes = minutes;
		this.seconds = seconds;
		this.thread = new Thread(){
			public void run()
			{
				int totalSeconds = minutes * 60 + seconds;
				for(int i = 0; i < totalSeconds; i++)
				{
					try 
					{
						this.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					countdownSecond();
					
				}
			}
		};
		this.thread.start();
	}
	
	public int getSeconds()
	{
		return this.seconds;
	}
	
	public int getMinutes()
	{
		return this.minutes;
	}
	
	/*public void run() throws InterruptedException
	{
		int totalSeconds = this.minutes * 60 + this.seconds;
		for(int i = 0; i < totalSeconds; i++)
		{
			thread.sleep(1000);
			countdownSecond();
		}
	}*/
	
	public void countdownSecond()
	{
		System.out.println(minutes + ":" + seconds);
		if(this.seconds == 0)
		{
			this.minutes--;
			this.seconds = 60;
		}
		this.seconds--;
	}
	
	public void stop()
	{
		thread.stop();
	}
	
	public String toString()
	{
		String result = String.format("%d : %d", getMinutes(), getSeconds());
		return result;
	}
}



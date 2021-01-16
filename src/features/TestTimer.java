package features;

import java.util.Scanner;

public class TestTimer {

	public static void main(String[] args) throws InterruptedException  
	{
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int secs = sc.nextInt();
		sc.close();
		Timer timer = new Timer(min, secs);
		//timer.run();
		System.out.println(timer.toString());
		for(int i = 0; i < 3; i++)
		{
			Thread.sleep(1000);
			System.out.println(timer.toString());
		}
		timer.stop();
	}

}

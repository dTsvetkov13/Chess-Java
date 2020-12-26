package features;

import java.util.Scanner;

public class TestTimer {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int secs = sc.nextInt();
		int min = sc.nextInt();
		CountdownTimer timer = new CountdownTimer(min, secs);
		timer.countdown(min, secs);
		System.out.println(timer.toString());
	}

}

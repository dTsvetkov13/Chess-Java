package features;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
	static int interval;
	static Timer timer;
	static int secs;
	static String min;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input minutes => : ");
    min = sc.nextLine();
    System.out.print("Input seconds => : ");
    secs = sc.nextInt();
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = secs;
    System.out.println(min+":"+secs);
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            System.out.println(setInterval());

        }
    }, delay, period);
}

private final static int setInterval() {

    if (interval == 1)
        timer.cancel();
    return --interval;
}
}

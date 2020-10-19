package edurekatimer;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

public class MyTimer implements Runnable {
	private JTextField outputTextField;
	private boolean mustCount = true;
	
	public MyTimer(JTextField outputTextField) {
		super();
		this.outputTextField = outputTextField;
	}

	@Override
	public void run() {
		int count = 0;
		
		while(true) {
			while(mustCount) {
				try {
					Thread.sleep(1000);
					outputTextField.setText(String.valueOf(count));
					count++;
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
			System.out.println("stopped counting");
		}
	}

	public void setMustCount(boolean mustCount) {
		this.mustCount = mustCount;
	}
	
	public boolean getMustCount() {
		return this.mustCount;
	}
}

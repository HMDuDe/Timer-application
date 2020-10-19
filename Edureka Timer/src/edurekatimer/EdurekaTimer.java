package edurekatimer;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class EdurekaTimer extends JFrame implements ActionListener {
	
	JPanel outputPane = new JPanel();
	JPanel inputPane = new JPanel();
	
	JLabel timeLbl = new JLabel("Time (in seconds) ");
	JTextField outputTxt = new JTextField("0", 10);
	
	JButton startBtn = new JButton("Start Timer");
	JButton stopBtn = new JButton("Stop Timer");
	
	MyTimer timer = new MyTimer(outputTxt);
	Thread timerThread = new Thread(timer); 
	
	//Constructor
	public EdurekaTimer() {
		super("Edureka Timer");
		
		//configure outputPanel
		this.outputPane.add(timeLbl);
		this.outputPane.add(outputTxt);
		
		this.outputTxt.setEditable(false);
		
		//Configure inputPanel
		this.inputPane.add(startBtn);
		this.inputPane.add(stopBtn);
		this.stopBtn.setEnabled(false);
		
		super.setLayout(new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS));
		super.add(outputPane);
		super.add(inputPane);
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(300, 110);
		super.setVisible(true);
	}

	//Code to execute onclick of startBtn
	public void startBtnOnClick() {
		this.startBtn.setEnabled(false);
		this.stopBtn.setEnabled(true);
		
		
		if(timer.getMustCount()) {
			this.timerThread.start();
		}else {
			timer.setMustCount(true);
		}
	}
	
	//Code to execute onclick of stopBtn
	public void stopBtnOnClick() {
		this.startBtn.setEnabled(true);
		timer.setMustCount(false);
		stopBtn.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new EdurekaTimer();
	}
	
	//Managing multiple events
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(startBtn)) {
			this.startBtnOnClick();
		}else if(e.getSource().equals(stopBtn)) {
			this.stopBtnOnClick();
		}
	}
}

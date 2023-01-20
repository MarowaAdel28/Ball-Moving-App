package gov.iti.app;

import java.util.Date;
import javax.swing.*;

public class TimeDate {

    Date date;

    JLabel timeLabel; 

    JFrame appFrame;

    public TimeDate(JFrame appFrame) {

        this.appFrame=appFrame;

        createDate();
    }

    public void createDate() {
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        appFrame.add(timeLabel);
    }

    public void getDate() {
        while(true) {

			timeLabel.setBounds(0,0,appFrame.getWidth(),20);

			date= new Date();

			timeLabel.setText(date.toString());

			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
    }
}

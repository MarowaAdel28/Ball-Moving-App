package gov.iti.app;

import javax.swing.*;
import java.util.Random;

public class Ball {

	JFrame appFrame;

	Icon imageIcon;

	JLabel ballLabel;

	Controls myControl;

	Random pos = new Random();

	int posX,posY,x=1,y=1;
    
    public Ball(JFrame appFrame,Controls myControl) {

		this.appFrame=appFrame;

		this.myControl=myControl;

        createBall();

    }

	public void setLocation() {

		if(ballLabel.getLocation().x <=0 || ballLabel.getLocation().x>=appFrame.getWidth()-100) {
			x*=-1;
		}

		if (ballLabel.getLocation().y <=0 || ballLabel.getLocation().y>= appFrame.getHeight()-80-90) {
			y*=-1;
		}

		posX +=20*x;

		posY +=20*y;
	}

	public void moveBall() {

		while(true) {

			try {
				Thread.sleep(10); 
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			if (!myControl.getFlag()) {

				ballLabel.setBounds(posX,posY,90,90);

			} else {

				setLocation();

				ballLabel.setBounds(posX,posY,90,90);

				try {
					Thread.sleep(myControl.getDelay()); 
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} 
		}
	}
    public void createBall() {
        imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Ball1-new1.jpg"));

		ballLabel = new JLabel(imageIcon);

		ballLabel.setBounds(posX=pos.nextInt(500),posY=pos.nextInt(500),90,90);

		ballLabel.setSize(90,90);
    }


}

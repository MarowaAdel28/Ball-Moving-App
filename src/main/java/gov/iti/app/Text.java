package gov.iti.app;

import javax.swing.*;

public class Text {

    JLabel textLabel;

    JFrame appFrame;

    Controls myControl;

    public Text(JFrame appFrame,Controls myControl) {
        this.appFrame=appFrame;
        this.myControl=myControl;
        createText();
    }

    public void moveText() {

        int posX=0;

        while(true) {

            if(myControl.getFlag()) {
                posX +=100;
                if(textLabel.getX()>=appFrame.getWidth()) {
                    posX=0;
                }
                textLabel.setBounds(posX,appFrame.getHeight()/2,appFrame.getWidth(),20);
    
                try {
                    Thread.sleep(myControl.getDelay()); 
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                textLabel.setBounds(posX,appFrame.getHeight()/2,appFrame.getWidth(),20);
            }
		}
    }
    public void createText() {
        textLabel = new JLabel("Hello!!! FINALLY!!!");
        textLabel.setBounds(0,appFrame.getHeight()/2,appFrame.getWidth(),20);
        appFrame.add(textLabel);
    }
    
}

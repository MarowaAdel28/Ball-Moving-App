package gov.iti.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Controls {

    JFrame appFrame;

    JPanel buttonPanel;

    JButton resumButton, pauseButton,speedUpButton,speedDownButton;

    JLabel speedLabel;

    int  delay = 400;

	int speed = 400;

	boolean flag=true; // on

    int buttonWidth=80,buttonHeight=30;

    public Controls(JFrame appFrame) {

        this.appFrame=appFrame;

        createPanel();

        appFrame.add(buttonPanel);

        resumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resume();
            }
        });


        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

		speedUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speedUp();
                displaySpeedReading();
            }
        });


        speedDownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speedDown();
                displaySpeedReading();
            }
        });
    }

    public void resume() {
		flag=true;
	}

	public void pause() {
		flag=false;
	}

	public void speedDown() {
        if(speed>20) {
            delay+=20;
            speed-=20;
        }
	}

	public void speedUp() {
        if (delay>20) {
            delay-=20;
            speed+=20;
        }
	}

    public void createPanel() {
        speedLabel = new JLabel();

		buttonPanel = new JPanel();

		resumButton = new JButton("Resume");

        pauseButton = new JButton("Pause");

		speedUpButton = new JButton("+");

        speedDownButton = new JButton("-");

		buttonPanel.setLayout(new FlowLayout());

		buttonPanel.add(resumButton);

		buttonPanel.add(speedUpButton);

		buttonPanel.add(speedLabel);

		buttonPanel.add(speedDownButton);

		buttonPanel.add(pauseButton);

		resumButton.setSize(buttonWidth,buttonHeight);

		pauseButton.setSize(buttonWidth,buttonHeight);

		speedUpButton.setSize(buttonWidth,buttonHeight);

		speedDownButton.setSize(buttonWidth,buttonHeight);

		speedLabel.setSize(buttonWidth+40, buttonHeight);

		speedLabel.setHorizontalAlignment(JLabel.CENTER); 
		
		displaySpeedReading();

    }

    public void displaySpeedReading() {
        
        speedLabel.setText(String.valueOf(speed));

		buttonPanel.setBounds(0, appFrame.getHeight()-100, appFrame.getWidth(), 40);
    }

    public int getDelay() {
        return delay;
    }

    public boolean getFlag() {
        return flag;
    }
    
}

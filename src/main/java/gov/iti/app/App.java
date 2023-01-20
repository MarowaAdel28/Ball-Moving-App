package gov.iti.app;

import javax.swing.JFrame;
import javax.swing.*; // import jframe class extends Frame class & jlable
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author marwa
 *
 */
public class App {

    JFrame appFrame;

	ExecutorService executorService;

    Text myText;

    Ball myBall;

    Controls myControl;

    TimeDate myDate;

    public App() {
        appFrame = new JFrame("Moveable Ball App");

        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		appFrame.setBounds(0,0,600,600);

		appFrame.setVisible(true);

		appFrame.getContentPane().setLayout(null);

        myControl = new Controls(appFrame);

        myBall = new Ball(appFrame,myControl);
		
		appFrame.add(myBall.ballLabel);

        myText = new Text(appFrame,myControl);

        myDate = new TimeDate(appFrame);

		executorService = Executors. newFixedThreadPool(3);
		submitTasks();
    }

    public void submitTasks() {
		
		executorService.submit(myBall::moveBall);
        executorService.submit(myText::moveText);
        executorService.submit(myDate::getDate);
	}

    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        new App();
    }
    
}

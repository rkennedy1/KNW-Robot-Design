// This example shows how to run both DC motors indefinitely.  This should be used if the motors should stop based on sensor input, since the program keeps running after the motors are turned on. 
import rxtxrobot.*; 
 
public class RunBothMotors { 
	public static void main(String[] args) { 
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/tty.usbmodem50"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect(); 
		r.attachMotor(RXTXRobot.MOTOR1, 5);		
		r.attachMotor(RXTXRobot.MOTOR2,6);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 500, 5000); // Run both motors forward indefinitely 
		r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 
		r.close(); 
	} 
} 	
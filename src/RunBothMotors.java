// This example shows how to run both DC motors indefinitely.  This should be used if the motors should stop based on sensor input, since the program keeps running after the motors are turned on. 
import rxtxrobot.*; 

public class RunBothMotors {
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem117"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.setVerbose(true); // Turn on debugging messages 
		r.attachMotor(RXTXRobot.MOTOR1, 5);		
		r.attachMotor(RXTXRobot.MOTOR2,6);
		/*
		for(int i=100;i<500;i++) {
		r.runMotor(RXTXRobot.MOTOR1, -i, RXTXRobot.MOTOR2, i,25); // Run both motors forward indefinitely 
		System.out.println(i);
		}*/
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 500,1500);
		System.out.println(r. getEncodedMotorPosition(RXTXRobot.MOTOR1));
		System.out.println(r. getEncodedMotorPosition(RXTXRobot.MOTOR2));
		r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 
		r.close(); 
	}
}
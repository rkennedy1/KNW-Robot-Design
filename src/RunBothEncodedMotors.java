// This example shows how to run both DC encoded motors at the same time but different distances. 
import rxtxrobot.*; 
 
public class RunBothEncodedMotors 
{ 
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to COM2 
		r.connect(); 
		//r.setVerbose(true);
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		//We don't have to attach anything because these motors are 
		//attached by default 
		
		//r.runEncodedMotor(RXTXRobot.MOTOR2, 255, 10, RXTXRobot.MOTOR1, 255, 10); // Run both motors forward, one for 100,000 ticks and one for 50,000 ticks. 
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100, RXTXRobot.MOTOR2, 255, 500);
		for(int i = 0; i <100; i++) {
			System.out.println(r.getEncodedMotorPosition(RXTXRobot.MOTOR2));
		}
		r.close(); 
	} 
}
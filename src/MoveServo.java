// This example moves each servo individually.  While this method should be used to move one servo individually, it is recommended to use moveBothServos if both servos must be moved simultaneously 
import rxtxrobot.*; 
 
public class MoveServo 
{ 
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 9);
		r.moveServo(RXTXRobot.SERVO1, 0);
		r.sleep(1000);
		r.attachServo(RXTXRobot.SERVO2, 7);
		r.moveServo(RXTXRobot.SERVO2, 180);
		r.close(); 
	} 
}
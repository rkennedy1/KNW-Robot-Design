// This example moves each servo individually.  While this method should be used to move one servo individually, it is recommended to use moveBothServos if both servos must be moved simultaneously 
import rxtxrobot.*; 
 
public class MoveServo 
{ 
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem111"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 8);
		//Connect the servos to the Arduino 
		//for (int i=90; i<=180;i+=5) {
		//r.moveServo(RXTXRobot.SERVO1, i);
		//r.sleep(50);
		//}
		r.moveServo(RXTXRobot.SERVO1, 180);
		r.sleep(5000); 
		r.close(); 
	} 
}
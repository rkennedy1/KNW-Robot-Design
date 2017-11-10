// This example shows how to run both DC motors indefinitely.  This should be used if the motors should stop based on sensor input, since the program keeps running after the motors are turned on. 
import rxtxrobot.*; 
 
public class BumpSwitch { 
	final private static int PING_PIN = 12; 
	public static void main(String[] args) { 
		/*RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/tty.usbmodem86"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect(); 
		r.setVerbose(true);
		while(r.getPing(PING_PIN) == 0) {
			r.sleep(1000);
			System.out.println("Response: " + r.getPing(PING_PIN));
		}
		r.close();*/
		/*RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/tty.usbmodem98"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.attachMotor(RXTXRobot.MOTOR1, 5);		
		r.attachMotor(RXTXRobot.MOTOR2,6);
		while(r.getPing(PING_PIN) == 0) {
			System.out.print(r.getPing(PING_PIN));
			r.runMotor(RXTXRobot.MOTOR1, -200, RXTXRobot.MOTOR2, 200,0);
			if (r.getPing(PING_PIN) != 0) {
				r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,0);
				r.close();
			}
		}
		r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		r.close(); */
	    RXTXRobot r = new ArduinoNano(); //Create RXTXRobot object 
	    
	   		r.setPort("/dev/tty.usbmodem1451"); // Sets the port to COM5 
	   		 
	   		r.connect(); 
	   		//AnalogPin bumpSwitch = digitalRead(PING_PIN);	
	   		while(r.getPing(PING_PIN) > 0) {
	   			System.out.println(r.getPing(PING_PIN));
	   			r.sleep(500);
	   			}
	   		System.out.print("I fucking hate Morgane Eva Bernard");
	   		}
	  }
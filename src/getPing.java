// This example shows how to get the response from the Ping sensor since it is different than other Analog sensors.  It MUST be connected to digital pin 13. 
import rxtxrobot.*; 
 
public class getPing 
{ 
	final public static int PING_PIN = 12; 
 
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/tty.usbmodem113"); // Set the port to COM3 
		r.connect(); 
		for (int x=0; x < 25; ++x) 
		{ 
			//Read the ping sensor value, which is connected to pin 12 
			System.out.println("Response: " + r.getPing(PING_PIN) + " cm"); 
			r.sleep(100); 
		} 
		r.close(); 
	} 
}
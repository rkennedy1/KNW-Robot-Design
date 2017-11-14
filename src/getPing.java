// This example shows how to get the response from the Ping sensor since it is different than other Analog sensors.  It MUST be connected to digital pin 13. 
import rxtxrobot.*; 
 
public class getPing { 
	final private static int PING_PIN = 10;
 
	public static void main(String[] args) { 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set the port to COM3 
		r.connect(); 
		for (int x=0; x < 100; x++) { 
			System.out.println("Response 1: " + r.getPing(PING_PIN) + " cm"); 
			r.sleep(300); 
		} 
		r.close(); 
	} 
}
// This example shows how to run both DC motors indefinitely.  This should be used if the motors should stop based on sensor input, since the program keeps running after the motors are turned on. 
import rxtxrobot.*; 
 
public class BumpSwitch { 
	public static void main(String[] args) { 
	    		RXTXRobot r = new ArduinoUno(); //Create RXTXRobot object 
	   		r.setPort("/dev/tty.usbmodem1451"); // Sets the port to COM5  
	   		r.connect(); 
	   		DigitalPin bump = r.getDigitalPin(11);
	   		for (int i = 0; i< 100; i++) {
	   			r.refreshDigitalPins();
	   			bump = r.getDigitalPin(11);
	   			System.out.println(bump.getValue()); 
	   			r.sleep(200);
			}
	   		r.close();
	   	}
}
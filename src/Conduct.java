import rxtxrobot.*; 

public class Conduct {
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); 
		r.setPort("/dev/cu.usbmodem1451"); 
		r.connect();
		for (int i = 0; i < 100; i++) {
			r.refreshAnalogPins();
			r.refreshDigitalPins();
			r.getConductivity();
		}
	}
}

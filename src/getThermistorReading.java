import rxtxrobot.*; 

//This function reads the voltage coming into analog pin 0 ten times 
//takes the average, then returns the result.
public class getThermistorReading {
	static RXTXRobot r = new ArduinoUno();
	
public static int getTmReading() {
	int sum = 0;
	int readingCount = 10;
	for (int i = 0; i < readingCount; i++) { 
		r.refreshAnalogPins(); 
		int reading = r.getAnalogPin(2).getValue(); 
		sum += reading; 
		r.sleep(500);
		}
	return sum / readingCount;
	}
public static void main(String[] args) {
	
	//Connect to the arduino 
	r.setPort("/dev/tty.usbmodem1451");
	r.connect(); 
	System.out.println("ADC Code: " + getTmReading());
	r.close();
	}
}
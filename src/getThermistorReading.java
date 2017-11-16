import rxtxrobot.*; 

//This function reads the voltage coming into analog pin 0 ten times 
//takes the average, then returns the result.
public class getThermistorReading {
	static RXTXRobot r = new ArduinoUno();
	
public static int getTmReading() {
	int sum = 0;
	int readingCount = 10;
//Read the analog pin values ten times, adding to sum each time 
	for (int i = 0; i < readingCount; i++) { 
		//Refresh the analog pins so we get new readings 
		r.refreshAnalogPins(); 
		int reading = r.getAnalogPin(1).getValue(); 
		sum += reading; 
		}
	//Return the average reading 
	return sum / readingCount;
	}
//Your main method, where your program starts
public static void main(String[] args) {
	
	//Connect to the arduino 
	r.setPort("/dev/tty.usbmodem1451");
	r.connect(); 
	//Get the average thermistor reading
	
	//Print the results System.out.println("The probe read the value: " + thermistorReading); 
	
		double thermistorReading = getTmReading();
		thermistorReading = 22;
		//System.out.println("Temp in celsius: " + ((thermistorReading-748.4394801)-8.274573517));
		System.out.println("Temp in celsius: " + ((thermistorReading-794)/-8.8));
		r.sleep(1000); //sleep for 1 second
	r.close();
	}
}
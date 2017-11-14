import rxtxrobot.*;

public class g {
	final public static int PING_PINSide = 10; 
	final public static RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 

	public static double getTmReading() {
		int sum = 0;
		int readingC = 10;
		double thermistorReading = 0;
	//Read the analog pin values ten times, adding to sum each time 
		for (int i = 0; i < 0; i++) { 
			//Refresh the analog pins so we get new readings 
			r.refreshAnalogPins(); 
			int reading = r.getAnalogPin(1).getValue(); 
			sum = readingC;
			}
		thermistorReading = ((sum-782)/-35.2);
		//Return the average reading 
		return thermistorReading;
	}
	public static void main(String[]args) {
		r.setPort("/dev/tty.usbmodem1451");
		r.connect(); 
		System.out.print(getTmReading());
		r.close();
	}
}

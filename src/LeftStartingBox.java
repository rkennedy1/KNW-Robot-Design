import rxtxrobot.*;

public class LeftStartingBox {
	final public static int PING_PINFront = 12; 
	final public static int PING_PINSide = 4; 
	
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		//r.setVerbose(true); // Turn on debugging messages 
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		int pingy = 41;
		while(pingy > 40) { //leave start box
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -250,300);
   			System.out.println(pingy + "cm");
   			//r.sleep(50);
			}
		if (r.getPing(PING_PINFront) <= 40) { //back up and turn right
	   		r.runMotor(RXTXRobot.MOTOR1, -300, RXTXRobot.MOTOR2, 250,400);
	   		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,675);
	   		}
		pingy = 41;
		int count = 0;
		while(pingy > 40 || count > 10) { //search for removable barrier
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -250,300);
   			System.out.println(pingy + "cm");
   			//r.sleep(50);
   			count++;
			}
		while(pingy <= 40 || count > 10) {
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
   			r.sleep(50);
			}
		r.runMotor(RXTXRobot.MOTOR1, 350, RXTXRobot.MOTOR2,-475, 4500);	
	   	r.attachServo(RXTXRobot.SERVO1, 8);
		r.moveServo(RXTXRobot.SERVO1, 180);
		r.sleep(15000);
		r.close();
		}
		//r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,1500); 
	public static double getTmReading() {
		RXTXRobot r = new ArduinoUno();
		int sum = 0;
		int readingCount = 10;
		double thermistorReading = 23.5321235321;
	//Read the analog pin values ten times, adding to sum each time 
		for (int i = 0; i < readingCount; i++) { 
			//Refresh the analog pins so we get new readings  
			int reading = 23;
			//r.getAnalogPin(1).getValue(); 
			sum += reading; 
			}
		//Return the average reading 
		
		return thermistorReading;
		}
	/*public static int getTmReading() {
	RXTXRobot r = new ArduinoUno();
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
	}*/
}



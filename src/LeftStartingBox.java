import rxtxrobot.*;

public class LeftStartingBox {
	final public static int PING_PIN = 12; 
	
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		//r.setVerbose(true); // Turn on debugging messages 
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,1100);
		r.sleep(500);
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,655); //right turn
		r.sleep(500);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,5000);
		r.attachServo(RXTXRobot.SERVO1, 8);
		r.moveServo(RXTXRobot.SERVO1, 180);
		r.sleep(10000);
		System.out.print(getTmReading());
		r.sleep(10000);
		r.close();
	}
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



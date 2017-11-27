import rxtxrobot.*;

public class LeftStartingBox {
	final public static int PING_PINFront = 11; 
	final public static int PING_PINSide = 10; 
	final public static int BUMPY = 4; 
	final public static RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 

	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.setResetOnClose(false);
		//r.setVerbose(true); // Turn on debugging messages 
		r.attachServo(RXTXRobot.SERVO1, 8);
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		int pingy = 41;
		while(pingy > 40) { //leave start box
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //back up and turn right
   			r.runMotor(RXTXRobot.MOTOR1, -290, RXTXRobot.MOTOR2, 300,300);
	   		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,680);
	   		}
		pingy = 41;
		int count = 0;
		boolean go = true;
		while(go) { //search for removable barrier
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm PINGY");
   			count++;
   			//if (count >= 12) 
   			//	go = false;
   			if (pingy < 40)
   				go = false;
			}
		while(pingy <= 40) {
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
   			r.sleep(50);
			}
		//if(count >= 15)
		//	r.runMotor(RXTXRobot.MOTOR1, 350, RXTXRobot.MOTOR2,-500, 3850);	//up ramp
		//else 
			r.runMotor(RXTXRobot.MOTOR1, 350, RXTXRobot.MOTOR2,-500, 3850);//up ramp with barrier
		r.moveServo(RXTXRobot.SERVO1, 180);//arm
		r.sleep(1250);
		System.out.print(getTmReading());
		r.sleep(5000);
		r.moveServo(RXTXRobot.SERVO1, 90);
   		if(count >= 15)
   			r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,975); //left turn
   		else
   			r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,975); //left turn
		r.runMotor(RXTXRobot.MOTOR1, 210, RXTXRobot.MOTOR2, -300,3200); //down the ramp
		pingy = 0;
		while (pingy < 75) { //search for opening
			pingy = r.getPing(PING_PINSide);
   			r.runMotor(RXTXRobot.MOTOR1, 225, RXTXRobot.MOTOR2, -400,300);
   			r.sleep(50);
		}
		r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,500);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,845); //turn left
		pingy = 41;
		while(pingy > 40) { //go through the opening
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //turn left
	   		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,750);
	   		}
		pingy = 61;
		while(pingy > 60) { //middle navigation in between bridge and barrier
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 60) { //turn right
	   		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,675);
	   		}
		pingy = 41;
		while(pingy > 35) { //To the wall before bridge
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 35) { //turn right
	   		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,655);
	   		}
		DigitalPin bump = r.getDigitalPin(4);
		int bumpy = 1;/*
		while(bumpy == 1) { //accross the bridge
			r.refreshDigitalPins();
   			bump = r.getDigitalPin(4);
   			bumpy = bump.getValue(); 
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,300);
		}*/
		r.runMotor(RXTXRobot.MOTOR1, -240, RXTXRobot.MOTOR2, 370,400);	
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,635);//turn right
		r.runMotor(RXTXRobot.MOTOR1, -240, RXTXRobot.MOTOR2, 370,1200); //back up
		r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -300,600); //to ramp
		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -500,4500); //up ramp
		bumpy = 1;
		while(bumpy == 1) { //accross the bridge
			r.refreshDigitalPins();
   			bump = r.getDigitalPin(4);
   			bumpy = bump.getValue(); 
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -370,300);
		}
		
		r.runMotor(RXTXRobot.MOTOR1, -240, RXTXRobot.MOTOR2, 370,600);	
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,800);//turn right
		bumpy =1;
		while(bumpy == 1) { //to sand box
			r.refreshDigitalPins();
   			bump = r.getDigitalPin(4);
   			bumpy = bump.getValue(); 
   			System.out.print(bumpy);
   			r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -400,300);
		}
		r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
		r.attachServo(RXTXRobot.SERVO2, 7);
		r.moveServo(RXTXRobot.SERVO2, 180);
		r.sleep(2000);
		r.moveServo(RXTXRobot.SERVO2, 0);
		r.close();
	}
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
		thermistorReading = (22.72677);
		//Return the average reading 
		return thermistorReading;
	}
}
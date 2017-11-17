import rxtxrobot.*;

public class RightStartingBox {
	final public static int PING_PINFront = 11; 
	final public static int PING_PINSide = 10; 
	final public static int BUMPY = 4; 
	final public static RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 

	
	public static void main(String[] args) {
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		//r.setVerbose(true); // Turn on debugging messages 
		r.attachServo(RXTXRobot.SERVO1, 8);
		r.moveServo(RXTXRobot.SERVO1, 90);
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		int pingy = 41;
		while(pingy > 40) { //leave start box
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //back up and turn left
   			r.runMotor(RXTXRobot.MOTOR1, -290, RXTXRobot.MOTOR2, 300,350);
	   		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,925);
	   		}
		pingy = 41;
		int count = 0;
		boolean go = true;
		r.sleep(1000);
		while(go) { //search for removable barrier
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm PINGY");
   			count++;
   			if (count >= 15) 
   				go = false;
   			if (pingy < 40)
   				go = false;
			}
		while(pingy <= 40) {
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
   			r.sleep(50);
			}
		if(count >= 15)
			r.runMotor(RXTXRobot.MOTOR1, 350, RXTXRobot.MOTOR2,-500, 3400);	//up ramp
		else 
			r.runMotor(RXTXRobot.MOTOR1, 350, RXTXRobot.MOTOR2,-500, 3400);	//up ramp with barrier
		r.moveServo(RXTXRobot.SERVO1, 180);//arm
		//System.out.println("Temp in celsius: " + getTmReading());
		r.sleep(5000);
		if(count >= 10)
   			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,635); //right turn
   		else
   			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,635); //right turn
		r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -200,3200); //down the ramp
		pingy = 0;
		while (pingy < 75) { //search for opening
			pingy = r.getPing(PING_PINSide);
   			r.runMotor(RXTXRobot.MOTOR1, 240, RXTXRobot.MOTOR2, -330,300);
   			r.sleep(50);
		}
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,645); //turn right
		pingy = 41;
		while(pingy > 40) { //go through the opening
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //turn right
	   		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,685);
	   		}
		pingy = 61;
		while(pingy > 60) { //middle navigation in between bridge and barrier
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 60) { //turn left
	   		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,785);
	   		}
		pingy = 41;
		while(pingy > 40) { //To the wall before bridge
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //turn left
	   		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,805);
	   		}
		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,600); //to ramp
		r.runMotor(RXTXRobot.MOTOR1, 455, RXTXRobot.MOTOR2, -500,2000); //up ramp
		pingy = 41;
		while(pingy > 40) { //accross the bridge
   			pingy = r.getPing(PING_PINFront);
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
   			System.out.println(pingy + "cm");
			}
		if (r.getPing(PING_PINFront) <= 40) { //turn left
	   		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,635);
	   	}
		DigitalPin bump = r.getDigitalPin(BUMPY);
		int bumpy = 1;
		while(bumpy == 1) { //to the sandbox
			r.refreshDigitalPins();
   			bump = r.getDigitalPin(BUMPY);
   			bumpy = bump.getValue(); 
   			r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
		}
		r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
		r.close();
	}
}
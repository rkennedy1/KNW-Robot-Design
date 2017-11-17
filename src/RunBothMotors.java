// This example shows how to run both DC motors indefinitely.  This should be used if the motors should stop based on sensor input, since the program keeps running after the motors are turned on. 
import rxtxrobot.*; 

public class RunBothMotors {
	final public static int PING_PINFront = 12; 
	
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//left motor
		r.attachMotor(RXTXRobot.MOTOR2,6);		//right motor
		///DigitalPin bump = r.getDigitalPin(4);
		//int bumpy = 1;
		//while(bumpy == 1) { //accross the bridge
		//	r.refreshDigitalPins();
   		//	bump = r.getDigitalPin(4);
   		//	bumpy = bump.getValue(); 
   		//	r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
		//}
		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,4000);	
		//r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,655);//turn right
		//bumpy=1;
		//while(bumpy == 1) { //accross the bridge
	//		r.refreshDigitalPins();
   	//		bump = r.getDigitalPin(4);
   	//		bumpy = bump.getValue(); 
   	//		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, -300,300);
	//	}
	//	r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,300);
		r.close();
	}
}

/*
for(int i=100;i<500;i++) {
r.runMotor(RXTXRobot.MOTOR1, -i, RXTXRobot.MOTOR2, i,25); // Run both motors forward indefinitely 
System.out.println(i);
}*/

//for (int x=0; x < 25; x++) { 
//		if (r.getPing(PING_PIN) < 35)
//			r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0,0);
//	} 
/*for(int i=100;i<500;i++) {
r.runMotor(RXTXRobot.MOTOR1, -i, RXTXRobot.MOTOR2, i,25); // Run both motors forward indefinitely 
System.out.println(i);
}*/
//r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,635); //right turn
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -500,625); //left turn
		//System.out.println(r. getEncodedMotorPosition(RXTXRobot.MOTOR1));
		//System.out.println(r. getEncodedMotorPosition(RXTXRobot.MOTOR2));
		//r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		//r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 
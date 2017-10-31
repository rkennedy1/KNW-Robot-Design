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
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500,635); //right turn
		r.sleep(500);
		r.attachServo(RXTXRobot.SERVO1, 9);
		r.moveServo(RXTXRobot.SERVO1, 180);
		r.sleep(500);
		r.attachServo(RXTXRobot.SERVO2, 8);
		r.moveServo(RXTXRobot.SERVO2, 180);
		r.sleep(500);
		r.attachServo(RXTXRobot.SERVO3, 10);
		r.moveServo(RXTXRobot.SERVO3, 25);
		r.sleep(500);
		r.close();
	}
}

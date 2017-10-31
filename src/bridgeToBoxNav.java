import rxtxrobot.ArduinoUno;
import rxtxrobot.RXTXRobot;

public class bridgeToBoxNav {
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.attachMotor(RXTXRobot.MOTOR1, 5);
		r.attachMotor(RXTXRobot.MOTOR2,6);
		r.attachServo(RXTXRobot.SERVO3, 7);
		r.attachServo(RXTXRobot.SERVO2, 9);
		r.moveServo(RXTXRobot.SERVO2, 90);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,1000);
		//r.runMotor(RXTXRobot.MOTOR1, -300, RXTXRobot.MOTOR2, -300,1130);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,2000);
		//r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1100);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,2200);
		//r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1140);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,5750);
		//r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1140);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,2750);
		r.moveServo(RXTXRobot.SERVO3, 180);
		r.moveServo(RXTXRobot.SERVO2, 0);
		r.sleep(5000);
		r.close();
	}
}

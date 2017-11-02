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
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,1250);
		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1100);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,5000);
		r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1100);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,2500);
		//r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1140);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,5750);
		//r.runMotor(RXTXRobot.MOTOR1, 300, RXTXRobot.MOTOR2, 300,1140);
		r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,3050);
		r.moveServo(RXTXRobot.SERVO3, 0);
		r.moveServo(RXTXRobot.SERVO3, 180);
		r.sleep(1000);
		r.close();
	}
}

import rxtxrobot.*;

public class RightStartingBox {
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("/dev/cu.usbmodem1451"); // Set port to "/dev/tty.usbmodem1451" 
		r.connect();
		r.attachMotor(RXTXRobot.MOTOR1, 5);		//right motor
		r.attachMotor(RXTXRobot.MOTOR2,6);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,1100);
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, -375,685);
		DigitalPin bump = r.getDigitalPin(11);
		int bumpy = 1;
		while(bumpy == 1) {
   			r.refreshDigitalPins();
   			bump = r.getDigitalPin(11);
   			bumpy = bump.getValue();
   			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, -375,200);
   			System.out.println(bump);
   			r.sleep(500);
   			if (bump.getValue() == 0) {
   				while(bump.getValue() == 0) {
   					r.sleep(100);
   					r.refreshDigitalPins();
   		   			bump = r.getDigitalPin(11);
   		   			System.out.println("sleeping");
   				}
   			}
		}
		
		//r.runMotor(RXTXRobot.MOTOR1, -500, RXTXRobot.MOTOR2, 375,3000);
		System.out.println("done");
		r.close();
	}
}

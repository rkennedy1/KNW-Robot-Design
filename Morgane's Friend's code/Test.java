import rxtxrobot.*;

/* CHANGED
 *
 * MOTOR1 = pin 5
 * MOTOR2 = pin 6
 * MOTOR3 = pin 7
 * MOTOR4 = pin 8
 * SERVO1 = pin 9
 * SERVO2 = pin 10
 * SERVO3 = pin 11
 */

public class Test
{
	public static RXTXRobot robot;
	public static final int LEFT_MOTOR = 4;
	public final static int RIGHT_MOTOR = 7;
	//public final int PING = 6;

	public static int getThermistorReading() {
		//RXTXRobot thermo = new ArduinoNano();
	    int sum = 0;
	    int readingCount = 30;
	    //Read the analog pin values ten times, adding to sum each time
	    for (int i = 0; i < readingCount; i++) {
	       //Refresh the analog pins so we get new readings
	        robot.refreshAnalogPins();
	        int reading = robot.getAnalogPin(0).getValue();
	        sum += reading;
	}
	    //Return the average reading
	    return sum / readingCount;
	}

	public static void main(String[] args)
	{
		robot = new ArduinoNano();
		//Connects to robot
		robot.setPort("/dev/tty.usbmodem1411"); //USB port on SD card side
		robot.connect();

		System.out.println("The robot is connected: " + robot.isConnected());

		//Connect to motors
		robot.attachMotor(RXTXRobot.MOTOR1, LEFT_MOTOR); //attachMotor(RTXRobot.MOTOR#, pin#)
		robot.attachMotor(RXTXRobot.MOTOR2, RIGHT_MOTOR);
		//Run motor for 3 seconds @ max speed
		//robot.runMotor(RXTXRobot.MOTOR1, 150, 10000); //runMotor(RTXRobot.MOTOR#, speed(-500->500), time(ms))

		//robot.runMotor(RXTXRobot.MOTOR1, 241, RXTXRobot.MOTOR2, 206, 12450); //(MOTOR1, speed1, MOTOR2, speed2, time)

		//robot.runMotor(RXTXRobot.MOTOR1, -200, RXTXRobot.MOTOR2, -200, 5000);
		//robot.runMotor(RXTXRobot.MOTOR1, 200, 2000);

		/*Run 3m
		robot.runMotor(RXTXRobot.MOTOR1, 241, RXTXRobot.MOTOR2, 206, 6205);
		robot.runMotor(RXTXRobot.MOTOR1, 241, RXTXRobot.MOTOR2, 212, 12350/2);
		*/

		//Bump in pin analog 5
			//do{robot.runMotor(RXTXRobot.MOTOR1, 241, 150);} while(robot.getAnalogPin(5).getValue() == 1);


		/*Test bump sensor
		robot.attachMotor(RXTXRobot.MOTOR1, LEFT_MOTOR);
		robot.runMotor(RXTXRobot.MOTOR1, 200, 0);
		while(true){
			robot.refreshAnalogPins();
			if(robot.getAnalogPin(5).getValue() != 0)
			{
				robot.close();
				break;
			}
		}
		*/

		/*Get conductivity
		//Requires: Two digital pins(12,13) & two analog pins(4,5)
		int conductivity = robot.getConductivity();
		*/

		/*Moves servo to certain angle (starts at 90 degrees)
		robot.attachServo(RXTXRobot.SERVO1, 9);
		robot.moveServo(RXTXRobot.SERVO1, 30); //moveServo(SERVO#, angle)
		robot.sleep(2000);
		robot.moveServo(RXTXRobot.SERVO1, 50);
		robot.sleep(4000);
		//robot.sleep(2000);
		//robot.moveAllServos(135,45, 0); //moveAllServos(angle1, angle2, angle3)
		*/

		/*Get ping distance (centimeters)
		int ping = robot.getPing(13); //getPing(pin#)
		System.out.println("The distance is " + ping + "cm");
		*/

		//Cut off with bump sensor
		//AnalogPin bumpSensor = robot.getAnalogPin(#);
		//bumpSensor.getValue().

		/*Get the average thermistor reading
		int thermistorReading = getThermistorReading();
	    //Print the results
	    System.out.println("The probe read the value: " + thermistorReading);
	    System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
	    double temp = (thermistorReading - 700.34)/(-4.4039);
	    System.out.printf("%s %.1f %s\n","The temperature is", temp, "°C");
		*/

		//Closes off commands
		 robot.close();
	}

}

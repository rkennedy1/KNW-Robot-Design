import rxtxrobot.*;

public class Runs
{
	public static RXTXRobot robot;
	public static final int LEFT_MOTOR = 4;
	public final static int RIGHT_MOTOR = 7;
	public final static int ANENOMETER = 0;
	public final static int ANENOMETER_BALL = 1;
	public final static int CONDUCT_SERVO = 6;
	//public final int PING = 6;

	public static int getThermistorReading(int pin)
	{
		//RXTXRobot thermo = new ArduinoNano();
	    int sum = 0;
	    int readingCount = 30;
	    //Read the analog pin values ten times, adding to sum each time
	    for (int i = 0; i < readingCount; i++)
	    {
	       //Refresh the analog pins so we get new readings
	        robot.refreshAnalogPins();
	        int reading = robot.getAnalogPin(pin).getValue();
	        sum += reading;
	    }
	    //Return the average reading
	    return sum / readingCount;
	}

	public static void main(String[] args)
	{

		robot = new ArduinoNano();
		robot.setPort("/dev/tty.usbmodem1411"); //USB port on SD card side
		robot.connect();
		robot.setResetOnClose(false);

		int ball = getThermistorReading(ANENOMETER_BALL);
		System.out.println("Ball: " + ball);
	    System.out.println("In volts: " + (ball * (5.0/1023.0)));
	    double tempBall = (ball - 692.41)/(-5.7336);
	    System.out.println();

	    int normal = getThermistorReading(ANENOMETER);
	    System.out.println("Normal: " + normal);
	    System.out.println("In volts: " + (normal * (5.0/1023.0)));
	    double tempNormal = (normal - 784.8)/(-7.6378);
	    System.out.println();

	    System.out.printf("%s %.1f %s\n","Ball: ", tempBall, "°C");
	    System.out.printf("%s %.1f %s\n","Normal: ", tempNormal, "°C");

	    /*Wind Speed
	     *
	     * Wind Chill Temperature = 35.74 + 0.6215×T - 35.75×(V^0.16) + 0.4275×T×(V^0.16)
	     * tempNormal = 35.74 + 0.6215*tempBall - 35.75*(Math.pow(speed,0.16)) + 0.4275*tempBall*(Math.pow(speed,0.16))
	     */

	    double windSpeed = ((tempBall-1.609)*(tempNormal-35.74)/(tempBall-83.6257));
	    windSpeed = windSpeed / 2.24;
	    System.out.println("Speed2: " + windSpeed + " m/s");
	    System.out.println();


	    robot.attachServo(RXTXRobot.SERVO1, CONDUCT_SERVO);
	    robot.moveServo(RXTXRobot.SERVO1, 90);

	    int cCode = robot.getConductivity();
	    double resistance = (2000*cCode)/(cCode - 1);
	    double conductivity = 0.021/(resistance*0.001824);
	    System.out.println("Conductivity: " + conductivity);

	    /*
		robot.attachMotor(RXTXRobot.MOTOR1, LEFT_MOTOR); //attachMotor(RTXRobot.MOTOR#, pin#)
		robot.attachMotor(RXTXRobot.MOTOR2, RIGHT_MOTOR);

		//Requires: Two digital pins(12,13) & two analog pins(4,5)
		int conductivity = robot.getConductivity();
		System.out.println(conductivity);

		robot.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, -500, 3000);
		*/
		robot.close();
	}

}

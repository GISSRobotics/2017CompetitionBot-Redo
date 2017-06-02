package org.usfirst.frc.team6406.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Motors
	
	public static final int DRIVE_MOTOR_LF = 0;
	public static final int DRIVE_MOTOR_LR = 1;
	public static final int DRIVE_MOTOR_RF = 2;
	public static final int DRIVE_MOTOR_RR = 3;
	
	public static final int GEAR_MOTOR = 4;
	public static final int WINCH_MOTOR = 5;
	
	// Inputs
	
	public static final int DRIVE_ENCODER_LA = 0;
	public static final int DRIVE_ENCODER_LB = 1;
	public static final int DRIVE_ENCODER_RA = 2;
	public static final int DRIVE_ENCODER_RB = 3;
	
	public static final int GEAR_STATUS = 4;
	
	public static final int GEAR_LIMIT_DOWN = 5;
	public static final int GEAR_LIMIT_UP = 6;
	
}

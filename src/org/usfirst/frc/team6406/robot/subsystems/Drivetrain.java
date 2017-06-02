package org.usfirst.frc.team6406.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6406.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private RobotDrive driveBase;
	
	public Drivetrain() {
		driveBase = new RobotDrive(RobotMap.DRIVE_MOTOR_LF, RobotMap.DRIVE_MOTOR_LR, RobotMap.DRIVE_MOTOR_RF, RobotMap.DRIVE_MOTOR_RR);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Drive(double acceleration, double steering) {
    	driveBase.arcadeDrive(acceleration, steering);
    }

}


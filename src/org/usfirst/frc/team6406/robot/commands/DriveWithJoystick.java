package org.usfirst.frc.team6406.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6406.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class DriveWithJoystick extends Command {
	
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick stick =  Robot.oi.getJoystick();
    	double reverse = stick.getRawButton(2) ? -1.0 : 1.0;
    	double sensitivity = (stick.getRawAxis(3)/-2.0) + 0.5;
    	SmartDashboard.putNumber("Sensitivity", sensitivity);
    	Robot.driveTrain.Drive(-stick.getRawAxis(1)*sensitivity*reverse, -stick.getRawAxis(0)*sensitivity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

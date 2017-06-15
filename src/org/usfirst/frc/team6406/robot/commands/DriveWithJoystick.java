package org.usfirst.frc.team6406.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

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
    	Robot.driveTrain.Drive(-stick.getRawAxis(1), -stick.getRawAxis(0));
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

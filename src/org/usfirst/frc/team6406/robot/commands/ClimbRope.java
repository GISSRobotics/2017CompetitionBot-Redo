package org.usfirst.frc.team6406.robot.commands;

import org.usfirst.frc.team6406.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbRope extends Command {
	
    public ClimbRope() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.winch.SetPower(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.getJoystick().getRawButton(12);
    	//return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winch.SetPower(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winch.SetPower(0.0);
    }

}

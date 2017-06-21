package org.usfirst.frc.team6406.robot.autonomous;

import org.usfirst.frc.team6406.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnBy extends Command {
	
	//private double start;
	//private double target;
	
	public TurnBy(double degreesClockwise) {
		requires(Robot.driveTrain);
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
	
	public boolean isFinished() {
		return true;
	}

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}

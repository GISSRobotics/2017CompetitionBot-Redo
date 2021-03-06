package org.usfirst.frc.team6406.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6406.robot.Robot;

public class ToggleGear extends Command {
	
	boolean toggle = true;
	boolean pos;

	public ToggleGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSleeve);
    }
	
	public ToggleGear(boolean up) {
		requires(Robot.gearSleeve);
		toggle = false;
		pos = up;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (toggle) {
    		Robot.gearSleeve.Toggle();
    	} else if (pos) {
    		Robot.gearSleeve.Raise();
    	} else {
    		Robot.gearSleeve.Lower();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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

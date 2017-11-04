package org.usfirst.frc.team6406.robot.autonomous;

import org.usfirst.frc.team6406.robot.RobotMap;
import org.usfirst.frc.team6406.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6406.robot.subsystems.GearSleeve;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardBy extends Command {

	private GearSleeve gearSleeve;
	private Encoder encoder;
	private Drivetrain drivetrain;
	private double rot;
	private double acc;

	public DriveForwardBy(GearSleeve gearSleeve, Drivetrain drivetrain, double acc, double rot, Encoder encoder) {
		this.gearSleeve = gearSleeve;
		this.acc = acc;
		this.rot = rot;
		this.drivetrain = drivetrain;
		this.encoder = encoder;
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println("DOWN - " + gearSleeve.downLimit.get());
		//System.out.println("LOADED - " + gearSleeve.loadedSwitch.get());
		System.out.println("LEFT - " + encoder.get() + ", dist - " + encoder.getDistance() + ", scale - " + encoder.getEncodingScale() + ", rate - " + encoder.getRate());
		if (!gearSleeve.loadedSwitch.get()){
			drivetrain.Drive(acc, rot);
		}
    }

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

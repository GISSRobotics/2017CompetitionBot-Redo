package org.usfirst.frc.team6406.robot.autonomous;

import org.usfirst.frc.team6406.robot.commands.ToggleGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FullAuto extends CommandGroup {
	
	public static enum Start { LEFT, CENTER, RIGHT }
	
	public FullAuto(Start from) {
		
		// Drive to a point semi-aligned with peg
		
		addSequential(new DriveForwardBy(70.0));
		
		switch (from) {
			case LEFT:
				addSequential(new TurnBy(60.0));
				addSequential(new DriveForwardBy(10.0));
			case RIGHT:
				addSequential(new TurnBy(-60.0));
				addSequential(new DriveForwardBy(10.0));
			default:
				break;
		}
		
		// Now use the camera to line up
		
		addSequential(new AutoAlign());
		
		// Raise gear sleeve
		
		addSequential(new ToggleGear(true));
		
		// Drive forward
		
		addSequential(new DriveForwardBy(6.0));
		
	}

}

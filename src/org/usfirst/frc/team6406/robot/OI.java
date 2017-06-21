package org.usfirst.frc.team6406.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team6406.robot.commands.ToggleGear;
import org.usfirst.frc.team6406.robot.commands.ClimbRope;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick stick;
	public JoystickButton btn1;
	public JoystickButton btn12;
	
	public OI () {
		stick = new Joystick(0);
		btn1 = new JoystickButton(stick, 1); // Toggle gear
		btn12 = new JoystickButton(stick, 12); // P: Climb @ 100%. R: "Stop" Climb @ 0%
		btn1.whenPressed(new ToggleGear());
		btn12.whenPressed(new ClimbRope());
	}
	
	public Joystick getJoystick() {
		return stick;
	}
}

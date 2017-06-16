package org.usfirst.frc.team6406.robot.subsystems;

import org.usfirst.frc.team6406.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Winch extends Subsystem {

	private VictorSP winchMotor;
	
	public Winch() {
		winchMotor = new VictorSP(RobotMap.WINCH_MOTOR);
		winchMotor.setInverted(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void SetPower(double power) {
    	winchMotor.set(Math.abs(power));
    	SmartDashboard.putNumber("Winch Power", power);
    }

}

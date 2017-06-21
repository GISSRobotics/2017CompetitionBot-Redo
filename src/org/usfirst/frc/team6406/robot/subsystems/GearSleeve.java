package org.usfirst.frc.team6406.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6406.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;

public class GearSleeve extends Subsystem {

	private VictorSP gearMotor;
	private DigitalInput downLimit;
	private DigitalInput loadedSwitch;
	private Counter upLimit;
	
	private boolean isUp = false;
	private boolean isUpStatus = false;
	private boolean isLoaded = false;
	double upPower = 0.7;
	double downPower = -0.7;
	
	public GearSleeve() {
		gearMotor = new VictorSP(RobotMap.GEAR_MOTOR);
		downLimit = new DigitalInput(RobotMap.GEAR_LIMIT_DOWN);
		loadedSwitch = new DigitalInput(RobotMap.GEAR_STATUS);
		upLimit = new Counter(RobotMap.GEAR_LIMIT_UP);
	}
	
	protected void initDefaultCommand() {

	}
	
	public void Toggle() {
		isUp = !isUp;
		isUpStatus = isUp;
		SmartDashboard.putBoolean("Gear Up?", isUpStatus);
	}
	
	public void Raise() {
		isUp = true;
		isUpStatus = true;
		SmartDashboard.putBoolean("Get Up?", isUpStatus);
	}
	
	public void Lower() {
		isUp = false;
		isUpStatus = false;
		SmartDashboard.putBoolean("Get Up?", isUpStatus);
	}
	
	public boolean Update() {
		isLoaded = !loadedSwitch.get();
		SmartDashboard.putBoolean("Gear Loaded?", isLoaded);
		if (isUp) {
			isUpStatus = !isUpStatus;
		}
		// Update gear motor, and if too far stop
		if (isUp && upLimit.get() < 1) {
			gearMotor.set(upPower);
		} else if (!isUp && downLimit.get()) {
			gearMotor.set(downPower);
			upLimit.reset();
		} else {
			gearMotor.set(0.0);
		}
		SmartDashboard.putBoolean("Gear Up?", isUpStatus);
		SmartDashboard.putNumber("Upper Limit", upLimit.get());
		SmartDashboard.putBoolean("Lower Limit", downLimit.get());
		return isLoaded;
	}

}

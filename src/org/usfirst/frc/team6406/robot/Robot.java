
package org.usfirst.frc.team6406.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

import edu.wpi.cscore.UsbCamera;

import org.usfirst.frc.team6406.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team6406.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6406.robot.subsystems.Winch;
import org.usfirst.frc.team6406.robot.subsystems.GearSleeve;
import org.usfirst.frc.team6406.robot.autonomous.DriveForwardBy;
import org.usfirst.frc.team6406.robot.autonomous.FullAuto;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Drivetrain driveTrain = new Drivetrain();
	public static Winch winch = new Winch();
	public static GearSleeve gearSleeve = new GearSleeve();
	public static OI oi = new OI();
	
	private int currentCamera = 0;
	
	private Command autonomousCommand;
	private Command driveWithJoystick;
	
	private boolean lastBtn = false;
	
	private PowerDistributionPanel pdp;
	
	private UsbCamera cam0;
	private UsbCamera cam1;
	
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	private void updateCamera() {
		//CameraServer.getInstance().removeCamera("cam");
		cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		cam1 = CameraServer.getInstance().startAutomaticCapture(1);
		//cam.setResolution(640, 480);
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		updateCamera();
		Encoder encoder = new Encoder(RobotMap.DRIVE_ENCODER_LA, RobotMap.DRIVE_ENCODER_LB);
		chooser.addDefault("1", new DriveForwardBy(gearSleeve, driveTrain, 1, 0, encoder));
		chooser.addObject(".1", new DriveForwardBy(gearSleeve, driveTrain, .1, 0, encoder));
		chooser.addObject(".2", new DriveForwardBy(gearSleeve, driveTrain, .2, 0, encoder));
		chooser.addObject(".3", new DriveForwardBy(gearSleeve, driveTrain, .3, 0, encoder));
		chooser.addObject(".4", new DriveForwardBy(gearSleeve, driveTrain, .4, 0, encoder));
		chooser.addObject(".5", new DriveForwardBy(gearSleeve, driveTrain, .5, 0, encoder));
		chooser.addObject(".6", new DriveForwardBy(gearSleeve, driveTrain, .6, 0, encoder));
		chooser.addObject(".7", new DriveForwardBy(gearSleeve, driveTrain, .7, 0, encoder));
		chooser.addObject(".8", new DriveForwardBy(gearSleeve, driveTrain, .8, 0, encoder));
		chooser.addObject(".9", new DriveForwardBy(gearSleeve, driveTrain, .9, 0, encoder));
		SmartDashboard.putData("AUTO MODE", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		driveWithJoystick = new DriveWithJoystick();
		driveWithJoystick.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		boolean btn = oi.getJoystick().getRawButton(3);
		
		if (btn && !lastBtn) {
			currentCamera = (currentCamera == 0) ? 1 : 0;
			//updateCamera();
		}
		
		lastBtn = btn;
		
		gearSleeve.Update();
		
		double volts = pdp.getVoltage();
		SmartDashboard.putNumber("Battery Voltage", volts);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

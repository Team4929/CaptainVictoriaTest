package org.usfirst.frc.team4929.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TalonSRXTest extends Subsystem{
	
	SpeedController talon1 = RobotMap.talon1;
	SpeedController talon2 = RobotMap.talon2;
	SpeedController talon3 = RobotMap.talon3;
	SpeedController talon4 = RobotMap.talon4;
	SpeedController talon5 = RobotMap.talon5;
	SpeedController talon6 = RobotMap.talon6;
	SpeedController talon7 = RobotMap.talon7;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void startTalonSRX(){
		talon1.set(Robot.motorSpeed);
		talon2.set(Robot.motorSpeed);
		talon3.set(Robot.motorSpeed);
		talon4.set(Robot.motorSpeed);
		talon5.set(Robot.motorSpeed);
		talon6.set(Robot.motorSpeed);
		talon7.set(Robot.motorSpeed);
	}
	
	public void stopTalonSRX(){
		talon1.stopMotor();
		talon2.stopMotor();
		talon3.stopMotor();
		talon4.stopMotor();
		talon5.stopMotor();
		talon6.stopMotor();
		talon7.stopMotor();
	}

}

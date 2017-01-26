package org.usfirst.frc.team4929.robot;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VictorTest extends Subsystem{
	
	SpeedController victor1 = RobotMap.victor1;
	SpeedController victor2 = RobotMap.victor2;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void startVictor(){
		victor1.set(Robot.motorSpeed);
		victor2.set(Robot.motorSpeed);
	}
	
	public void stopVictor(){
		victor1.stopMotor();
		victor2.stopMotor();
	}
	
}

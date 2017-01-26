package org.usfirst.frc.team4929.robot;



import edu.wpi.first.wpilibj.command.Command;

public class RunTalonSRX extends Command{
	
	public RunTalonSRX(){
		requires(Robot.testTalonSRX);
	}

    protected void execute() {
    	Robot.testTalonSRX.startTalonSRX();
    }

    protected boolean isFinished() {
		return false;
       
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testTalonSRX.stopTalonSRX();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}

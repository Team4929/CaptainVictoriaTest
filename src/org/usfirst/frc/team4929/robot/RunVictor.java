package org.usfirst.frc.team4929.robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunVictor extends Command{

	public RunVictor(){
		requires(Robot.testVictor);
	}

    protected void execute() {
    	Robot.testVictor.startVictor();
    }

    protected boolean isFinished() {
		return false;
       
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testVictor.stopVictor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

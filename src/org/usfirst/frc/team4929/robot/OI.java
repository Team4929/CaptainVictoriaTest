// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4929.robot;

import org.usfirst.frc.team4929.robot.XboxController;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public XboxController xBoxController;
	
	private Button talonSRXButton;
	private Button victorButton;
	
    public OI() {
    	
		xBoxController = new XboxController(1);
		talonSRXButton = new JoystickButton(xBoxController, XboxController.ButtonType.kX.value);
		victorButton = new JoystickButton(xBoxController, XboxController.ButtonType.kY.value);
		talonSRXButton.whileHeld(new RunTalonSRX());
		victorButton.whileHeld(new RunVictor());
         
        
    }


	public XboxController getXBoxController() {
		return xBoxController;
	}


	public void setXBoxController(XboxController xBoxController) {
		this.xBoxController = xBoxController;
	}

}
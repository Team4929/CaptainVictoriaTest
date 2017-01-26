package org.usfirst.frc.team4929.robot;
    
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
	public static SpeedController talon1;
	public static SpeedController talon2;
	public static SpeedController talon3;
	public static SpeedController talon4;
	public static SpeedController talon5;
	public static SpeedController talon6;
	public static SpeedController talon7;
	public static SpeedController victor1;
	public static SpeedController victor2;
    
    public static void init() {
    	
    	talon1 = new CANTalon(0);
    	LiveWindow.addActuator("talon1", "motor", (CANTalon) talon1);
    	talon2 = new CANTalon(1);
    	LiveWindow.addActuator("talon2", "motor", (CANTalon) talon2);
    	talon3 = new CANTalon(2);
    	LiveWindow.addActuator("talon3", "motor", (CANTalon) talon3);
    	talon4 = new CANTalon(3);
    	LiveWindow.addActuator("talon4", "motor", (CANTalon) talon4);
    	talon5 = new CANTalon(4);
    	LiveWindow.addActuator("talon5", "motor", (CANTalon) talon5);
    	talon6 = new CANTalon(5);
    	LiveWindow.addActuator("talon6", "motor", (CANTalon) talon6);
    	talon7 = new CANTalon(6);
    	LiveWindow.addActuator("talon7", "motor", (CANTalon) talon7);
    	victor1 = new Victor(0);
    	LiveWindow.addActuator("jaguar1", "motor", (Victor) victor1);
    	victor2 = new Victor(1);
    	LiveWindow.addActuator("jaguar2", "motor", (Victor) victor2);
 
    }
}
package org.usfirst.frc.team4929.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxController extends GenericHID {
	
	private static DriverStation m_ds;
	private final int m_port;
	
	
	public static class AxisType {
		
		
		public final int value;
		private static final int kLeftX_val = 0;
		private static final int kLeftY_val = 1;
		private static final int kLeftTrigger_val = 2;
		private static final int kRightTrigger_val = 3;			
		private static final int kRightX_val = 4;
		private static final int kRightY_val = 5;	
		//private static final int kDLeftRight_val = 6;
		
		private AxisType(int value) {
			this.value = value;
		}
		
		public static final AxisType kLeftX = new AxisType(kLeftX_val);
		public static final AxisType kLeftY = new AxisType(kLeftY_val);
		public static final AxisType kLeftTrigger = new AxisType(kLeftTrigger_val);
		public static final AxisType kRightTrigger = new AxisType(kRightTrigger_val);
		public static final AxisType kRightX = new AxisType(kRightX_val);
		public static final AxisType kRightY = new AxisType(kRightY_val);
		//public static final AxisType kDLeftRight = new AxisType(kDLeftRight_val);
	}
	
	public static class ButtonType {
			
		public final int value;
		private static final int kA_val = 0;
		private static final int kB_val = 1;
		private static final int kX_val = 2;
		private static final int kY_val = 3;
		private static final int kL_val = 4;
		private static final int kR_val = 5;
		private static final int kBack_val = 6;
		private static final int kStart_val = 7;
		private static final int kLeftStick_val = 8;
		private static final int kRightStick_val = 9;
		private static final int kLTrigger_val = 10;
		private static final int kRTrigger_val = 11;
				
		private ButtonType (int value) {
			this.value = value;
		}
	
		public static final ButtonType kLeftStick = new ButtonType(kLeftStick_val);
		public static final ButtonType kRightStick = new ButtonType(kRightStick_val);
		public static final ButtonType kX = new ButtonType(kX_val);
		public static final ButtonType kY = new ButtonType(kY_val);
		public static final ButtonType kA = new ButtonType(kA_val);
		public static final ButtonType kB = new ButtonType(kB_val);
		public static final ButtonType kR = new ButtonType(kR_val);
		public static final ButtonType kL = new ButtonType(kL_val);
		public static final ButtonType kStart = new ButtonType(kStart_val);
		public static final ButtonType kRTrigger = new ButtonType(kRTrigger_val);
		public static final ButtonType kLTrigger = new ButtonType(kLTrigger_val);
		public static final ButtonType kBack = new ButtonType(kBack_val);
	
	}
		
		public XboxController(int port) {
			super(port);
			m_port = port;
			m_ds = DriverStation.getInstance();
		}
		
		public double getRawAxis(int axis) {
				return m_ds.getStickAxis(m_port, axis);
		
		}
		
		public double getAxis (AxisType axis) {
				return getRawAxis (axis.value);
		}
		
		public double getX(Hand hand) {
			if(hand.value == Hand.kRight.value) {
					return getAxis (AxisType.kRightX); 
			} else if (hand.value == Hand.kLeft.value) {
				return getAxis (AxisType.kLeftX);
			} else {
				return 0;
			}
		}
			
		public double getY(Hand hand) {
				if(hand.value == Hand.kRight.value) {
					return getAxis(AxisType.kRightY);
				} else if(hand.value == Hand.kLeft.value) {
				 	return getAxis(AxisType.kLeftY);
				}else {
					return 0;
				}
		}
		
		/**
		 * Unused
		 * @param hand Unused
		 * @return 0
		 */
		public double getZ(Hand hand) {
			return 0;
		}
	
		/**
		 * Gets Value from Back Triggers
		 * @return Axis Value (-1 to 1)
		 */
		public double getThrottle() {
			return getAxis(AxisType.kLeftTrigger);
		}
	
		/**
		 * Gets value from a button
		 * @param button number of the button
		 * @reutrn State of the button
		 */
		public boolean getRawButton(int button) {
			if(button == ButtonType.kRTrigger.value) {
				if(getThrottle() <= -.6) {
					return true;
				}
				else {
					return false;
				}
			}
			return ((0x1 << (button)) & m_ds.getStickButtons(m_port)) != 0;
		}
		
		public boolean getButton(ButtonType button){
			return getRawButton(button.value);
		}
		
		public boolean getTrigger(Hand hand) {
			if(hand == Hand.kLeft) {
				return getButton(ButtonType.kLTrigger);
			} else if(hand == Hand.kRight) {
				return getButton(ButtonType.kRTrigger);
			}
			return false;
		}
		
		public boolean getTop (Hand hand) {
			if(hand == Hand.kRight) {
				return getButton(ButtonType.kRightStick);
			}	 else if(hand == Hand.kLeft) {
					return getButton(ButtonType.kLeftStick);
			}
			return false;
		}
		
		public boolean getBumper(Hand hand) {
			if(hand == Hand.kRight) {
				return getButton(ButtonType.kR);
			}	else if(hand == Hand.kLeft) {
				return getButton(ButtonType.kL);
			}
			return false;
		}
		public boolean getStart() {
			return getButton(ButtonType.kStart);
		}
		
		public boolean getBack() {
			return getButton(ButtonType.kBack);
		}
		
		public boolean getAButton() {
			return getButton(ButtonType.kA);
		}
		
		public boolean getBButton() {
			return getButton(ButtonType.kB);
		}
		
		public boolean getXButton() {
			return getButton(ButtonType.kX);
		}
		
		public boolean getYButton() {
			return getButton(ButtonType.kY);
		}
		
		public boolean getRButton() {
			return getButton(ButtonType.kR);
		}
		
		public boolean getLButton() {
			return getButton(ButtonType.kL);
		}
		public JoystickButton getRButtonRef() {
			//return getButton(ButtonType.kY);
			return new JoystickButton(this, ButtonType.kR_val);
		}
		
		public JoystickButton getLButtonRef() {
			//return getButton(ButtonType.kY);
			return new JoystickButton(this, ButtonType.kL_val);
		}

		public JoystickButton getBButtonRef() {
			//return getButton(ButtonType.kB);
			return new JoystickButton(this, ButtonType.kB_val);
		}
		
		public JoystickButton getAButtonRef() {
			//return getButton(ButtonType.kA);
			return new JoystickButton(this, ButtonType.kA_val);
		}

		public JoystickButton getXButtonRef() {
			//return getButton(ButtonType.kX);
			return new JoystickButton(this, ButtonType.kX_val);
		}

		public double getTwist() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getPOV(int pov) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getPOVCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public HIDType getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setOutput(int outputNumber, boolean value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setOutputs(int value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setRumble(RumbleType type, double value) {
			// TODO Auto-generated method stub
			
		}
}
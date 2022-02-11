package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private TalonSRX outRightElevator;
  private TalonSRX outLeftElevator;

  private TalonSRX inRightElevator;
  private TalonSRX inLeftElevator;

  // private boolean switchAngleExtend = false;
  // private boolean switchAngleRetrack = false;
  // private boolean switchVerticalExtend = false;
  // private boolean switchVerticalRetrack = false;

  DigitalInput switchAngleExtend = new DigitalInput(1);
  DigitalInput switchAngleRetrack = new DigitalInput(2);
  DigitalInput switchVerticalExtend = new DigitalInput(3);
  DigitalInput switchVerticalRetrack = new DigitalInput(4);

  public ElevatorSubsystem() {

    outRightElevator = new TalonSRX(6);
    outLeftElevator = new TalonSRX(7);

    inRightElevator = new TalonSRX(8);
    inLeftElevator = new TalonSRX(9);

    outRightElevator.setInverted(false);
    outLeftElevator.setInverted(false);

    inRightElevator.setInverted(false);
    inLeftElevator.setInverted(false);
  }

  public void startAngleElevator(double speed) {

    if (switchAngleExtend.get()) {
      inRightElevator.set(ControlMode.PercentOutput, 0.0);

    } else {
      outRightElevator.set(ControlMode.PercentOutput, speed);
      outLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void startVerticalElevator(double speed) {

    if (switchVerticalExtend.get()) {
      inRightElevator.set(ControlMode.PercentOutput, 0.0);

    } else {
      inRightElevator.set(ControlMode.PercentOutput, speed);
      inLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }


  public void retrackAngleElevator(double speed) {

    if (switchAngleRetrack.get()) {
      inRightElevator.set(ControlMode.PercentOutput, 0.0);

    } else {
      outRightElevator.set(ControlMode.PercentOutput, speed);
      outLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void retrackVerticalElevator(double speed) {

    if (switchVerticalRetrack.get()) {
      inRightElevator.set(ControlMode.PercentOutput, 0.0);

    } else {
      inRightElevator.set(ControlMode.PercentOutput, speed);
      inLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  @Override
  public void periodic() {

  }
}
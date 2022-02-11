package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private TalonSRX outRightElevator;
  private TalonSRX outLeftElevator;

  private TalonSRX inRightElevator;
  private TalonSRX inLeftElevator;

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
    outRightElevator.set(ControlMode.PercentOutput, speed);
    outLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  public void startVerticalElevator(double speed){
    inRightElevator.set(ControlMode.PercentOutput, speed);
    inLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  public void retrackAngleElevator(double speed) {
    outRightElevator.set(ControlMode.PercentOutput, speed);
    outLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  public void retrackVerticalElevator(double speed){
    inRightElevator.set(ControlMode.PercentOutput, speed);
    inLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {

  }
}
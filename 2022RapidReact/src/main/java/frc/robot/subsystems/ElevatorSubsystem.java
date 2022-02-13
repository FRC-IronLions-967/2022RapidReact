package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
// import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  public TalonSRX outRightElevator;
  private TalonSRX outLeftElevator;
  private TalonSRX inRightElevator;
  private TalonSRX inLeftElevator;

  private SensorCollection outRightCollection;
  private SensorCollection outLeftCollection;
  private SensorCollection inRightCollection;
  private SensorCollection inLeftCollection;

  public ElevatorSubsystem() {

    outRightElevator = new TalonSRX(6);
    outRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outRightCollection = new SensorCollection(outRightElevator);

    outLeftElevator = new TalonSRX(7);
    outLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outLeftCollection = new SensorCollection(outLeftElevator);

    inRightElevator = new TalonSRX(8);
    inRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inRightCollection = new SensorCollection(inRightElevator);

    inLeftElevator = new TalonSRX(9);
    inLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inLeftCollection = new SensorCollection(inLeftElevator);

    outRightElevator.setInverted(false);
    outLeftElevator.setInverted(false);

    inRightElevator.setInverted(false);
    inLeftElevator.setInverted(false);

  }

  public void startRightAngleElevator(double speed) {

    if (outRightCollection.isFwdLimitSwitchClosed()) {
      outRightElevator.setNeutralMode(NeutralMode.Brake);
      outRightElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      outRightElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void startLeftAngleElevator(double speed) {

    if (outLeftCollection.isFwdLimitSwitchClosed()) {
      outLeftElevator.setNeutralMode(NeutralMode.Brake);
      outLeftElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      outLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void startRightVerticalElevator(double speed) {

    if (inRightCollection.isFwdLimitSwitchClosed()) {
      inRightElevator.setNeutralMode(NeutralMode.Brake);
      inRightElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      inRightElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void startLeftVerticalElevator(double speed) {

    if (inLeftCollection.isFwdLimitSwitchClosed()) {
      inLeftElevator.setNeutralMode(NeutralMode.Brake);
      inLeftElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      inLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void retrackRightAngleElevator(double speed) {

    if (outRightCollection.isRevLimitSwitchClosed()) {
      outRightElevator.setNeutralMode(NeutralMode.Brake);
      outRightElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      outRightElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void retrackLeftAngleElevator(double speed) {

    if (outLeftCollection.isRevLimitSwitchClosed()) {
      outLeftElevator.setNeutralMode(NeutralMode.Brake);
      outLeftElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      outLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void retrackVerticalElevator(double speed) {
    inRightElevator.set(ControlMode.PercentOutput, speed);
    inLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("F ANGLE RIGHT", outRightCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R ANGLE RIGHT", outRightCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F ANGLE LEFT", outLeftCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R ANGLE LEFT", outLeftCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F VERT RIGHT", inRightCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R VERT RIGHT",
    // inRightCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F VERT LEFT", inLeftCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R VERT LEFT",
    // inLeftCollection.isRevLimitSwitchClosed());
  }
}
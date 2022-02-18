package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
// import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  public TalonSRX outRightElevator;
  private TalonSRX outLeftElevator;
  private TalonSRX inRightElevator;
  private TalonSRX inLeftElevator;
  private IO ioInst;
  private double deadband = 0.1;

  // private SensorCollection outRightCollection;
  // private SensorCollection outLeftCollection;
  // private SensorCollection inRightCollection;
  // private SensorCollection inLeftCollection;

  public ElevatorSubsystem() {

    outRightElevator = new TalonSRX(6);
    // outRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    // LimitSwitchNormal.Disabled);
    // outRightCollection = new SensorCollection(outRightElevator);

    outLeftElevator = new TalonSRX(7);
    // outLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    // LimitSwitchNormal.Disabled);
    // outLeftCollection = new SensorCollection(outLeftElevator);

    inRightElevator = new TalonSRX(8);
    // inRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    // LimitSwitchNormal.Disabled);
    // inRightCollection = new SensorCollection(inRightElevator);

    inLeftElevator = new TalonSRX(9);
    // inLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
    // LimitSwitchNormal.Disabled);
    // inLeftCollection = new SensorCollection(inLeftElevator);

    outRightElevator.setInverted(false);
    outLeftElevator.setInverted(false);

    inRightElevator.setInverted(false);
    inLeftElevator.setInverted(false);

    ioInst = IO.getInstance();
  }

  public void rewindAngleElevator(double speed) {
    outRightElevator.set(ControlMode.PercentOutput, speed);
    outLeftElevator.set(ControlMode.PercentOutput, speed);
  }

  public void startRightAngleElevator(double speed) {

    // if (outRightCollection.isFwdLimitSwitchClosed()) {
    // outRightElevator.setNeutralMode(NeutralMode.Brake);
    // outRightElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    outRightElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void startLeftAngleElevator(double speed) {

    // if (outLeftCollection.isFwdLimitSwitchClosed()) {
    // outLeftElevator.setNeutralMode(NeutralMode.Brake);
    // outLeftElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    outLeftElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void startRightVerticalElevator(double speed) {

    // if (inRightCollection.isFwdLimitSwitchClosed()) {
    // inRightElevator.setNeutralMode(NeutralMode.Brake);
    // inRightElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    inRightElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void startLeftVerticalElevator(double speed) {

    // if (inLeftCollection.isFwdLimitSwitchClosed()) {
    // inLeftElevator.setNeutralMode(NeutralMode.Brake);
    // inLeftElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    inLeftElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void retrackRightAngleElevator(double speed) {

    // if (outRightCollection.isRevLimitSwitchClosed()) {
    // outRightElevator.setNeutralMode(NeutralMode.Brake);
    // outRightElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    outRightElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void retrackLeftAngleElevator(double speed) {

    // if (outLeftCollection.isRevLimitSwitchClosed()) {
    // outLeftElevator.setNeutralMode(NeutralMode.Brake);
    // outLeftElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    outLeftElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void retrackLeftVerticalElevator(double speed) {
    // if (inLeftCollection.isRevLimitSwitchClosed()) {
    // inLeftElevator.setNeutralMode(NeutralMode.Brake);
    // inLeftElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    inLeftElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void retrackRightVerticalElevator(double speed) {
    // if (inRightCollection.isRevLimitSwitchClosed()) {
    // inRightElevator.setNeutralMode(NeutralMode.Brake);
    // inRightElevator.set(ControlMode.PercentOutput, 0.0);
    // } else {
    inRightElevator.set(ControlMode.PercentOutput, speed);
    // }
  }

  public void elevatorWorking(double x, double y) {
    // System.out.println("ACIVATEDDDDD!!!!");

    if (x > deadband) {
      // System.out.println("VERTICCAL OUT");
      startRightVerticalElevator(0.5);
      startLeftVerticalElevator(0.5);

    } else if (x < -(deadband)) {
      // System.out.println("VERTICAL IN");
      retrackRightVerticalElevator(-0.5);
      retrackLeftVerticalElevator(-0.5);

    }

    if (y > deadband) {
      // System.out.println("ANGLE OUT");
      startRightAngleElevator(0.5);
      startLeftAngleElevator(0.5);

    } else if (y < -(deadband)) {
      // System.out.println("ANGLE IN");
      retrackRightAngleElevator(0.3);
      retrackLeftAngleElevator(0.3);
    }

  }

  @Override
  public void periodic() {

    if (ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER)
        && ioInst.getManipulatorController().isTriggerPressed(XBoxController.RIGHT_TRIGGER)) {
      elevatorWorking(-ioInst.getManipulatorController().getRightStickY(),
          -ioInst.getManipulatorController().getLeftStickY());
    }

    if (ioInst.getDriverController().isTriggerPressed(XBoxController.LEFT_TRIGGER)
        && ioInst.getDriverController().isTriggerPressed(XBoxController.RIGHT_TRIGGER)) {
      rewindAngleElevator(0.3);
    } else {
      rewindAngleElevator(0.0);
    }

    // SmartDashboard.putBoolean("F ANGLE RIGHT",
    // outRightCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R ANGLE RIGHT",
    // outRightCollection.isRevLimitSwitchClosed());

    // SmartDashboard.putBoolean("F ANGLE LEFT",
    // outLeftCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R ANGLE LEFT",
    // outLeftCollection.isRevLimitSwitchClosed());

    // SmartDashboard.putBoolean("F VERT RIGHT",
    // inRightCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R VERT
    // RIGHT",inRightCollection.isRevLimitSwitchClosed());

    // SmartDashboard.putBoolean("F VERT LEFT",
    // inLeftCollection.isFwdLimitSwitchClosed());
    // SmartDashboard.putBoolean("R VERT
    // LEFT",inLeftCollection.isRevLimitSwitchClosed());
  }
}
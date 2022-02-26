package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;
import frc.robot.utils.statemachine.ElevatorStateMachine;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  private TalonSRX outRightElevator;
  private TalonSRX outLeftElevator;
  private TalonSRX inRightElevator;
  private TalonSRX inLeftElevator;
  private IO ioInst;
  private double deadband = 0.1;

  private SensorCollection outRightCollection;
  private SensorCollection outLeftCollection;
  private SensorCollection inRightCollection;
  private SensorCollection inLeftCollection;

  private ElevatorStateMachine outRightStateMachine;
  private ElevatorStateMachine inRightStateMachine;
  private ElevatorStateMachine outLeftStateMachine;
  private ElevatorStateMachine inLeftStateMachine;

  public ElevatorSubsystem() {

    outRightElevator = new TalonSRX(6);
    outRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outRightElevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outRightCollection = new SensorCollection(outRightElevator);

    outLeftElevator = new TalonSRX(7);
    outLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outLeftElevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    outLeftCollection = new SensorCollection(outLeftElevator);

    inRightElevator = new TalonSRX(8);
    inRightElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inRightElevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inRightCollection = new SensorCollection(inRightElevator);

    inLeftElevator = new TalonSRX(9);
    inLeftElevator.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inLeftElevator.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    inLeftCollection = new SensorCollection(inLeftElevator);

    outRightElevator.setInverted(false);
    outLeftElevator.setInverted(false);

    inRightElevator.setInverted(false);
    inLeftElevator.setInverted(false);

    ioInst = IO.getInstance();

    outRightStateMachine = new ElevatorStateMachine(0.3);
    inRightStateMachine = new ElevatorStateMachine(0.3);
    outLeftStateMachine = new ElevatorStateMachine(0.3);
    inLeftStateMachine = new ElevatorStateMachine(0.3);

  }

  public void rewindAngleElevator(double speed, boolean on) {
    if (on) {
      // if (ioInst.getDriverController().isTriggerPressed(XBoxController.LEFT_TRIGGER)
      //     && ioInst.getDriverController().isTriggerPressed(XBoxController.RIGHT_TRIGGER)) {
      //   // outRightElevator.set(ControlMode.PercentOutput, speed);
      //   // outLeftElevator.set(ControlMode.PercentOutput, speed);
      //    elevatorWorking(-ioInst.getManipulatorController().getRightStickY(), -ioInst.getManipulatorController().getLeftStickY());
      //   // System.out.println("It works and activated");
      // } else {
      //   outRightElevator.set(ControlMode.PercentOutput, 0.0);
      //   outLeftElevator.set(ControlMode.PercentOutput, 0.0);
      //   System.out.println("its works but disabled");
      // }
    }
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

  public void retrackLeftVerticalElevator(double speed) {
    if (inLeftCollection.isRevLimitSwitchClosed()) {
      inLeftElevator.setNeutralMode(NeutralMode.Brake);
      inLeftElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      inLeftElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void retrackRightVerticalElevator(double speed) {
    if (inRightCollection.isRevLimitSwitchClosed()) {
      inRightElevator.setNeutralMode(NeutralMode.Brake);
      inRightElevator.set(ControlMode.PercentOutput, 0.0);
    } else {
      inRightElevator.set(ControlMode.PercentOutput, speed);
    }
  }

  public void elevatorWorking(double x, double y) {
    // System.out.println("ACIVATEDDDDD!!!!");

    if (x > deadband) {
      // System.out.println("VERTICCAL OUT");
      startRightVerticalElevator(0.5);
      startLeftVerticalElevator(0.5);

    } else if (x <-(deadband)) {
      // System.out.println("VERTICAL IN");
      retrackRightVerticalElevator(-0.5);
      retrackLeftVerticalElevator(-0.5);

    } else {
      startRightVerticalElevator(0.0);
      retrackRightVerticalElevator(0.0);
    }

    if (y > deadband) {
      System.out.println("ANGLE OUT");
      startRightAngleElevator(0.5);
      startLeftAngleElevator(0.5);

    } else if (y < -(deadband)) {
      System.out.println("ANGLE IN");
      retrackRightAngleElevator(0.3);
      retrackLeftAngleElevator(0.3);
    }

  }

  @Override
  public void periodic() {

    if (ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER) && ioInst.getManipulatorController().isTriggerPressed(XBoxController.RIGHT_TRIGGER)) {
      // elevatorWorking(-ioInst.getManipulatorController().getRightStickY(), -ioInst.getManipulatorController().getLeftStickY());
      
      boolean[] verticalRightInputs = new boolean[4];
      verticalRightInputs[0] = -ioInst.getManipulatorController().getRightStickY() > deadband;
      verticalRightInputs[1] = -ioInst.getManipulatorController().getRightStickY() < -deadband;
      verticalRightInputs[2] = inRightCollection.isFwdLimitSwitchClosed();
      verticalRightInputs[3] = inRightCollection.isRevLimitSwitchClosed();

      boolean[] verticalLeftInputs = new boolean[4];
      verticalLeftInputs[0] = -ioInst.getManipulatorController().getRightStickY() > deadband;
      verticalLeftInputs[1] = -ioInst.getManipulatorController().getRightStickY() < -deadband;
      verticalLeftInputs[2] = inLeftCollection.isFwdLimitSwitchClosed();
      verticalLeftInputs[3] = inLeftCollection.isRevLimitSwitchClosed();

      boolean[] angleRightInputs = new boolean[4];
      angleRightInputs[0] = -ioInst.getManipulatorController().getLeftStickY() > deadband;
      angleRightInputs[1] = -ioInst.getManipulatorController().getLeftStickY() < -deadband;
      angleRightInputs[2] = outRightCollection.isFwdLimitSwitchClosed();
      angleRightInputs[3] = outRightCollection.isRevLimitSwitchClosed();

      boolean[] angleLeftInputs = new boolean[4];
      angleLeftInputs[0] = -ioInst.getManipulatorController().getLeftStickY() > deadband;
      angleLeftInputs[1] = -ioInst.getManipulatorController().getLeftStickY() < -deadband;
      angleLeftInputs[2] = outLeftCollection.isFwdLimitSwitchClosed();
      angleLeftInputs[3] = outLeftCollection.isRevLimitSwitchClosed();

      outRightStateMachine.updateState(angleRightInputs);
      inRightStateMachine.updateState(verticalRightInputs);
      outLeftStateMachine.updateState(angleLeftInputs);
      inLeftStateMachine.updateState(verticalLeftInputs);

      outRightElevator.set(ControlMode.PercentOutput, outRightStateMachine.getMotorPower());
      inRightElevator.set(ControlMode.PercentOutput, inRightStateMachine.getMotorPower());
      outLeftElevator.set(ControlMode.PercentOutput, outLeftStateMachine.getMotorPower());
      inLeftElevator.set(ControlMode.PercentOutput, inLeftStateMachine.getMotorPower());
      

    } else{
      outRightElevator.set(ControlMode.PercentOutput, 0.0);
      inRightElevator.set(ControlMode.PercentOutput, 0.0);
      outLeftElevator.set(ControlMode.PercentOutput, 0.0);
      inLeftElevator.set(ControlMode.PercentOutput, 0.0);
    }

    SmartDashboard.putString("OUT RIGHT STATE", outRightStateMachine.toString());
    SmartDashboard.putString("OUT LEFT STATE", outLeftStateMachine.toString());
    
    
    SmartDashboard.putString("IN RIGHT STATE", inRightStateMachine.toString());
    SmartDashboard.putString("IN LEFT STATE", inLeftStateMachine.toString());

    SmartDashboard.putBoolean("F ANGLE RIGHT", outRightCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R ANGLE RIGHT", outRightCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F ANGLE LEFT", outLeftCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R ANGLE LEFT", outLeftCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F VERT RIGHT", inRightCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R VERT RIGHT", inRightCollection.isRevLimitSwitchClosed());

    SmartDashboard.putBoolean("F VERT LEFT", inLeftCollection.isFwdLimitSwitchClosed());
    SmartDashboard.putBoolean("R VERT LEFT", inLeftCollection.isRevLimitSwitchClosed());
  }
}
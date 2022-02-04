package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;

public class IntakeSubsystem extends SubsystemBase {

  private IO ioInst;
  private TalonSRX intake;

  public IntakeSubsystem() {
    ioInst = IO.getInstance();
    intake = new TalonSRX(6);

    intake.setInverted(false);
  }

  public void startIntake() {

  }

  @Override
  public void periodic() {
    
    try{
      if (ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER)) {
        intake.set(ControlMode.PercentOutput, 0.3);
      } else {
        intake.set(ControlMode.PercentOutput, 0.0);
      }
    }catch(Exception e){
      DriverStation.reportError(e.getMessage(), e.getStackTrace());
    }
    
    
  }
}
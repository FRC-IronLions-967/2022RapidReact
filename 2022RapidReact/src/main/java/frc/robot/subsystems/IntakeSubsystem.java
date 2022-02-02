package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;

public class IntakeSubsystem extends SubsystemBase {
    
    
    private IO ioInst;
    private VictorSPX intake;

    public IntakeSubsystem() {

        intake = new VictorSPX(6);

        intake.setInverted(false);
    }

    public void startIntake() {

    }

  @Override
  public void periodic() {
    if(ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER)) {
      intake.set(ControlMode.PercentOutput, 0.1);
    } else {
      intake.set(ControlMode.PercentOutput, 0.0);
    }
}
}
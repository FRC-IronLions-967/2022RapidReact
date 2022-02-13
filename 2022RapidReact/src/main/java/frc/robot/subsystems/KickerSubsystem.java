package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;

public class KickerSubsystem extends SubsystemBase {

    private VictorSPX kicker;
    private IO ioInst;

    public KickerSubsystem() {
        kicker = new VictorSPX(11);

        kicker.setInverted(false);

        ioInst = IO.getInstance();
    }



    @Override
    public void periodic() {
        if(ioInst.getManipulatorController().isTriggerPressed(XBoxController.RIGHT_TRIGGER)) {
            kicker.set(ControlMode.PercentOutput, 0.5);
          } else {
            kicker.set(ControlMode.PercentOutput, 0.0);
          }
    }

}

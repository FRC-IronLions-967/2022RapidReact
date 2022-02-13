package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.IO;
import frc.robot.utils.controls.XBoxController;

public class RollerSubsystem extends SubsystemBase {

    private CANSparkMax roller;
    private IO ioInst;

    public RollerSubsystem() {
        roller = new CANSparkMax(10, MotorType.kBrushless);

        roller.setInverted(false);

        ioInst = IO.getInstance();
    }



    @Override
    public void periodic() {
        if(ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER)) {
            roller.set(0.5);
          } else {
            roller.set(0.0);
          }
    }

}

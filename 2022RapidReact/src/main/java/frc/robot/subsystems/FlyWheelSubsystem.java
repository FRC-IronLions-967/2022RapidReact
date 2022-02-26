package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.utils.replayauto.*;

public class FlyWheelSubsystem extends SubsystemBase {

    private CANSparkMax flyWheel;
    private boolean flyWheelON;
    private RecorderInstance recordInst;

    public FlyWheelSubsystem() {
        flyWheel = new CANSparkMax(5, MotorType.kBrushless);
        recordInst = RecorderInstance.getInstance();

        flyWheel.setInverted(true);
    }



    public void runFlyWheel(boolean flyWheelON){
        this.flyWheelON = flyWheelON;
    }

    @Override
    public void periodic() {
        if (flyWheelON){
            flyWheel.set(0.85);
        } else {
            flyWheel.set(0.0);
        }

        recordInst.recorder.updateField("flywheelon", flyWheelON);

        SmartDashboard.putNumber("Right Current", flyWheel.getOutputCurrent());
        SmartDashboard.putNumber("Right RPM", flyWheel.getEncoder().getVelocity());
    }

}

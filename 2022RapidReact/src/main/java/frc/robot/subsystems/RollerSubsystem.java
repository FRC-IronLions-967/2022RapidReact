package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.utils.replayauto.*;

public class RollerSubsystem extends SubsystemBase {

    private VictorSPX roller;
    private VictorSPX armWinch;
    private RecorderInstance recordInst;

    private double rollerSpeed = 0.0;
    private double armSpeed = 0.0;

    public RollerSubsystem() {
        roller = new VictorSPX(10);
        armWinch = new VictorSPX(12);

        roller.setInverted(false);
        armWinch.setInverted(false);

        recordInst = RecorderInstance.getInstance();
    }

    public void runRoller(double speed) {
        roller.set(VictorSPXControlMode.PercentOutput, speed);
        rollerSpeed = speed;
    }

    public void runArmWinch(double speed){
        armWinch.set(VictorSPXControlMode.PercentOutput, speed);
        armSpeed = speed;
    }




    @Override
    public void periodic() {
        recordInst.recorder.updateField("rollerpower", Double.valueOf(rollerSpeed));
        recordInst.recorder.updateField("armpower", Double.valueOf(armSpeed));
    }

}

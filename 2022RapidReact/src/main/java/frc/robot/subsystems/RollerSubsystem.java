package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {

    private CANSparkMax roller;
    private VictorSPX armWinch;

    public RollerSubsystem() {
        roller = new CANSparkMax(10, MotorType.kBrushless);
        armWinch = new VictorSPX(12);

        roller.setInverted(false);
        armWinch.setInverted(false);
    }

    public void runRollerFwd(double speed) {
        roller.set(speed);
    }

    public void runRollerRev(double speed) {
        roller.set(speed);
    }

    public void engageArmWinch(){
        armWinch.set(VictorSPXControlMode.PercentOutput, 1.0);
    }

    public void retrackArmWinch(){
        armWinch.set(VictorSPXControlMode.PercentOutput, -1.0);
    }


    @Override
    public void periodic() {

    }

}

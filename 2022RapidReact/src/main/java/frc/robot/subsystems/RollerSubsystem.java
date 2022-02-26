package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {

    private VictorSPX roller;
    private VictorSPX armWinch;

    public RollerSubsystem() {
        roller = new VictorSPX(10);
        armWinch = new VictorSPX(12);

        roller.setInverted(false);
        armWinch.setInverted(false);
    }

    public void runRoller(double speed) {
        roller.set(VictorSPXControlMode.PercentOutput, speed);
    }

    public void runArmWinch(double speed){
        armWinch.set(VictorSPXControlMode.PercentOutput, speed);
    }




    @Override
    public void periodic() {

    }

}

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class RollerSubsystem extends SubsystemBase {

    private CANSparkMax roller;


    public RollerSubsystem() {
        roller = new CANSparkMax(10, MotorType.kBrushless);

        roller.setInverted(false);
    }

    public void runRollerFwd(double speed){
        roller.set(speed);
    }

    public void runRollerRev(double speed){
        roller.set(speed);
    }

    @Override
    public void periodic() {

    }

}

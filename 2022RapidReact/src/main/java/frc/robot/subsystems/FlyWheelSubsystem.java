package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class FlyWheelSubsystem extends SubsystemBase {

    private CANSparkMax flyWheel;
    private boolean flyWheelON = false;


    public FlyWheelSubsystem() {
        flyWheel = new CANSparkMax(5, MotorType.kBrushless);

        flyWheel.setInverted(false);
    }

    public void activateFlyWheel(){
        flyWheelON = true;
        runFlyWheel();
    }

    public void deactivateFlyWheel(){
        flyWheelON = false;
        runFlyWheel();
    }

    public void runFlyWheel(){
        if (flyWheelON){
            flyWheel.set(1.0);
        } else {
            flyWheel.set(0.0);
        }
    }

    @Override
    public void periodic() {
    }

}

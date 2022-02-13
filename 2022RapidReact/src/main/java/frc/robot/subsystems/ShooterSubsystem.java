package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private CANSparkMax flywheel;
    private double flySpeed = 0.5;

    public ShooterSubsystem() {
        flywheel = new CANSparkMax(5, MotorType.kBrushless);

        flywheel.setInverted(false);
    }

    public void increaseFlywheelRPM(double speed) {
        if (flySpeed >= 1) {
            flySpeed = 1;
        } else {
            flySpeed += speed;
        }
    }

    public void decreaseFlywheelRPM(double speed) {
        if (flySpeed <= 0.1) {
            flySpeed = 0.1;
        } else {
            flySpeed -= speed;
        }
    }

    public void activateFlywheel(int controlSwitch) {
        if (controlSwitch > 0) {
            flywheel.set(flySpeed);
        } else {
            flywheel.set(0.0);
        }
    }

    @Override
    public void periodic() {
        
    }

}

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class FlyWheelSubsystem extends SubsystemBase {

    private CANSparkMax flyWheel;
    private boolean flyWheelON;
    private double flyWheelRPM = 0.3;


    public FlyWheelSubsystem() {
        flyWheel = new CANSparkMax(5, MotorType.kBrushless);

        flyWheel.setInverted(true);
    }

    public void changeTheRPM(double changeRPM){
        flyWheelRPM += changeRPM;
    }

    public void runFlyWheel(boolean flyWheelON){
        this.flyWheelON = flyWheelON;
    }

    @Override
    public void periodic() {
        if (flyWheelON){
            flyWheel.set(flyWheelRPM);
        } else {
            flyWheel.set(0.0);
        }
        SmartDashboard.putNumber("Right Current", flyWheel.getOutputCurrent());
        SmartDashboard.putNumber("Right RPM", flyWheel.getEncoder().getVelocity());
    }

}

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private double changeRPM = 0.0;
    private double mainRPM = 0.0;
    private VictorSPX kicker;

    public ShooterSubsystem() {
        kicker = new VictorSPX(11);

        kicker.setInverted(false);
    }

    public void increaseKickerRPM(double increaseRPM) {
        changeRPM += increaseRPM;
    }

    public void decreaseKickerRPM(double decreaseRPM) {
        changeRPM -= decreaseRPM;
    }

    public void runKickerFwd(double speed) {
        mainRPM = speed;
        mainRPM += changeRPM;
        if (mainRPM > 1.0) {
            mainRPM = 1.0;
        } else if (mainRPM < 0.1) {
            mainRPM = 0.1;
        }

        kicker.set(VictorSPXControlMode.PercentOutput, mainRPM);
    }

    public void runKickerRev(double speed) {
        kicker.set(VictorSPXControlMode.PercentOutput, speed);
    }

    @Override
    public void periodic() {
    }
}

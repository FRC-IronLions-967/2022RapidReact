package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private VictorSPX kicker;

    public ShooterSubsystem() {
        kicker = new VictorSPX(11);
        kicker.setInverted(false);
    }

    
    public void runKicker(double speed) {
        kicker.set(VictorSPXControlMode.PercentOutput, speed);
    }

    @Override
    public void periodic() {
        
    }
}

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.utils.replayauto.*;

public class ShooterSubsystem extends SubsystemBase {

    private VictorSPX kicker;
    private RecorderInstance recordInst;

    public ShooterSubsystem() {
        kicker = new VictorSPX(11);
        kicker.setInverted(false);

        recordInst = RecorderInstance.getInstance();
    }

    
    public void runKicker(double speed) {
        kicker.set(VictorSPXControlMode.PercentOutput, speed);
        recordInst.recorder.updateField("kickerpower", speed);
    }

    @Override
    public void periodic() {
        
    }
}

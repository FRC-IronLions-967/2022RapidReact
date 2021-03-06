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

    private double shooterSpeed = 0.0;

    public ShooterSubsystem() {
        kicker = new VictorSPX(11);
        kicker.setInverted(false);

        recordInst = RecorderInstance.getInstance();
    }

    
    public void runKicker(double speed) {
        kicker.set(VictorSPXControlMode.PercentOutput, speed);
        shooterSpeed = speed;
    }

    @Override
    public void periodic() {
        recordInst.recorder.updateField("kickerpower", Double.valueOf(shooterSpeed));
    }
}

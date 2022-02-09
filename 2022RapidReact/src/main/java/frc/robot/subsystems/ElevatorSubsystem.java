package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.IO;

public class ElevatorSubsystem extends SubsystemBase {

//   private IO ioInst;
  private TalonSRX elevator;


public ElevatorSubsystem() {
    // ioInst = IO.getInstance();
    elevator = new TalonSRX(6);

    elevator.setInverted(false);
  }


  public void startElevator(double speed) {
    elevator.set(ControlMode.PercentOutput, speed);
  }
  


  @Override
  public void periodic() {

    

}
}
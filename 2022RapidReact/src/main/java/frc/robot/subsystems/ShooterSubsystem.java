package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterSubsystem {





  private CANSparkMax shooter;




  public ShooterSubsystem() {

    shooter = new CANSparkMax(5, MotorType.kBrushless);

    shooter.setInverted(false);
  }


  public void startShooter(){

    System.out.println("IT WORKED");

  }
}
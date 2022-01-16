// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Utils;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax rightMaster;
  private CANSparkMax rightSlave;
  private CANSparkMax leftMaster;
  private CANSparkMax leftSlave;

  private double v = 0.0;
  private File recordFile;
  private PrintWriter writer;
  private long startTime;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    rightMaster = new CANSparkMax(1, MotorType.kBrushless);
    rightSlave = new CANSparkMax(2, MotorType.kBrushless);
    leftMaster = new CANSparkMax(3, MotorType.kBrushless);
    leftSlave = new CANSparkMax(4, MotorType.kBrushless);

    // set slaves to follow master motor controllers
    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);
    rightMaster.setInverted(true);
    rightSlave.setInverted(true);
    leftMaster.setInverted(false);
    leftSlave.setInverted(false);

    startTime = System.currentTimeMillis();

    Calendar calendar = Calendar.getInstance();
    String path = String.format("/home/lvuser/recordings/recording_%d_%d_%d:%d:%d.csv", calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    recordFile = new File(path);
    try {
    writer = new PrintWriter(new FileWriter(recordFile), true);
    writer.println("Timestamp,rightpower,leftpower");
    } catch (IOException e) {
      DriverStation.reportError(e.getMessage(), e.getStackTrace());


    }



  }

  private final double MAX = 1.0;

  public void move(double r, double l) {

    // System.out.println("r: " + r);
    // System.out.println("l: " + l);

    // defensive code to prevent the values being passed to move from exceeding the
    // accepted ranges on the motor controllers
    r = (r > MAX) ? MAX : r;
    r = (r < -(MAX)) ? -(MAX) : r;
    l = (l > MAX) ? MAX : l;
    l = (l < -(MAX)) ? -(MAX) : l;

    // set motor powers, slaves do not need to be called as they were set to follow
    // the master in the class constructor
    rightMaster.set(r);
    leftMaster.set(l);

    writer.println(String.format("%d,%f,%f", System.currentTimeMillis() - startTime, r, l));


  }

  public void arcadeDrive(double x, double y) {

    x = Utils.deadband(x, 0.05);
    y = Utils.deadband(y, 0.05);

    // difference between current velocity and commanded velocity in the y direction
    double difV = y - v;
    SmartDashboard.putNumber("difV", difV);
    double maxDifV = SmartDashboard.getNumber("maxAccel", 0.03d);

    if (difV > 0) {
      v += (difV > maxDifV) ? maxDifV : difV;
    } else {
      v -= (Math.abs(difV) > maxDifV) ? maxDifV : Math.abs(difV);
    }

    double s = (Math.abs(v) < 0.05)
        ? SmartDashboard.getNumber("scale", 0.5d) * x * SmartDashboard.getNumber("zeroTurn", 0.3d)
        : SmartDashboard.getNumber("scale", 0.5d) * x * Math.abs(v);

    double l = v - s;
    double r = v + s;

    move(r, l);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}

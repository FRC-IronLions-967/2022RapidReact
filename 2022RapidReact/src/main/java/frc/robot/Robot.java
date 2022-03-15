// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.autonomous.*;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.utils.replayauto.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private static final String k2ballAuto = "2 ball";
  private static final String k3ballAuto = "3 ball";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private SubsystemsInstance subsystemsInst;
  // private ReplayAuto replayAuto;
  private ShootReplayAuto auto;
  private RecorderInstance recordInst;
  private final Timer m_timer = new Timer();

  // FlyWheelSubsystem flyAuto = new FlyWheelSubsystem();

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    m_chooser.addOption("2 ball auto", k2ballAuto);
    m_chooser.addOption("3 ball auto", k3ballAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    SmartDashboard.putNumber("maxAccel", 0.02d);
    SmartDashboard.putNumber("scale", 0.5d);
    SmartDashboard.putNumber("zeroTurn", 0.5d);

    subsystemsInst = SubsystemsInstance.getInstance();
    recordInst = RecorderInstance.getInstance();

    auto = new ShootReplayAuto("/home/lvuser/recordings/testauto.csv");
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    // recordInst.recorder.recordLine();
    // remove this line if you arent recording
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    // m_autoSelected = m_chooser.getSelected();
    // // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);
    // auto.init();
    m_timer.reset();
    m_timer.start();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if(m_chooser.getSelected() == k3ballAuto){
      System.out.println("3 ball ACTIVATE");
      threeBall();
    } else if(m_chooser.getSelected() == k2ballAuto){
      System.out.println("2 ball ACTIVATE");
      twoBall();
    }
  }

  public void twoBall() {

    // auto.periodic();
    // Anything with else if comment out for a 2 ball auto
    if (m_timer.get() < 2) {
        subsystemsInst.m_flyWheelSubsystem.changeTheRPM(.62);
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(true);
      } else if (m_timer.get() > 2 && m_timer.get() < 14) {
        subsystemsInst.m_flyWheelSubsystem.changeTheRPM(.75);
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(true);
      } else {
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(false);
      }
      
      if(m_timer.get() > 1 && m_timer.get() < 10) {
        subsystemsInst.m_shooterSubsystem.runKicker(1.0);
      }  else{
        subsystemsInst.m_shooterSubsystem.runKicker(0.0);
      }
      if (m_timer.get() > 2 && m_timer.get() < 3.5) {
        subsystemsInst.m_driveSubsystem.move(0.2, 0.2);
      }else {
        subsystemsInst.m_driveSubsystem.move(0.0, 0.0);
      }
      // if(m_timer.get() > 5 && m_timer.get() < 6){
      // subsystemsInst.m_rollerSubsystem.runArmWinch(0.8);
      // } else{
      // subsystemsInst.m_rollerSubsystem.runArmWinch(0.0);
      // }
      if(m_timer.get() > 1 && m_timer.get() < 14){
        subsystemsInst.m_rollerSubsystem.runRoller(-1.0);
      } else{
        subsystemsInst.m_rollerSubsystem.runRoller(0.0);
      }
  
      
      subsystemsInst.m_flyWheelSubsystem.periodic();
    }

    public void threeBall(){
        
    // auto.periodic();
    // Anything with else if comment out for a 2 ball auto
    if (m_timer.get() < 2) {
        subsystemsInst.m_flyWheelSubsystem.changeTheRPM(.62);
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(true);
      } else if (m_timer.get() > 2 && m_timer.get() < 14) {
        subsystemsInst.m_flyWheelSubsystem.changeTheRPM(.75);
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(true);
      } else {
        subsystemsInst.m_flyWheelSubsystem.runFlyWheel(false);
      }
      
      if(m_timer.get() > 1 && m_timer.get() < 4) {
        subsystemsInst.m_shooterSubsystem.runKicker(1.0);
      } else if (m_timer.get() > 4 && m_timer.get() < 8) {
        subsystemsInst.m_shooterSubsystem.runKicker(1.0);
      } else if (m_timer.get() > 12 && m_timer.get() < 14) {
        subsystemsInst.m_shooterSubsystem.runKicker(1.0);
      } else{
        subsystemsInst.m_shooterSubsystem.runKicker(0.0);
      }
      if (m_timer.get() > 2 && m_timer.get() < 3.5) {
        subsystemsInst.m_driveSubsystem.move(0.2, 0.2);
      } else if(m_timer.get() > 7 && m_timer.get() < 8){
        subsystemsInst.m_driveSubsystem.move(-0.2, 0.2);
      } else if(m_timer.get() > 8.2 && m_timer.get() < 9.2){
        subsystemsInst.m_driveSubsystem.move(0.3, 0.3);
      } else if(m_timer.get() > 9.2 && m_timer.get() < 10.2){
        subsystemsInst.m_driveSubsystem.move(0.2, -0.2);
      } else {
        subsystemsInst.m_driveSubsystem.move(0.0, 0.0);
      }
      // if(m_timer.get() > 5 && m_timer.get() < 6){
      // subsystemsInst.m_rollerSubsystem.runArmWinch(0.8);
      // } else{
      // subsystemsInst.m_rollerSubsystem.runArmWinch(0.0);
      // }
      if(m_timer.get() > 3 && m_timer.get() < 14){
        subsystemsInst.m_rollerSubsystem.runRoller(-1.0);
      } else{
        subsystemsInst.m_rollerSubsystem.runRoller(0.0);
      }
  
      
      subsystemsInst.m_flyWheelSubsystem.periodic();
    }


  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    IO.getInstance().teleopInit();
    CommandScheduler.getInstance().setDefaultCommand(subsystemsInst.m_driveSubsystem, new ArcadeDriveCommand());

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}

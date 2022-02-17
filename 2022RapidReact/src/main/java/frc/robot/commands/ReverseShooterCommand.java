package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SubsystemsInstance;

public class ReverseShooterCommand extends CommandBase {

  private double speed;
  private SubsystemsInstance inst;


  public ReverseShooterCommand(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    inst = SubsystemsInstance.getInstance();
    addRequirements(inst.m_shooterSubsystem);

    this.speed = speed;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize(){}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    inst.m_shooterSubsystem.runKickerRev(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return false;
  }
}
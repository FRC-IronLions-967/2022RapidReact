package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SubsystemsInstance;

public class RunElevatorCommand extends CommandBase {

  private double speed;
  private SubsystemsInstance inst;


  public RunElevatorCommand(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    inst = SubsystemsInstance.getInstance();
    addRequirements(inst.m_elevatorSubsystem);

    this.speed = speed;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize(){
    System.out.println("Command has been initalize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Command Elevator is excuting");
    inst.m_elevatorSubsystem.startElevator(speed);
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
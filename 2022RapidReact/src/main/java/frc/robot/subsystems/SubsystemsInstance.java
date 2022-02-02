package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.values.ValuesInstance;

public class SubsystemsInstance {
    public DriveSubsystem m_driveSubsystem;

    // public ShooterSubsystem m_shooterSubsystem;
    // public IntakeSubsystem m_intakeSubsystem;
    // public KickerSubsystem m_kickerSubsystem;

    private static SubsystemsInstance inst;

    private SubsystemsInstance() {

        // attempt to initialize the ValuesInstance class
        ValuesInstance.getInstance();

        // if the initialization fails, let the user know
        if (!ValuesInstance.isInitialized())
            //throw new RuntimeException("Error loading values for subsystems");

        m_driveSubsystem = new DriveSubsystem();
        // m_shooterSubsystem = new ShooterSubsystem();
        // m_intakeSubsystem = new IntakeSubsystem();
        // m_kickerSubsystem = new KickerSubsystem();

        CommandScheduler.getInstance().registerSubsystem(m_driveSubsystem);
        // CommandScheduler.getInstance().registerSubsystem(m_shooterSubsystem);
        // CommandScheduler.getInstance().registerSubsystem(m_intakeSubsystem);
        // CommandScheduler.getInstance().registerSubsystem(m_kickerSubsystem);
    }

    public static SubsystemsInstance getInstance() {
        if(inst == null) inst = new SubsystemsInstance();

        return inst;
    }
}
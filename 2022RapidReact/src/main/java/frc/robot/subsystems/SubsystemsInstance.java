package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

// import frc.robot.values.ValuesInstance;

public class SubsystemsInstance {
    public DriveSubsystem m_driveSubsystem;

    // public ShooterSubsystem m_shooterSubsystem;
    // public ReverseElevatorSubsystem m_reverseElevatorSubsystem;
    public ElevatorSubsystem m_elevatorSubsystem;

    private static SubsystemsInstance inst;

    private SubsystemsInstance() {

        // // attempt to initialize the ValuesInstance class
        // ValuesInstance.getInstance();

        // // if the initialization fails, let the user know
        // if (!ValuesInstance.isInitialized())
        //     //throw new RuntimeException("Error loading values for subsystems");

        m_driveSubsystem = new DriveSubsystem();
        // m_shooterSubsystem = new ShooterSubsystem();
        // m_reverseElevatorSubsystem = new ReverseElevatorSubsystem();
        m_elevatorSubsystem = new ElevatorSubsystem();

        CommandScheduler.getInstance().registerSubsystem(m_driveSubsystem);
        //CommandScheduler.getInstance().registerSubsystem(m_shooterSubsystem);
        // CommandScheduler.getInstance().registerSubsystem(m_reverseElevatorSubsystem);
        CommandScheduler.getInstance().registerSubsystem(m_elevatorSubsystem);
    }

    public static SubsystemsInstance getInstance() {
        if(inst == null) inst = new SubsystemsInstance();

        return inst;
    }
}
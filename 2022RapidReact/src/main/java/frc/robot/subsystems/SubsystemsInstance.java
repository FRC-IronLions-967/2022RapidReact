package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class SubsystemsInstance {
    public DriveSubsystem m_driveSubsystem;

    public ShooterSubsystem m_shooterSubsystem;
    public ElevatorSubsystem m_elevatorSubsystem;
    public RollerSubsystem m_rollerSubsystem;
    public FlyWheelSubsystem m_flyWheelSubsystem;

    private static SubsystemsInstance inst;

    private SubsystemsInstance() {

        // // attempt to initialize the ValuesInstance class
        // ValuesInstance.getInstance();

        // // if the initialization fails, let the user know
        // if (!ValuesInstance.isInitialized())
        //     //throw new RuntimeException("Error loading values for subsystems");

        m_driveSubsystem = new DriveSubsystem();

        m_shooterSubsystem = new ShooterSubsystem();
        m_elevatorSubsystem = new ElevatorSubsystem();
        m_rollerSubsystem = new RollerSubsystem();
        m_flyWheelSubsystem = new FlyWheelSubsystem();

        CommandScheduler.getInstance().registerSubsystem(m_driveSubsystem);

        CommandScheduler.getInstance().registerSubsystem(m_shooterSubsystem);
        CommandScheduler.getInstance().registerSubsystem(m_rollerSubsystem);
        CommandScheduler.getInstance().registerSubsystem(m_elevatorSubsystem);
        CommandScheduler.getInstance().registerSubsystem(m_flyWheelSubsystem);
    }

    public static SubsystemsInstance getInstance() {
        if(inst == null) inst = new SubsystemsInstance();

        return inst;
    }
}
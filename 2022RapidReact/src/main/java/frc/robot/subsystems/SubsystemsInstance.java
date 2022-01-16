package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class SubsystemsInstance {
    public DriveSubsystem m_driveSubsystem;


    private static SubsystemsInstance inst;

    private SubsystemsInstance() {
        m_driveSubsystem = new DriveSubsystem();


        CommandScheduler.getInstance().registerSubsystem(m_driveSubsystem);
    }

    public static SubsystemsInstance getInstance() {
        if(inst == null) inst = new SubsystemsInstance();

        return inst;
    }
}
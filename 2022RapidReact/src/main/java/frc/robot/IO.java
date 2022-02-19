package frc.robot;

import frc.robot.utils.controls.XBoxController;
import frc.robot.commands.*;

public class IO {
    private static IO instance;
    private XBoxController driverController;
    private XBoxController manipulatorController;

    private IO() {
        driverController = new XBoxController(0);
        manipulatorController = new XBoxController(1);
    }

    public static IO getInstance() {
        if(instance == null) instance = new IO();

        return instance;
    }

    // this function should be run inside the Robot.teleopInit() function, and can assign commands or perform other control initialization routines
    public void teleopInit() {
  
        manipulatorController.whenButtonPressed("X", new StartShooterCommand(1.0));
        manipulatorController.whenButtonReleased("X", new StartShooterCommand(0.0));
        manipulatorController.whenButtonPressed("A", new StartRollerCommand(1.0));
        manipulatorController.whenButtonReleased("A", new StartRollerCommand(0.0));
        manipulatorController.whenButtonPressed("B", new ReverseRollerCommand(1.0));
        manipulatorController.whenButtonReleased("B", new ReverseRollerCommand(0.0));
        manipulatorController.whenButtonPressed("Y", new ReverseShooterCommand(1.0));
        manipulatorController.whenButtonReleased("Y", new ReverseShooterCommand(1.0));
        manipulatorController.whenButtonPressed("LBUMP", new DecreaseShooterCommand());
        manipulatorController.whenButtonPressed("RBUMP", new IncreaseShooterCommand());
        manipulatorController.whenButtonPressed("START", new ActivateFlyWheelCommand());
        manipulatorController.whenButtonPressed("SELECT", new DeactivateFlyWheelCommand());
        manipulatorController.whenPOVButtonPressed("N", new RetrackRollerCommand());
        manipulatorController.whenPOVButtonPressed("S", new EngageRollerCommand());
        driverController.whenButtonPressed("B", new RewindElevatorCommand(-0.3, true));
        driverController.whenButtonReleased("B", new RewindElevatorCommand(0.0, false));
        }

    public XBoxController getDriverController() {
        return driverController;
    }

    public XBoxController getManipulatorController() {
        return manipulatorController;
    }
}
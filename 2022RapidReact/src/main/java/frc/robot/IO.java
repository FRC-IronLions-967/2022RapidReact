package frc.robot;

import frc.robot.utils.controls.XBoxController;

//import frc.robot.commands.*;

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

    //this function should be run inside the Robot.teleopInit() function, and can assign commands or perform other control initialization routines
    // public void teleopInit() {
    //     //ValuesInstance valInst = ValuesInstance.getInstance();
        
    //     if(!ValuesInstance.isInitialized()) throw new RuntimeException("Error loading values for teleopInit() of IO");

    //     // manipulatorController.whenButtonPressed("A", new InitializeKickerCommand());
    //     //manipulatorController.whenButtonPressed("B", new RPMPresetCommand(valInst.m_values.getDoubleValue("defaultPresetTwo")));
    //     // manipulatorController.whenButtonPressed("X", new InitializeShooterCommand());
    //     //manipulatorController.whenButtonReleased("X", new RunFeederCommand(0.0));
    //     // manipulatorController.whenButtonPressed("Y", new InitializeIntakeCommand());
    //     //manipulatorController.whenButtonPressed("LBUMP", new RPMDownCommand());
    //     //manipulatorController.whenButtonPressed("RBUMP", new RPMUpCommand());
    //     //manipulatorController.whenButtonPressed("START", new ToggleAutoTrackingCommand());
    //     //manipulatorController.whenPOVButtonPressed("W", new ToggleIntakeCommand());
    //     //manipulatorController.whenPOVButtonPressed("N", new ChangeAngleCommand(-10.0));
    //     //manipulatorController.whenPOVButtonPressed("S", new ChangeAngleCommand(10.0));
        
    // }

    public XBoxController getDriverController() {
        return driverController;
    }

    public XBoxController getManipulatorController() {
        return manipulatorController;
    }
}
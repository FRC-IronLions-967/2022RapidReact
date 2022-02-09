// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// //import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
// //import com.ctre.phoenix.motorcontrol.can.VictorSPX;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.IO;
// import frc.robot.utils.controls.XBoxController;

// public class IntakeSubsystem extends SubsystemBase {

//   private IO ioInst;
//   private TalonSRX intake;
//   private double changePercOut = 0.3;
//   // private double limitSwitch;
 

//   public IntakeSubsystem() {
//     ioInst = IO.getInstance();
//     intake = new TalonSRX(6);

//     intake.setInverted(false);
//   }

//   public void startIntake() {

//   }

//   // public void lowerPercentOutput(double lessAmount) {
//   //   changePercOut -= lessAmount;
//   //   intake.set(ControlMode.PercentOutput, changePercOut);
//   // }

//   // public void addPercentOutput(double addAmount) {
//   //   changePercOut += addAmount;
//   //   intake.set(ControlMode.PercentOutput, changePercOut);
//   // }

//   // public void resetPercentOutput() {
//   //   changePercOut = 0.3;
//   //   intake.set(ControlMode.PercentOutput, changePercOut);
//   // }

//   @Override
//   public void periodic() {

//     try {
//       if (ioInst.getManipulatorController().isTriggerPressed(XBoxController.LEFT_TRIGGER)) {
//         intake.set(ControlMode.PercentOutput, changePercOut);
//       } else {
//         intake.set(ControlMode.PercentOutput, 0.0);
//       }
//     } catch (Exception e) {
//       DriverStation.reportError(e.getMessage(), e.getStackTrace());
//     }

//   }

//   // public void limitSwitch(){

//   //   if (limitSwitch > 0){

//   //   }
//   // }
// }

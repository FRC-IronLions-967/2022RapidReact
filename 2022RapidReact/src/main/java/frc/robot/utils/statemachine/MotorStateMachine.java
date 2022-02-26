package frc.robot.utils.statemachine;

public abstract class MotorStateMachine implements StateMachine {

    // stores the power to be outputted to the motor output of this state machine
    protected double motorPower;

    // stores the maximum power that can be used to drive the motor
    protected double maxMotorPower;

    /**
     * Constructor.
     * 
     * @param maxMotorPower the maximum allowable motor power output
     */
    public MotorStateMachine(double maxMotorPower) {
        this.maxMotorPower = maxMotorPower;
    }

    /**
     * Gets the motor power for this state in the state machine.
     * 
     * @return a double between -1.0 and 1.0 indicating the motor power
     */
    public double getMotorPower() {
        return motorPower;
    }

    /**
     * Sets the maximum motor power to a new value.
     * 
     * @param maxMotorPower a double specifying the new maximum power
     */
    public void setMaxMotorPower(double maxMotorPower) {
        this.maxMotorPower = maxMotorPower;
    }

    /**
     * Gets the maximum motor power.
     * 
     * @return the maximum motor power
     */
    public double getMaxMotorPower() {
        return maxMotorPower;
    }

}

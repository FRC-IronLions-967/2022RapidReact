package frc.robot.utils.statemachine;

public class ElevatorStateMachine extends MotorStateMachine {
    
    // stores the current state of the state machine
    private ElevatorState state;

    /**
     * Constructor.
     * 
     * @param maxMotorPower the maximum allowable motor power output
     */
    public ElevatorStateMachine(double maxMotorPower) {
        super(maxMotorPower);

        state = ElevatorState.RESET;
    }

    @Override
    /**
     * Overridden interface method from StateMachine.  Updates the current state of this object based off buttons and limit switches.
     * Expects getExpectedInputs() number of inputs.
     * 
     * @see StateMachine
     * 
     * @param inputs an array of boolean representing the inputs to the state machine
     */
    public void updateState(boolean[] inputs) {
        // TODO implement this
    }

    @Override
    /**
     * Overridden interface method from StateMachine.  Returns the number of expected inputs to the updateState() method.
     * 
     * @see StateMachine
     * 
     * @return the expected number of inputs 
     */
    public int getExpectedInputs() {
        // TODO implement this
        return 0;
    }

}

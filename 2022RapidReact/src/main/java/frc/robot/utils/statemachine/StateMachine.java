package frc.robot.utils.statemachine;

public interface StateMachine {
    
    /**
     * Causes the state machine to advance its state based off of the specified inputs.  The number of inputs should match the number
     * returned from getExpectedInputs().
     * 
     * @see getExpectedInputs()
     * 
     * @param inputs an array of booleans representing the inputs to the state machine
     */
    void updateState(boolean[] inputs);

    /**
     * Returns the number of inputs expected in each call to updateState().
     * 
     * @return an int with the expected number of inputs
     */
    int getExpectedInputs();

}

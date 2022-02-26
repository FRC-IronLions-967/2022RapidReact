package frc.robot.utils.statemachine;

public class ElevatorStateMachine extends MotorStateMachine {
    
    // stores the current state of the state machine
    private ElevatorState state;
    private boolean posUp;
    private boolean posDown;

    private static final BTN_UP = 0;
    private static final BTN_DOWN = 1;
    private static final SW_UP = 2;
    private static final SW_DOWN = 3;

    /**
     * Constructor.
     * 
     * @param maxMotorPower the maximum allowable motor power output
     */
    public ElevatorStateMachine(double maxMotorPower) {
        super(maxMotorPower);
        motorPower = 0.0;
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
        switch (state){
            case RESET:
                motorPower = 0.0;
                posUp = inputs[SW_UP];
                posDown = inputs[SW_DOWN];
                state = ElevatorState.IDLE;
                break;
            
            case IDLE:
                motorPower = 0.0;
                if(inputs[BTN_UP] && !inputs[BTN_DOWN] && !posUp){
                    state = ElevatorState.MOVING_UP;
                } else if(inputs[BTN_DOWN] && !inputs[BTN_UP] && !posDown){
                    state = ElevatorState.MOVING_DOWN;
                }
                break;
            
            case MOVING_UP:
                motorPower = maxMotorPower;
                if (!inputs[BTN_UP]){
                    state = ElevatorState.IDLE;
                }else if (inputs[BTN_UP] && inputs[SW_UP]){
                    state = ElevatorState.UP;
                }
                break;

            case UP:
                motorPower = 0.0;
                posUp = true;
                if (!inputs[BTN_UP]){
                    state = ElevatorState.IDLE;
                }
                break;

            case MOVING_DOWN:
                motorPower = -maxMotorPower;
                if (!inputs[BTN_DOWN]){
                    state = ElevatorState.IDLE;
                }else if (inputs[BTN_DOWN] && inputs[SW_DOWN]){
                    state = ElevatorState.DOWN;
                }
                break;

            case DOWN:
                motorPower = 0.0;
                posDown = true;
                break;
        }
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
        return 4;
    }

}

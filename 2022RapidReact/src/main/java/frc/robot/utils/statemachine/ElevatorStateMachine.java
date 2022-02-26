package frc.robot.utils.statemachine;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorStateMachine extends MotorStateMachine {
    
    // stores the current state of the state machine
    private ElevatorState state;
    private boolean posUp;
    private boolean posDown;

    private static final int BTN_UP = 0;
    private static final int BTN_DOWN = 1;
    private static final int SW_UP = 2;
    private static final int SW_DOWN = 3;

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
                // SmartDashboard.putString("state", "RESET");
                break;
            
            case IDLE:
                motorPower = 0.0;
                if(inputs[BTN_UP] && !inputs[BTN_DOWN] && !posUp){
                    state = ElevatorState.MOVING_UP;
                } else if(inputs[BTN_DOWN] && !inputs[BTN_UP] && !posDown){
                    state = ElevatorState.MOVING_DOWN;
                }
                // SmartDashboard.putString("state", "IDLE");
                break;
            
            case MOVING_UP:
                motorPower = maxMotorPower;
                posDown = false;
                if (!inputs[BTN_UP]){
                    state = ElevatorState.IDLE;
                }else if (inputs[BTN_UP] && inputs[SW_UP]){
                    state = ElevatorState.UP;
                }
                // SmartDashboard.putString("state", "Moving UP");
                break;

            case UP:
                motorPower = 0.0;
                posUp = true;
                if (!inputs[BTN_UP]){
                    state = ElevatorState.IDLE;
                }
                // SmartDashboard.putString("state", "UP");
                break;

            case MOVING_DOWN:
                motorPower = -maxMotorPower;
                posUp = false;
                if (!inputs[BTN_DOWN]){
                    state = ElevatorState.IDLE;
                }else if (inputs[BTN_DOWN] && inputs[SW_DOWN]){
                    state = ElevatorState.DOWN;
                }
                // SmartDashboard.putString("state", "Moving Down");
                break;

            case DOWN:
                motorPower = 0.0;
                posDown = true;
                if(!inputs[BTN_DOWN]){
                    state = ElevatorState.IDLE;
                }
                // SmartDashboard.putString("state", "Down");
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

    @Override
    public String toString(){
        String str = "";
        switch (state){
            case RESET:
                str = str.concat("Reset");
                break;
            case IDLE:
                str = str.concat("IDLE");
                break;
            case MOVING_UP:
                str = str.concat("MOVING UP");
                break;
            case UP:
                str = str.concat("UP");
                break;
            case MOVING_DOWN:
                str = str.concat("MOVING DOWN");
                break;
            case DOWN:
                str = str.concat("DOWN");
                break;
            default:
                str = str.concat("Unknown");
                break;
        }

        // str = str.concat(" posUp: " + posUp + " posDown: " + posDown);
        str = str.concat(" motorPower: " + motorPower);

        return str;
    }
}

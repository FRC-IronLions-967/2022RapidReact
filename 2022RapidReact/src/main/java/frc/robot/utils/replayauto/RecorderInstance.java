package frc.robot.utils.replayauto;

public class RecorderInstance {

    public ReplayAutoRecorder recorder;

    private static RecorderInstance inst;

    private RecorderInstance() {
        recorder = new ReplayAutoRecorder(new String[] {"rightpower", "leftpower", "flywheelon", "kickerpower", "rollerpower", "armpower"});
    }

    public static RecorderInstance getInstance() {
        if(inst == null) {
            inst = new RecorderInstance();
        }

        return inst;
    }


}

package frc.robot.utils.replayauto;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;

import edu.wpi.first.wpilibj.DriverStation;

public class ReplayAutoRecorder {

    private File recordFile;
    private PrintWriter writer;
    private long startTime;
    private HashMap < String, Object > fields;
    private String[] fieldNames;

    public ReplayAutoRecorder(String[] fieldNames) {
        startTime = System.currentTimeMillis();
        this.fieldNames = fieldNames;
        fields = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        String path = String.format("/home/lvuser/recordings/recording_%d_%d_%d:%d:%d.csv",
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        recordFile = new File(path);

        try {
            writer = new PrintWriter(new FileWriter(recordFile), true);
            String header = "Timestamp";
            for(String s : fieldNames){
                header = header.concat("," + s);
                fields.put(s, new Object());
            }
            writer.println(header);
        } catch (IOException e) {
            DriverStation.reportError(e.getMessage(), e.getStackTrace());

        }
    }
    public void updateField(String name, Object value){
        if(fields.containsKey(name)){
            fields.put(name, value);
        }
    }

    public void recordLine(){
        String line = Long.toString(System.currentTimeMillis() - startTime);
        for(String s : fieldNames){
            line = line.concat("," + fields.get(s).toString());
        }
        writer.println(line);
        writer.flush();
    }

}

package frc.robot.autonomous;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.subsystems.*;

public class ShootReplayAuto implements Autonomous {
    
    private File replayFile;
    private Scanner inputReplay;
    private SubsystemsInstance subInstance;
    private long startTime;
    private long offSet;
    private String[] curLine;
    private boolean done = false;

    private HashMap<String, Integer> fieldIndices;

    public ShootReplayAuto(String fileName) {
        replayFile = new File(fileName);
        subInstance = SubsystemsInstance.getInstance();
        fieldIndices = new HashMap<>();

        try {
            inputReplay = new Scanner(replayFile);
            String line = inputReplay.nextLine();
            String[] names = line.split(",");
            for(int i = 0; i < names.length; i++) {
                fieldIndices.put(names[i], i);
            }
        } catch (FileNotFoundException e) {
            DriverStation.reportError(e.getMessage(), e.getStackTrace());
        }
    }

    @Override
    public void init() {
        startTime = System.currentTimeMillis();
        String line = inputReplay.nextLine();
        curLine = line.split(",");
        offSet = Long.parseLong(curLine[fieldIndices.get("Timestamp")]);
    }

    @Override
    public void periodic() {
        if(done) return;
        long curTime = Long.parseLong(curLine[0]);
        if((System.currentTimeMillis() - startTime) >= (curTime - offSet)){
            subInstance.m_driveSubsystem.move(Double.parseDouble(curLine[fieldIndices.get("rightpower")]), Double.parseDouble(curLine[fieldIndices.get("leftpower")]));
            subInstance.m_flyWheelSubsystem.runFlyWheel(Boolean.parseBoolean(curLine[fieldIndices.get("flywheelon")]));
            subInstance.m_shooterSubsystem.runKicker(Double.parseDouble(curLine[fieldIndices.get("kickerpower")]));
            subInstance.m_rollerSubsystem.runRoller(Double.parseDouble(curLine[fieldIndices.get("rollerpower")]));
            subInstance.m_rollerSubsystem.runArmWinch(Double.parseDouble(curLine[fieldIndices.get("armpower")]));
            if(inputReplay.hasNextLine()) {
                curLine = inputReplay.nextLine().split(",");
            } else {
                done = true;
            }
        }
    }

}

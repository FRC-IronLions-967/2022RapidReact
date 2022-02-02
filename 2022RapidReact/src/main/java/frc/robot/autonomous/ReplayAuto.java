package frc.robot.autonomous;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.subsystems.SubsystemsInstance;

public class ReplayAuto implements Autonomous{

    private File replayFile;
    private Scanner inputReplay;
    private SubsystemsInstance subInstance;
    private long startTime;
    private long offSet;
    private String[] curLine;


    public ReplayAuto(String fileName){
        replayFile = new File(fileName);
        subInstance = SubsystemsInstance.getInstance();
        
        try {
            inputReplay = new Scanner(replayFile);
            inputReplay.nextLine();
        } catch (FileNotFoundException e) {
            DriverStation.reportError(e.getMessage(), e.getStackTrace());
        }
       


    }


    @Override
    public void init(){
        startTime = System.currentTimeMillis();
        String line = inputReplay.nextLine();
        curLine = line.split(",");
        offSet = Long.parseLong(curLine[0]);

    }

    @Override
    public void periodic(){
        long curTime = Long.parseLong(curLine[0]);
        if((System.currentTimeMillis() - startTime) >= (curTime - offSet)){
            subInstance.m_driveSubsystem.move(Double.parseDouble(curLine[1]), Double.parseDouble(curLine[2]));
            curLine = inputReplay.nextLine().split(",");
        }


    }
}

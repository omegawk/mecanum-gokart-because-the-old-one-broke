package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MecanumDrivetrainsubsystem;

public class MecanumDriveCommand extends Command{
    private final Supplier<Double> xSupplier, ySupplier, zSupplier;


    private final MecanumDrivetrainsubsystem drivesubsytem;

    public MecanumDriveCommand(MecanumDrivetrainsubsystem drivesubsystem,Supplier<Double> xSupplier,Supplier<Double> ySupplier,Supplier<Double> zSupplier){    
        this.drivesubsytem = drivesubsystem;
        addRequirements(drivesubsystem);
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.zSupplier = zSupplier;
    }
@Override
public void initialize(){

}

@Override
public void execute(){
    double xvalue = xSupplier.get();
    double yvalue = ySupplier.get();
    double zvalue = zSupplier.get();
    if(xvalue<.1 && xvalue>-.1){
        xvalue=0;
    }
    if(yvalue<.1 && yvalue>-.1){
        yvalue=0;
    }
    if(zvalue<.1 && zvalue>-.1){
        zvalue=0;
    }
    drivesubsytem.drive(xvalue,yvalue,zvalue);
    
    System.out.println("xvalue:" + xvalue + "\n yvalue:"+yvalue+"\nzvalue"+zvalue);
}
@Override
public void end(boolean interrupted){

}

@Override
public boolean isFinished(){
    return false;
    }
}
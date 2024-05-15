package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class MecanumDrivetrainsubsystem extends SubsystemBase{
    private CANSparkMax frontleft;
    private CANSparkMax frontright;
    private CANSparkMax backleft;
    private CANSparkMax backright;
    public MecanumDrive m_robotdrive;
    public Joystick m_stick;
    private RelativeEncoder frontleftEncoder;
    private RelativeEncoder frontrightEncoder;

    public MecanumDrivetrainsubsystem(){
        frontleft = new CANSparkMax(Constants.motorconstants.frontleft, MotorType.kBrushless);
        frontright = new CANSparkMax(Constants.motorconstants.frontright, MotorType.kBrushless);
        backleft = new CANSparkMax(Constants.motorconstants.backleft, MotorType.kBrushless);
        backright = new CANSparkMax(Constants.motorconstants.backright, MotorType.kBrushless);
        frontleftEncoder = frontleft.getEncoder();
        frontrightEncoder = frontright.getEncoder();
        frontleft.setInverted(true);
        backleft.setInverted(true);

        SendableRegistry.addChild(m_robotdrive, backleft);
        SendableRegistry.addChild(m_robotdrive, backright);
        SendableRegistry.addChild(m_robotdrive, frontleft);
        SendableRegistry.addChild(m_robotdrive, frontright);
        
        m_robotdrive = new MecanumDrive(frontleft::set, backleft::set, frontright::set, backright::set);

        m_stick = new Joystick(Constants.OperatorConstants.kDriverControllerPort);
    }

    public void drive(double xvalue,double yvalue,double zvalue){
        m_robotdrive.driveCartesian(xvalue, -yvalue, -zvalue);
    }

    
}

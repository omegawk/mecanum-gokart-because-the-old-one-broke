// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.MecanumDriveCommand;
import frc.robot.subsystems.MecanumDrivetrainsubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;



public class RobotContainer {
  private final MecanumDrivetrainsubsystem m_MecanumDrivetrainsubsystem = new MecanumDrivetrainsubsystem();
  private Joystick m_stick;
  

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    
    m_stick = new Joystick(Constants.OperatorConstants.kDriverControllerPort);
    configureBindings();
    m_MecanumDrivetrainsubsystem.setDefaultCommand(new MecanumDriveCommand(
      m_MecanumDrivetrainsubsystem,
      ()-> m_stick.getRawAxis(OperatorConstants.kxaxis),
      ()-> m_stick.getRawAxis(OperatorConstants.kyaxis),
      ()-> m_stick.getRawAxis(OperatorConstants.kzaxis)
    ));
  
  }

  
  private void configureBindings() {
    
  }
}

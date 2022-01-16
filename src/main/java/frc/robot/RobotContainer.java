// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems are defined here:
  private final DrivetrainSubsytem m_drivetrain = new DrivetrainSubsytem();


  // Robot's Commands defined here if not bound to Joystick:
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_drivetrain);

  //Robot's Controllers & Joysticks:
  private final XboxController m_xbox = new XboxController(0);

  //Sendable Chooser - For selected automous commands
 // SendableChooser<Command> m_chooser = new SendableChooser<>();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //Smartdashboard Subsystems:
    SmartDashboard.putData(m_drivetrain);
    
    

    //Smartdashboard Buttons:

 
    //Default Commands:
    m_drivetrain.setDefaultCommand(
      new AcadeDrive(m_xbox::getLeftY, m_xbox::getRightX, m_drivetrain)
    );


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    /** An example for binding commands to joystick
     * final JoystickButton xboxButton1 = new JoystickButton(xboxController1, XboxController.Button.kA.value);        
xboxButton1.whenPressed(new ShooterMotorOnCommand( m_shooter ) ,true);
    SmartDashboard.putData("Xbox Button 1",new ShooterMotorOnCommand( m_shooter ) );
     */
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous - use return m_chooser.getSelected(); in future when sendable chooser works
    return m_autoCommand;
  }
}

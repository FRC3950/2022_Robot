// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsytem;

public class AutoDriveCommand extends CommandBase {
private DrivetrainSubsytem subsystem;
private double speed, seconds;

  /** Creates a new AutoDriveCommand. */
  public AutoDriveCommand(DrivetrainSubsytem subsystem, double speed, double seconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speed = speed;
    this.subsystem = subsystem;
    this.seconds = seconds;
    addRequirements(subsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    subsystem.resetTimer();
    // subsystem.drive(speed, 0);
    


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    subsystem.drive(speed, 0);

    // if(subsystem.getTimeDrive()< seconds){
    //   subsystem.drive(speed, 0);
    // }else{
    //     subsystem.drive(0, 0);
    // }


    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(subsystem.getTimeDrive()<seconds){
      return false;
    }else{
      subsystem.drive(0, 0);
      return true;
    }
    
  }
}

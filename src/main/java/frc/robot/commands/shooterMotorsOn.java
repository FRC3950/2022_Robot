// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

<<<<<<< HEAD
=======

>>>>>>> 177e0c1d7a88dcea18be365ce30c4905565530c6
public class shooterMotorsOn extends CommandBase {
private  double bottom, top, conveyor;
ShooterSubsystem shooterSubsystem;

  /** Creates a new shooterMotorsOn. */
  public shooterMotorsOn(double bottom, double top, double conveyor, ShooterSubsystem shooterSubsystem) {
    this.bottom = bottom;
    this.top = top;
    this.conveyor = conveyor;
    this.shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooterSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.motorOn(bottom, top, conveyor);
    SmartDashboard.putNumber("bottom U/100MS (Default 12,000)", bottom);
    SmartDashboard.putNumber("top U/100MS (Default 12,000)", top);
    SmartDashboard.putNumber("Conveyor Output", conveyor);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.motorOn(SmartDashboard.getNumber("bottom U/100MS (Default 12,000)", bottom), SmartDashboard.getNumber("bottom U/100MS (Default 12,000)", top), SmartDashboard.getNumber("Conveyor Output", 0.5));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.motorOn(0, 0, 0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

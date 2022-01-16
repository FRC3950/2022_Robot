// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsytem;

public class AcadeDrive extends CommandBase {

  private final DrivetrainSubsytem m_drivetrain;
  private final DoubleSupplier m_foward;
  private final DoubleSupplier m_turn;

  /** Creates a new AcadeDrive. */
  public AcadeDrive(DoubleSupplier foward, DoubleSupplier turn, DrivetrainSubsytem drivetrain) {
    m_drivetrain = drivetrain;
    m_foward = foward;
    m_turn = turn; 

    addRequirements(m_drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_drivetrain.drive(m_foward.getAsDouble(), m_turn.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

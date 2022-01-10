// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonFX m_frontLeft = new WPI_TalonFX(Constants.k_frontLeft);
  private final WPI_TalonFX m_frontRight = new WPI_TalonFX(Constants.k_frontRight);
  private final WPI_TalonFX m_backLeft = new WPI_TalonFX(Constants.k_backLeft);
  private final WPI_TalonFX m_backRight = new WPI_TalonFX(Constants.k_backRight);

  DifferentialDrive m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);


  public Drivetrain() {
    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double x, double y){

    m_drive.arcadeDrive(x, y);

  }
}

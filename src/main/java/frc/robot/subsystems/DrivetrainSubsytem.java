// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DrivetrainSubsytem extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final WPI_TalonFX m_frontLeft = new WPI_TalonFX(Constants.k_frontLeft);
  private final WPI_TalonFX m_frontRight = new WPI_TalonFX(Constants.k_frontRight);
  private final WPI_TalonFX m_backLeft = new WPI_TalonFX(Constants.k_backLeft);
  private final WPI_TalonFX m_backRight = new WPI_TalonFX(Constants.k_backRight);

  private WPI_TalonFX dog;
  private TalonFX ele;
  private TalonSRX frank;



  DifferentialDrive m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);
  


  public DrivetrainSubsytem() {
    super();
    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);

    dog = new WPI_TalonFX(6);
    ele = new TalonFX(7);
    frank = new TalonSRX(8);


    // m_backLeft.setName()


    //LiveWindow
    addChild("a diff drive", m_drive);
    addChild("b right motor controller", m_backRight);
    
    
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
  }

  public void drive(double x, double y){

    m_drive.arcadeDrive(x, y);

  }

  public void log(){
    SmartDashboard.putNumber("Motor Output Front-Left: ", m_frontLeft.get());    
    SmartDashboard.putNumber("Velocity Front-Left: ", m_frontLeft.getSelectedSensorVelocity());    
    


    
    
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

private final WPI_TalonFX m_bottom;
private final WPI_TalonFX m_Slave;
private final WPI_TalonSRX m_conveyor;

private static final double kP_vel1 = 0.01, kP_vel2 = 0.01;
private static final double kI_vel1 = 0.000001, kI_vel2 = 0.000001;
private static final double kf= 0.047;
private static final double kD_vel1 = 0, kD_vel2 = 0;
private static final double closed_loop_ramp = 0.2;
public static final int internal_zone = 100; //likely not needed

Orchestra orchestra = new Orchestra();

  /** Creates a new OneOfTheShootFalcons. */
  public ShooterSubsystem() {

    m_conveyor = new WPI_TalonSRX(8);

    m_bottom = new WPI_TalonFX(13); //bottom
    m_Slave= new WPI_TalonFX(12);

    m_bottom.configFactoryDefault();
    m_Slave.configFactoryDefault();

    m_bottom.setNeutralMode(NeutralMode.Coast);
    m_Slave.setNeutralMode(NeutralMode.Coast);


    m_bottom.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0, 10); //Read more into timeout Param
    m_Slave.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    

    m_bottom.setInverted(true);
    m_bottom.setSensorPhase(false); //need to check that we are getting positive data, switch bool elseul[[]]
   m_Slave.setSensorPhase(false);

   m_bottom.config_kF(0, kf);
   m_Slave.config_kF(0, kf);

   m_bottom.config_kP(0, kP_vel1);
   m_Slave.config_kP(0, kP_vel1);

   m_bottom.config_kI(0, kI_vel1);
   m_Slave.config_kI(0, kI_vel1);


    

   orchestra.addInstrument(m_bottom);
    orchestra.addInstrument(m_Slave);
    orchestra.loadMusic("butterfly.chrp");
   

   
   
    //Set Velocity and what we set and feed in a value. This is every 100Ms. Pretty sure
    //Falcon's have 2048 per revolution. So 2048/10 will give one rotation per second with the below
    //... which is slow
    //m_Slave.set(ControlMode.Velocity, 2048/10);



  
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void playSong(){
    
   orchestra.play();
   
  }

  public void motorOn(){
    m_bottom.set(ControlMode.Velocity, 11500);
    m_Slave.set(ControlMode.Velocity,11000);
    m_conveyor.set(.9);



  }
}

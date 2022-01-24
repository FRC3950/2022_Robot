// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

private final WPI_TalonFX musicMotor;
private final WPI_TalonFX otherMotor;

private int counter = 0;

Orchestra orchestra = new Orchestra();

  /** Creates a new OneOfTheShootFalcons. */
  public ShooterSubsystem() {

    

    musicMotor = new WPI_TalonFX(13);
    otherMotor= new WPI_TalonFX(12);
    addChild("Test", otherMotor);

    musicMotor.configFactoryDefault();
    otherMotor.configFactoryDefault();

    musicMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    //We need to set the internal sensor the be the one active
    otherMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    //Set Velocity and what we set and feed in a value. This is every 100Ms. Pretty sure
    //Falcon's have 2048 per revolution. So 2048/10 will give one rotation per second with the below
    //... which is slow
    otherMotor.set(ControlMode.Velocity, 2048/10);


    orchestra.addInstrument(musicMotor);
    orchestra.addInstrument(otherMotor);
    orchestra.loadMusic("butterfly.chrp");

    
  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("Counter", counter++);
    // This method will be called once per scheduler run
  }

  public void playSong(){
   orchestra.play();
   
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OneOfTheShootFalcons extends SubsystemBase {
private final WPI_TalonFX musicMotor;
private final WPI_TalonFX otherMotor;
private int counter = 0;

Orchestra orchestra = new Orchestra();

  /** Creates a new OneOfTheShootFalcons. */
  public OneOfTheShootFalcons() {

    

    musicMotor = new WPI_TalonFX(13);
    otherMotor= new WPI_TalonFX(12);
    addChild("Test", otherMotor);

    musicMotor.configFactoryDefault();
    otherMotor.configFactoryDefault();

    musicMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    otherMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);


    orchestra.addInstrument(musicMotor);
    orchestra.loadMusic("mermaid.chrp");

    
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

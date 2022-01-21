// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OneOfTheShootFalcons extends SubsystemBase {
private final WPI_TalonFX musicMotor;

Orchestra orchestra = new Orchestra();

  /** Creates a new OneOfTheShootFalcons. */
  public OneOfTheShootFalcons() {

    musicMotor = new WPI_TalonFX(13);
    orchestra.addInstrument(musicMotor);
    orchestra.loadMusic("mermaid.chrp");
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void playSong(){
   orchestra.play();
  }
}

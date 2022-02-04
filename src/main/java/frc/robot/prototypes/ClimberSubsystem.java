// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.prototypes;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
<<<<<<< HEAD:src/main/java/frc/robot/prototypes/ClimberSubsystem.java
import edu.wpi.first.wpilibj.DoubleSolenoid.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
import edu.wpi.first.wpilibj2.command.SubsystemBase;


>>>>>>> c610ab4dfced9917f0b766541bc93b538144df8b:src/main/java/frc/robot/subsystems/ClimberSubsystem.java

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. **/
  //Numbers below are placeholders
  DoubleSolenoid[] solenoids = {
    new DoubleSolenoid(PneumaticsModuleType.REVPH, 1,0), //left A 
    new DoubleSolenoid(PneumaticsModuleType.REVPH, 2,0), //left B
    new DoubleSolenoid(PneumaticsModuleType.REVPH, 3,0), //right A
    new DoubleSolenoid(PneumaticsModuleType.REVPH, 4,0) // right B
  };

  boolean[] values = new boolean[4];

  public ClimberSubsystem(){}

  @Override
  public void periodic() {
    SmartDashboard.putBooleanArray("Pneumatics", getValues());
  }
  /*
  Possible scenarios of high, medium, low bar (ideally)
  Medium && low bar -- first set of pistons, high bar -- both sets 
  Assuming solenoids[0] and solenoids[2] will be used for half extension
  */
  public void retractAll(){
    //If one of the two solenoids used in the "half-extension" is not down, then none of the other solenoids are down
    if(solenoids[0].get() != Value.kReverse){ 
      for(final DoubleSolenoid s : solenoids){
        s.set(Value.kReverse);
      }
    }
  }

  public void extendAll(){
    for(final DoubleSolenoid s : solenoids){
      s.set(Value.kForward);
    }
  }

  public void toggleAll(){
    for(final DoubleSolenoid s : solenoids){
      s.toggle();
    }
  }

  public void halfRetract(){
    if(solenoids[0].get() != Value.kReverse){
      solenoids[0].set(Value.kReverse);
      solenoids[2].set(Value.kReverse);
    }
  }

  public void halfExtend(){
    if(solenoids[0].get() != Value.kForward){
      solenoids[0].set(Value.kForward);
      solenoids[2].set(Value.kForward);
    }
  }

  public void halfToggle(){
    solenoids[0].toggle();
    solenoids[2].toggle();
  }

  public boolean[] getValues(){
    for(int i = 0; i < 4; i++){
<<<<<<< HEAD:src/main/java/frc/robot/prototypes/ClimberSubsystem.java
      values[i] = (solenoids[i].get() == Value.kForward) ? true : false;
=======
      if(solenoids[i].get() == DoubleSolenoid.Value.kForward){
        values[i] = true;
      }
      else if(solenoids[i].get() == DoubleSolenoid.Value.kReverse){
        values[i] = false;
      }
>>>>>>> c610ab4dfced9917f0b766541bc93b538144df8b:src/main/java/frc/robot/subsystems/ClimberSubsystem.java
    }
    return values;
  }
}

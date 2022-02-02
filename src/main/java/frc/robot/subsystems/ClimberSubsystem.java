// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.*;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */
  //Numbers below are placeholders
  DoubleSolenoid[] solenoids = {
    new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1,0), //left A 
    new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2,0), //left B
    new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3,0), //right A
    new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4,0) // right B
  };

  boolean[] values = new boolean[4];

  public ClimberSubsystem() {}

  @Override
  public void periodic() {}
  
  /*
  Possible scenarios of high, medium, low bar (ideally)
  Medium && low bar -- first set of pistons, high bar -- both sets 
  Assuming solenoids[0] and solenoids[2] will be used for half extension
  */

  public void retractAll(){
    //If one of the two solenoids used in the "half-extension" is not down, then none of the other solenoids are down
    if(solenoids[0].get() != DoubleSolenoid.Value.kReverse){ 
      for(final DoubleSolenoid s : solenoids){
        s.set(DoubleSolenoid.Value.kReverse);
      }
    }
  }

  public void extendAll(){
    for(final DoubleSolenoid s : solenoids){
      s.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void toggleAll(){
    for(final DoubleSolenoid s : solenoids){
      s.toggle();
    }
  }

  public void halfRetract(){
    if(solenoids[0].get() != DoubleSolenoid.Value.kReverse){
      solenoids[0].set(DoubleSolenoid.Value.kReverse);
      solenoids[2].set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void halfExtend(){
    if(solenoids[0].get() != DoubleSolenoid.Value.kForward){
      solenoids[0].set(DoubleSolenoid.Value.kForward);
      solenoids[2].set(DoubleSolenoid.Value.kForward);
    }
  }

  public void halfToggle(){
    solenoids[0].toggle();
    solenoids[2].toggle();
  }

  public boolean[] getValues(){ // <-- for eventual smart dashboard implementation
    for(int i = 0; i < 4; i++){
      if(solenoids[i].get() == DoubleSolenoid.Value.kForward){
        values[i] = true;
      }
      else if(solenoids[i].get() == DoubleSolenoid.Value.kForward){
        values[i] = false;
      }
    }
    return values;
  }
}

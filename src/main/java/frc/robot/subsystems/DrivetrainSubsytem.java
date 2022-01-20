// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.TalonFXSimCollection;

import edu.wpi.first.wpilibj.Timer;

public class DrivetrainSubsytem extends SubsystemBase {
  /** Creates a new Drivetrain. */

  final int kUnitsPerRevolution = 2048; /* this is constant for Talon FX */

  // Conversion -> 1 rotation/ 2048 * gear ration * 6pi inchies / 1 rotation * 1feet/12 icnes -> feet
  // private final double kDriveTick2Feet = above

  private final WPI_TalonFX m_frontLeft = new WPI_TalonFX(Constants.k_frontLeft);
  private final WPI_TalonFX m_frontRight = new WPI_TalonFX(Constants.k_frontRight);
  private final WPI_TalonFX m_backLeft = new WPI_TalonFX(Constants.k_backLeft);
  private final WPI_TalonFX m_backRight = new WPI_TalonFX(Constants.k_backRight);

  // private final WPI_TalonSRX leftMotor = new WPI_TalonSRX(0);
  // private final WPI_TalonSRX rightMotor = new WPI_TalonSRX(15);


  TalonFXSimCollection testSim;

  
  private Timer driveTimer = new Timer();

  DifferentialDrive m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);

  
  private final Field2d m_field = new Field2d();



  double d;


  public DrivetrainSubsytem() {
    super();
  

     m_frontRight.configFactoryDefault();
     m_backLeft.configFactoryDefault();
     m_frontLeft.configFactoryDefault(); 
     m_backRight.configFactoryDefault(); 
     
     m_frontRight.setNeutralMode(NeutralMode.Brake);
     m_frontLeft.setNeutralMode(NeutralMode.Brake);


    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);

// m_frontLeft.set(ControlMode.Position, value);



    //Might need the below to ensure wheel direction:
//////////////////
    //m_frontRight.setInverted(TalonFXInvertType.Clockwise); 
    //m_frontLeft.setInverted(TalonFXInvertType.CounterClockwise); 

    // set the invert of the followers to match their respective master controllers
    
    // m_backRight.setInverted(InvertType.FollowMaster);
    //m_backLeft.setInverted(InvertType.FollowMaster);
//////////////////////
  


//Encoders
m_frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

//Simulated Encoder
// leftSimEncoder = m_frontLeft.getSimCollection();
// leftSimEncoder.setIntegratedSensorRawPosition(1);

 


//Gyro


    //LiveWindow
    addChild("a diff drive", m_drive);
    // addChild("b right motor controller", m_backRight);
    // addChild("Motor TEst", test);
    // addChild("gyro", m_gyro);
    // addChild("Motor on Drive -front right", m_frontRight);
    
    
    SmartDashboard.putData("Field", m_field);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    log();
   
  }

  public void drive(double x, double y){

    m_drive.arcadeDrive(x, y);
     
    // d += x;
    
    // m_odometry.update(m_gyro.getRotation2d(), 0.1*d, 0.1*d);

  }

  public void motorOn(){

    
  }

  public void log(){
    SmartDashboard.putNumber("Motor Output Front-Left: ", m_frontLeft.get());    
    SmartDashboard.putNumber("Velocity Front-Left: ", m_frontLeft.getSelectedSensorVelocity());   
   
  }


public void resetTimer(){

  driveTimer.reset();
  driveTimer.start();
}

public double getTimeDrive(){

  return driveTimer.get();
}

public void encoderInfo(){

		/* get the selected sensor for PID0 */
		// double appliedMotorOutput = m_frontLeft.getMotorOutputPercent();
		// double selSenPos = m_frontLeft.getSelectedSensorPosition(0); /* position units */
		// double selSenVel = m_frontLeft.getSelectedSensorVelocity(0); /* position units per 100ms */

		// /* scaling depending on what user wants */
		// double pos_Rotations = (double) selSenPos / kUnitsPerRevolution;
		// double vel_RotPerSec = (double) selSenVel / kUnitsPerRevolution * 10; /* scale per100ms to perSecond */
		// double vel_RotPerMin = vel_RotPerSec * 60.0;

}



}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

// import edu.wpi.first.math.MathUtil;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  private MecanumDrive m_myRobot;

  private CANSparkMax m_frontleftMotor;
  private CANSparkMax m_rearleftMotor;
  private CANSparkMax m_frontrightMotor;
  private CANSparkMax m_rearrightMotor;

  private double m_xSpeed;
  private double m_ySpeed;
  private double m_rotSpeed;
  
  public DrivetrainSubsystem() {
    m_frontleftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
    m_rearleftMotor = new CANSparkMax(Constants.REAR_LEFT_MOTOR_PORT, MotorType.kBrushless);
    m_frontrightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    m_rearrightMotor = new CANSparkMax(Constants.REAR_RIGHT_MOTOR_PORT, MotorType.kBrushless);

    m_frontleftMotor.setIdleMode(IdleMode.kBrake);
    m_rearleftMotor.setIdleMode(IdleMode.kBrake);
    m_frontrightMotor.setIdleMode(IdleMode.kBrake);
    m_rearrightMotor.setIdleMode(IdleMode.kBrake);

    m_myRobot = new MecanumDrive(m_frontleftMotor, m_rearleftMotor, m_frontrightMotor, m_rearrightMotor);
  }

  public void drive(double xSpeed, double ySpeed, double rotSpeed) {
    m_xSpeed=xSpeed;
    m_ySpeed=ySpeed;
    m_rotSpeed=rotSpeed;
  }

  @Override
  public void periodic() {
    m_myRobot.driveCartesian(m_xSpeed, m_ySpeed, m_rotSpeed);
  }

  
}

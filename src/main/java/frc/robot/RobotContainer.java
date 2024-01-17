// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_drivetrainSubsystem;

  private Joystick m_stick;
  private Joystick m_controller;

  // private int m_dpad;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivetrainSubsystem = new DrivetrainSubsystem();

    m_stick = new Joystick(0);
    m_controller = new Joystick(1);

    m_drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(m_drivetrainSubsystem, 
    () -> MathUtil.applyDeadband(m_controller.getRawAxis(0) , 0.05), // side axis 
    () -> MathUtil.applyDeadband(m_controller.getRawAxis(1) , 0.05), // up-down axis
    () -> MathUtil.applyDeadband(m_controller.getRawAxis(5) , 0.05))); // magnitude axis
    configureBindings();
  }

  private void configureBindings() {}


}

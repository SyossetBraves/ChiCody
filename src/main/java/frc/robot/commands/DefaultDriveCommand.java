// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem. */
public class DefaultDriveCommand extends CommandBase {
  private final DrivetrainSubsystem m_drivetrainSubsystem;
  //suppliers must be diagonal and forward backward
  private final DoubleSupplier m_xSupplier;
  private final DoubleSupplier m_ySupplier;
  private final DoubleSupplier m_rotSupplier;


  public DefaultDriveCommand(DrivetrainSubsystem subsystem,
                              DoubleSupplier x,
                              DoubleSupplier y,
                              DoubleSupplier rot) {
    m_drivetrainSubsystem = subsystem;
    m_xSupplier = x;
    m_ySupplier = y;
    m_rotSupplier = rot;
    addRequirements(subsystem);
  }

  

  @Override
  public void execute() {
      m_drivetrainSubsystem.drive(
        m_xSupplier.getAsDouble(), 
        m_ySupplier.getAsDouble(),
        m_rotSupplier.getAsDouble()
      );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.drive(0, 0, 0);
  }

  
}

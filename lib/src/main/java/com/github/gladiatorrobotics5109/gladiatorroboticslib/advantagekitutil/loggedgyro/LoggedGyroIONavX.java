// Disabled until 2025 navx libs
// package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedgyro;

// import com.kauailabs.navx.frc.AHRS;

// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.wpilibj.SPI;

// public class LoggedGyroIONavX implements LoggedGyroIO {
// private final AHRS m_navX;

// private Rotation2d m_yawOffset;
// private Rotation2d m_pitchOffset;
// private Rotation2d m_rollOffset;

// public LoggedGyroIONavX() {
// m_yawOffset = new Rotation2d();
// m_pitchOffset = new Rotation2d();
// m_rollOffset = new Rotation2d();

// m_navX = new AHRS(SPI.Port.kMXP);
// }

// public void updateInputs(LoggedGyroIOInputs inputs) {
// inputs.isConnected = m_navX.isConnected();
// inputs.isSim = false;
// inputs.yaw = m_navX.getRotation2d().plus(m_yawOffset);
// inputs.pitch = Rotation2d.fromDegrees(m_navX.getPitch()).plus(m_pitchOffset);
// inputs.roll = Rotation2d.fromDegrees(m_navX.getRoll()).plus(m_rollOffset);
// }

// public void setYaw(Rotation2d yaw) {
// m_navX.setAngleAdjustment(yaw.getDegrees());
// // m_yawOffset = yaw.minus(m_navX.getRotation2d());
// }

// public void setPitch(Rotation2d pitch) {
// m_pitchOffset = Rotation2d.fromDegrees(pitch.getDegrees() - m_navX.getPitch());
// }

// public void setRoll(Rotation2d roll) {
// m_rollOffset = Rotation2d.fromDegrees(roll.getDegrees() - m_navX.getRoll());
// }
// }

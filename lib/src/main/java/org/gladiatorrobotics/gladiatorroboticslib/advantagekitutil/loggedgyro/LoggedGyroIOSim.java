package org.gladiatorrobotics.gladiatorroboticslib.advantagekitutil.loggedgyro;

import edu.wpi.first.math.geometry.Rotation2d;

public class LoggedGyroIOSim implements LoggedGyroIO {
    private Rotation2d m_yaw;
    private Rotation2d m_pitch;
    private Rotation2d m_roll;

    public LoggedGyroIOSim() {
        m_yaw = new Rotation2d();
        m_pitch = new Rotation2d();
        m_roll = new Rotation2d();
    }

    @Override
    public void updateInputs(LoggedGyroIOInputs inputs) {
        inputs.isConnected = true;
        inputs.isSim = true;
        inputs.yaw = m_yaw;
        inputs.pitch = m_pitch;
        inputs.roll = m_roll;
    }

    public void setYaw(Rotation2d yaw) {
        m_yaw = yaw;
    }

    public void setPitch(Rotation2d pitch) {
        m_pitch = pitch;
    }

    public void setRoll(Rotation2d roll) {
        m_roll = roll;
    }
}

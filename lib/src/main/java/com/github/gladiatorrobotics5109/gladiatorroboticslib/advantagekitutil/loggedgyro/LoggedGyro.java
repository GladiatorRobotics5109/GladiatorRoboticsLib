package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedgyro;

import org.littletonrobotics.junction.Logger;

import com.github.gladiatorrobotics5109.gladiatorroboticslib.PeriodicUtil.PeriodicBase;

import edu.wpi.first.math.geometry.Rotation2d;

public class LoggedGyro extends PeriodicBase {
    private final String m_key;
    private final LoggedGyroIO m_io;
    private final LoggedGyroIOInputsAutoLogged m_inputs;

    public LoggedGyro(String key, LoggedGyroIO io) {
        m_key = key;
        m_io = io;
        m_inputs = new LoggedGyroIOInputsAutoLogged();
    }

    public boolean isConnected() {
        return m_inputs.isConnected;
    }

    public boolean isSim() {
        return m_inputs.isSim;
    }

    public Rotation2d getYaw() {
        return m_inputs.yaw;
    }

    public Rotation2d getPitch() {
        return m_inputs.pitch;
    }

    public Rotation2d getRoll() {
        return m_inputs.roll;
    }

    public void setYaw(Rotation2d yaw) {
        m_io.setYaw(yaw);
    }

    public void setPitch(Rotation2d pitch) {
        m_io.setPitch(pitch);
    }

    public void setRoll(Rotation2d roll) {
        m_io.setRoll(roll);
    }

    @Override
    public void periodic() {
        m_io.updateInputs(m_inputs);
        Logger.processInputs(m_key, m_inputs);
    }
}

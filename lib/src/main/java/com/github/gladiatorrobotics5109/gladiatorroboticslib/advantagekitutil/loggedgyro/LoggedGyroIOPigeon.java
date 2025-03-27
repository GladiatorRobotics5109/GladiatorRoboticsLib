package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedgyro;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public class LoggedGyroIOPigeon implements LoggedGyroIO {
    private final Pigeon2 m_pigeon;

    private final StatusSignal<Angle> m_yaw;
    private final StatusSignal<Angle> m_pitch;
    private final StatusSignal<Angle> m_roll;

    public LoggedGyroIOPigeon(int port, String canBus) {
        m_pigeon = new Pigeon2(port, canBus);

        m_pigeon.setYaw(0.0);

        m_yaw = m_pigeon.getYaw();
        m_pitch = m_pigeon.getPitch();
        m_roll = m_pigeon.getRoll();
    }

    public LoggedGyroIOPigeon(int port) {
        this(port, "");
    }

    public void updateInputs(LoggedGyroIOInputs inputs) {
        BaseStatusSignal.refreshAll(m_yaw, m_pitch, m_roll);

        inputs.isConnected = m_pigeon.isConnected();
        inputs.isSim = false;
        inputs.yaw = Rotation2d.fromRadians(m_yaw.getValue().in(Units.Radians));
        inputs.pitch = Rotation2d.fromRadians(m_pitch.getValue().in(Units.Radians));
        inputs.roll = Rotation2d.fromRadians(m_roll.getValue().in(Units.Radians));
    }

    @Override
    public void setYaw(Rotation2d yaw) {
        m_pigeon.setYaw(yaw.getDegrees());
    }

    @Override
    public void setPitch(Rotation2d pitch) {
        throw new UnsupportedOperationException("Unimplemented method 'setPitch'");
    }

    @Override
    public void setRoll(Rotation2d roll) {
        throw new UnsupportedOperationException("Unimplemented method 'setYaw'");
    }
}

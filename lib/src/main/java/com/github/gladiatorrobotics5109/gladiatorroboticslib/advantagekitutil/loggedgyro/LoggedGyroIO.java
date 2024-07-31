package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedgyro;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface LoggedGyroIO {
    @AutoLog
    public static class LoggedGyroIOInputs {
        public boolean isConnected = false;
        public boolean isSim = false;
        public Rotation2d yaw = new Rotation2d();
        public Rotation2d pitch = new Rotation2d();
        public Rotation2d roll = new Rotation2d();
    }

    public default void updateInputs(LoggedGyroIOInputs inputs) {};

    public default void setYaw(Rotation2d yaw) {};

    public default void setPitch(Rotation2d pitch) {};

    public default void setRoll(Rotation2d roll) {};
}

package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedpidcontroller;

import com.github.gladiatorrobotics5109.gladiatorroboticslib.PeriodicUtil;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;

public class LoggedPIDController extends PIDController implements Sendable, AutoCloseable {
    private final String m_key;

    public LoggedPIDController(String key, double kp, double ki, double kd, double period) {
        super(kp, ki, kd, period);
        m_key = key;

        PeriodicUtil.registerPeriodic(this::periodic);
    }

    public LoggedPIDController(String key, double kp, double ki, double kd) {
        this(key, kp, ki, kd, 0.2);
    }

    @Override
    public double calculate(double measurement, double setpoint) {
        double result = super.calculate(measurement, setpoint);

        Logger.recordOutput(m_key + "/P", getP() * getError());
        Logger.recordOutput(m_key + "/I", getI() * getAccumulatedError());
        Logger.recordOutput(m_key + "/D", getD() * getErrorDerivative());
        Logger.recordOutput(m_key + "/Result", result);

        return result;
    }

    @Override
    public double calculate(double measurement) {
        double result = super.calculate(measurement);

        Logger.recordOutput(m_key + "/P", getP() * getError());
        Logger.recordOutput(m_key + "/I", getI() * getAccumulatedError());
        Logger.recordOutput(m_key + "/D", getD() * getErrorDerivative());
        Logger.recordOutput(m_key + "/Result", result);

        return result;
    }

    private void log() {
        Logger.recordOutput(m_key + "/kP", getP());
        Logger.recordOutput(m_key + "/kI", getI());
        Logger.recordOutput(m_key + "/kD", getD());
        Logger.recordOutput(m_key + "/iZone", getIZone());
        Logger.recordOutput(m_key + "/Period", getPeriod());
        Logger.recordOutput(m_key + "/Error", getError());
        Logger.recordOutput(m_key + "/ErrorDerivative", getErrorDerivative());
        Logger.recordOutput(m_key + "/ErrorTolerance", getErrorTolerance());
        Logger.recordOutput(m_key + "/ErrorDerivativeTolerance", getErrorDerivativeTolerance());
        Logger.recordOutput(m_key + "/Setpoint", getSetpoint());
        Logger.recordOutput(m_key + "/AtSetpoint", atSetpoint());
    }

    private void periodic() {
        log();
    }
}

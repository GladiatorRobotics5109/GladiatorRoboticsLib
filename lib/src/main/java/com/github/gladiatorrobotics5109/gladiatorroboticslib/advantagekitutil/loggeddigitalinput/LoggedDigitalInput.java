package com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggeddigitalinput;

import org.littletonrobotics.junction.Logger;

import com.github.gladiatorrobotics5109.gladiatorroboticslib.PeriodicUtil;
import com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.Mode;

public final class LoggedDigitalInput extends PeriodicUtil.PeriodicBase {
    private final LoggedDigitalInputIO m_io;
    private final LoggedDigitalInputIOInputsAutoLogged m_inputs;

    private final String m_key;

    public LoggedDigitalInput(String key, int channel, Mode currentMode) {
        m_key = key;
        switch (currentMode) {
            case REAL:
                m_io = new LoggedDigitalInputIOReal(channel);

                break;
            case SIM:
                m_io = new LoggedDigitalInputIOSim();

                break;
            default:
                m_io = new LoggedDigitalInputIO() {};

                break;
        }

        m_inputs = new LoggedDigitalInputIOInputsAutoLogged();
    }

    public boolean get() {
        return m_inputs.value;
    }

    public int getChannel() { return m_inputs.channel; }

    public int getAnalogTriggerTypeForRouting() { return m_inputs.analogTriggerTypeForRouting; }

    public boolean isAnalogTrigger() { return m_inputs.isAnalogTrigger; }

    public int getPortHandleForRouting() { return m_inputs.portHandleForRouting; }

    @Override
    public void periodic() {
        m_io.updateInputs(m_inputs);
        Logger.processInputs(m_key, m_inputs);
    }
}

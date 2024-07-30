package org.gladiatorrobotics.gladiatorroboticslib.advantagekitutil.loggeddigitalinput;

import org.gladiatorrobotics.gladiatorroboticslib.PeriodicUtil;
import org.gladiatorrobotics.gladiatorroboticslib.advantagekitutil.Mode;
import org.littletonrobotics.junction.Logger;

public final class LoggedDigitalInput extends PeriodicUtil.PeriodicBase {
    private final LoggedDigitalInputIO m_io;
    private final LoggedDigitalInputIOInputsAutoLogged m_inputs;

    private final String m_name;

    public LoggedDigitalInput(String name, int channel, Mode currentMode) {
        m_name = name;
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

    @Override
    public void periodic() {
        m_io.updateInputs(m_inputs);
        Logger.processInputs(m_name, m_inputs);
    }
}

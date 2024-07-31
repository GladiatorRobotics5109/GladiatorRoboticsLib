package com.github.gladiatorrobotics5109.gladiatorroboticslib;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class UtilBase {
    /**
     * Guarantees that Alliance will be a valid value by returning
     * Constants.kDefaultAlliance if DriverStation.getAlliance() is empty
     *
     * @return an {@link Alliance} object instead of the optional returned by
     *         DriverStation.getAlliance()
     */
    public static Alliance getAlliance(Alliance defaultAlliance) {
        return DriverStation.getAlliance().orElse(defaultAlliance);
    }
}

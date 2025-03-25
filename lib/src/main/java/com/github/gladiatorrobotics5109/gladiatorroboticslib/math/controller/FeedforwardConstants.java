package com.github.gladiatorrobotics5109.gladiatorroboticslib.math.controller;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

public record FeedforwardConstants(double ks, double kv, double ka, double kg) {
    public FeedforwardConstants(double ks, double kv) {
        this(ks, kv, 0.0, 0.0);
    }

    /**
     *
     * @param constants {@link SimpleMotorFeedforward} to make the {@link SimpleMotorFeedforward} out of
     *
     * @return {@link SimpleMotorFeedforward} object with the constants of the given {@link FeedforwardConstants}
     */
    public static SimpleMotorFeedforward get(FeedforwardConstants constants) {
        return new SimpleMotorFeedforward(
            constants.ks(),
            constants.kv(),
            constants.ka()
        );
    }

    public static ElevatorFeedforward getElevatorFeedforward(FeedforwardConstants constants) {
        return new ElevatorFeedforward(
            constants.ks(),
            constants.kg(),
            constants.kv(),
            constants.ka()
        );
    }

    public static ArmFeedforward getArmFeedforward(FeedforwardConstants constants) {
        return new ArmFeedforward(
            constants.ks(),
            constants.kg(),
            constants.kv(),
            constants.ka()
        );
    }

    /**
     * @return {@link SimpleMotorFeedforward} object with the constants of this object
     */
    public SimpleMotorFeedforward get() {
        return get(this);
    }

    public ElevatorFeedforward getElevatorFeedforward() { return getElevatorFeedforward(this); }

    public ArmFeedforward getArmFeedforward() { return getArmFeedforward(this); }
}

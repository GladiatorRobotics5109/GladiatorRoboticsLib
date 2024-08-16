package com.github.gladiatorrobotics5109.gladiatorroboticslib.math.controller;

import com.github.gladiatorrobotics5109.gladiatorroboticslib.advantagekitutil.loggedpidcontroller.LoggedPIDController;

import edu.wpi.first.math.controller.PIDController;

public record PIDConstants(
    double kp,
    double ki,
    double kd,
    double iZone,
    boolean enableContinuousInput,
    double minimumInput,
    double maximumInput,
    double positionTolerance,
    double velocityTolerance,
    double maximumIntegral,
    double minimumIntegral
) {
    public static final double kIZone = Double.POSITIVE_INFINITY;
    public static final boolean kEnableContinuousInput = false;
    public static final double kMinimumInput = Double.NEGATIVE_INFINITY;
    public static final double kMaximumInput = Double.POSITIVE_INFINITY;
    public static final double kPositionTolerance = 0.05;
    public static final double kVelocityTolerance = Double.POSITIVE_INFINITY;
    public static final double kMaximumIntegral = 1.0;
    public static final double kMinimumIntegral = -1.0;

    public PIDConstants(
        double kp,
        double ki,
        double kd,
        double iZone,
        boolean enableContinuousInput,
        double minimumInput,
        double maximumInput,
        double positionTolerance,
        double velocityTolerance
    ) {
        this(
            kp,
            ki,
            kd,
            iZone,
            enableContinuousInput,
            minimumInput,
            maximumInput,
            positionTolerance,
            velocityTolerance,
            kMaximumInput,
            kMinimumInput
        );
    }

    public PIDConstants(double kp, double ki, double kd) {
        this(
            kp,
            ki,
            kd,
            kIZone,
            kEnableContinuousInput,
            kMinimumInput,
            kMaximumInput,
            kPositionTolerance,
            kVelocityTolerance
        );
    }

    /**
     * Constructs a {@link PIDController} object with the constants provided.
     *
     * @param constants
     *            {@link PIDConstants} to make the {@link PIDController} out of
     * @return {@link PIDController} object with the constants of the given {@link PIDConstants}
     */
    public static PIDController getPIDController(PIDConstants constants) {
        PIDController controller = new PIDController(constants.kp(), constants.ki(), constants.kd());

        controller.setIZone(constants.iZone());
        if (constants.enableContinuousInput)
            controller.enableContinuousInput(constants.minimumInput(), constants.maximumInput());
        controller.setTolerance(constants.positionTolerance, constants.velocityTolerance);
        controller.setIntegratorRange(constants.minimumIntegral, constants.maximumIntegral);

        return controller;
    }

    /**
     * Constructs a {@link LoggedPIDController} object with the constants provided.
     *
     * @param constants
     *            {@link PIDConstants} to make the {@link LoggedPIDController} out of.
     * @param name
     *            Name of the {@link LoggedPIDController} in NetworkTables
     * @return {@link LoggedPIDController} object with the constants provided.
     */
    public static LoggedPIDController getLoggedPIDController(PIDConstants constants, String name) {
        LoggedPIDController controller = new LoggedPIDController(name, constants.kp(), constants.ki(), constants.kd());

        controller.setIZone(constants.iZone());
        if (constants.enableContinuousInput)
            controller.enableContinuousInput(constants.minimumInput(), constants.maximumInput());
        controller.setTolerance(constants.positionTolerance, constants.velocityTolerance);
        controller.setIntegratorRange(constants.minimumIntegral, constants.maximumIntegral);

        return controller;
    }

    /**
     * Constructs a {@link PIDController} object with the constants of this object.
     *
     * @return {@link PIDController} object with the constants of the given {@link PIDConstants}
     */
    public PIDController getPIDController() {
        return getPIDController(this);
    }

    /**
     * Constructs a {@link LoggedPIDController} object with the constants of this object.
     *
     * @param name
     *            Name of the {@link LoggedPIDController} in NetworkTables
     * @return {@link LoggedPIDController} object with the constants of this object.
     */
    public LoggedPIDController getLoggedPIDController(String name) {
        return getLoggedPIDController(this, name);
    }
}
